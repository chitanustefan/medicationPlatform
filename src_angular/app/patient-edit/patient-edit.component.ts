import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient.service';

@Component({
  selector: 'app-patient-edit',
  templateUrl: './patient-edit.component.html',
  styleUrls: ['./patient-edit.component.css']
})
export class PatientEditComponent implements OnInit {


  private patient: Patient;
  name: string;
  birthday: Date;
  email: string;
  password: string;
  gender: string;
  role: string;
  id_user: number;

  constructor(             
    public dialogRef: MatDialogRef<PatientEditComponent>,
    private route: ActivatedRoute,
    private router: Router,
    
    private patientService: PatientService,
    @Inject(MAT_DIALOG_DATA) public data: Patient) { }

  ngOnInit() {

    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });
    

  }

  onOK(patient: Patient){
    
    this.data.user.name = this.name;
    this.data.user.birthday = this.birthday;
    this.data.user.email = this.email;

    console.log(this.data.user.name);

    this.patientService.editPatient(this.data).subscribe(response =>{this.patient = response; });
    window.location.reload();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
