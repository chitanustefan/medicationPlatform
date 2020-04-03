import { Component, OnInit, ViewChild  } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {MatTableDataSource, MatSort, MatPaginator, MatDialog, MatDialogConfig } from '@angular/material';
import { Medication } from '../model/medication';
import { MedicationService } from '../service/medication.service';
import { AddMedicationComponent } from '../add-medication/add-medication.component';
import { DelMedicationComponent } from '../del-medication/del-medication.component';
import { MedicationEditComponent } from '../medication-edit/medication-edit.component';

@Component({
  selector: 'app-medication-list',
  templateUrl: './medication-list.component.html',
  styleUrls: ['./medication-list.component.css']
})
export class MedicationListComponent implements OnInit {


  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  medications: Medication[];
  list: MatTableDataSource<any>;
  id_user: number;

  constructor(private router: Router,
     private route: ActivatedRoute,
     private medicationService: MedicationService,
     private dialog: MatDialog,
     ) { }

  
     displayedColumns: string[] = ['id_medication', 'name', 'dosage', 'side_effect','actions'];

  ngOnInit() {
    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });

    this.medicationService.getAlltMedications(this.id_user).subscribe(
      response => {this.medications = response; this.list = new MatTableDataSource(response);
                   this.list.paginator = this.paginator; }
      );

  }
  

  openDialogAdd(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(AddMedicationComponent,{
      data: {id_user: this.id_user}
    });
  }

  openDialogDelete(medication: Medication): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(DelMedicationComponent,{
      data: {id_medication: medication.id_medication}
    });
  }


  openDialog(medication: Medication): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(MedicationEditComponent, {
      data: medication
    });
  }

  patientList(){
    this.router.navigate([this.id_user + '/doctor/patient-list']);
  }

  caregiverList(){
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }

  medicationList(){
    this.router.navigate([this.id_user + '/doctor/medication-list']);
  }
  medplanList(){
    this.router.navigate([this.id_user + '/doctor/med-plan']);
  }

}
