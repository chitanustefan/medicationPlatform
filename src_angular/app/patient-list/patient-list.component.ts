import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {MatTableDataSource, MatSort, MatPaginator, MatDialog, MatDialogConfig } from '@angular/material';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient.service';
import { PatientEditComponent } from '../patient-edit/patient-edit.component';
import { User } from '../model/user';
import {DomSanitizer} from '@angular/platform-browser';
import {MatIconRegistry} from '@angular/material/icon';
import { AddPatientComponent } from '../add-patient/add-patient.component';
import { DelPatientComponent } from '../del-patient/del-patient.component';
import { MedplanEditComponent } from '../medplan-edit/medplan-edit.component';
import { ActivityService } from '../service/activity.service';
import { Monitoreddata2 } from '../model/monitoreddata2';
import { DatePipe } from '@angular/common';
import { MedicationService } from '../service/medication.service';
import { Medication } from '../model/medication';
import { Medicationplan } from '../model/medicationplan';
import { Medicationtaken } from '../model/medicationtaken';
import { StompService, StompConfig, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import { MessageService } from '../service/message.service';
import { Recomandation } from '../model/recomandation';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  patients: Patient[];
  activities: Monitoreddata2[];
  medications: Medication[];
  allMeds: Medication[];
  medTaken: Medicationtaken[];
  list: MatTableDataSource<any>;
  id_user: number;
  id: number;
  id2: number;
  isShow = false;
  datePicker: Date;
  datePicker2: Date;
  reco: string;
  recom: Recomandation;

  WEBSOCKET_URL = 'ws://@localhost:8080/socket';
  EXAMPLE_URL = '/topic/server-broadcaster';
  
  messageHistory = [];
  state = 'NOT CONNECTED';

  private messagingService: MessageService;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private patientService: PatientService,
    private activityService: ActivityService,
    private dialog: MatDialog,
    private datePipe: DatePipe,
    private medicationService: MedicationService,
    iconRegistry: MatIconRegistry, 
    sanitizer: DomSanitizer 
  ) { iconRegistry.addSvgIcon(
    'thumbs-up',
    sanitizer.bypassSecurityTrustResourceUrl('assets/add-user-button.svg'));

    this.messagingService = new MessageService(this.WEBSOCKET_URL, this.EXAMPLE_URL);

    // Subscribe to its stream (to listen on messages)
    this.messagingService.stream().subscribe((message: Message) => {
      this.messageHistory.unshift(message.body);
      console.log(message);
    });

    // Subscribe to its state (to know its connected or not)
    this.messagingService.state().subscribe((state: StompState) => {
      this.state = StompState[state];
    });

    }
  displayedColumns: string[] = ['id_patient', 'name', 'gender', 'birthday', 'email','actions'];

  ngOnInit() {
    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });

    this.patientService.getAllPatients(this.id_user).subscribe(
      response => {this.patients = response; this.list = new MatTableDataSource(response);
                   this.list.paginator = this.paginator; }
      );
      
    

  }

  addReco(): void{
    console.log(this.reco);
    this.activityService.postRecomandation(this.id, this.reco, this.date).subscribe(response =>{this.recom = response; });
  }

    date: string;
    // Pie
    public pieChartLabels:string[] = ['Toileting', 'Showering', 'Breakfast','Grooming','Spare_Time/TV','Leaving','Lunch','Snack'];
    public pieChartData:number[] = [40, 20, 20 , 10,10,15,30,20];
    public pieChartType:string = 'pie';
  

  
 showChart(): void{

    this.activityService.getAllActivitysById(this.id).subscribe(
      response => {this.activities = response;}
      );

      this.date = this.datePipe.transform(this.datePicker,'yyyy-MM-dd');

     this.activityService.getAllDurationById(this.id, this.date).subscribe(
      response => {this.pieChartData = response;}
      );
     
      this.medicationService.getAllMedicationPlans(this.id).subscribe(
        response2 => { this.allMeds = response2;}
      );

      this.medicationService.getAllMedicationTaken(this.id, this.date).subscribe(
        response3 =>{ this.medTaken = response3;console.log(this.medTaken);}
      );

      
    this.isShow = !this.isShow;
  }

 
  // events
  public chartClicked(e:any):void {
    //console.log(e);
  }
 
  public chartHovered(e:any):void {
   // console.log(e);
  }

  


  openDialog(patient: Patient): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(PatientEditComponent, {
      data: patient
    });
  }

  openDialogMed(patient: Patient): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(MedplanEditComponent, {
      data: patient
    });
  }

  openDialogAdd(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(AddPatientComponent,{
      data: {id_user: this.id_user}
    });
  }

  openDialogDelete(id: number): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(DelPatientComponent,{
      data: {id_patient: id}
    });
  }

  caregiverList(){
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }
  
  patientList(){
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }

  medicationList(){
    this.router.navigate([this.id_user + '/doctor/medication-list']);
  }

  medplanList(){
    this.router.navigate([this.id_user + '/doctor/med-plan']);
  }

}
