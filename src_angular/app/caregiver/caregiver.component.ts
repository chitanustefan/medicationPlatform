import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {MatTableDataSource, MatSort, MatPaginator, MatDialog, MatDialogConfig } from '@angular/material';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient.service';
import { StompService, StompConfig, StompState } from '@stomp/ng2-stompjs';
import { Message } from '@stomp/stompjs';
import { MessageService } from '../service/message.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SnackBarComponent } from '../snack-bar/snack-bar.component';
import { ActivityService } from '../service/activity.service';
import { Recomandation } from '../model/recomandation';
@Component({
  selector: 'app-caregiver',
  templateUrl: './caregiver.component.html',
  styleUrls: ['./caregiver.component.css']
})
export class CaregiverComponent implements OnInit {


  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  patients: Patient[];
  list: MatTableDataSource<any>;
  listRec: MatTableDataSource<any>;
  id_user: number;
  recomandations: Recomandation[];

  WEBSOCKET_URL = 'ws://@localhost:8080/socket';
  EXAMPLE_URL = '/topic/server-broadcaster';

  private messagingService: MessageService;

  messageHistory = [];
  state = 'NOT CONNECTED';

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private patientService: PatientService,
    private activityService: ActivityService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) { 

    this.messagingService = new MessageService(this.WEBSOCKET_URL, this.EXAMPLE_URL);

    // Subscribe to its stream (to listen on messages)
    this.messagingService.stream().subscribe((message: Message) => {
      this.messageHistory.unshift(message.body);
      console.log(message);
      this.snackBar.open(message.body, "OK", {
        duration: 2000,
      });
    });

    // Subscribe to its state (to know its connected or not)
    this.messagingService.state().subscribe((state: StompState) => {
      this.state = StompState[state];
    });

  }

  displayedColumns: string[] = ['id_patient', 'name', 'gender', 'birthday', 'email'];
  displayedColumns2: string[] = ['id_recommendation', 'id_patient', 'dateReco', 'desc'];

  ngOnInit() {
    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });

    this.patientService.getPatientsByCaregiver(this.id_user).subscribe(
      response => {this.patients = response; this.list = new MatTableDataSource(response);
                   this.list.paginator = this.paginator; }
      );

      this.activityService.getAllRecommendations().subscribe(
        response => {this.recomandations = response; this.listRec = new MatTableDataSource(response);
                     this.listRec.paginator = this.paginator; }
        );
  }

}
