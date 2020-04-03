import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material';
import { PatientService } from '../service/patient.service';
import { User } from '../model/user';
import { Doctor } from '../model/doctor';
import { DoctorService } from '../service/doctor.service';

export const MY_FORMATS = {
  parse: {
      dateInput: ['DD/MM/YYYY']
  },
  display: {
      dateInput: 'DD/MM/YYYY',
      monthYearLabel: 'MMM YYYY',
      dateA11yLabel: 'LL',
      monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css'],
  providers: [ 
    {provide: DateAdapter,useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ],
})
export class AddPatientComponent implements OnInit {

  selectedGender: string;
  genders: string[] = ['M', 'F'];
  name: string;
  email: string;
  password: string;
  confpassword: string;
  birthday: Date;
  birt: string;
  user = new User();
 // user: User;
  userObj: User;
  gender: string;
  hide: boolean;
  doctor: Doctor;


  constructor(    public dialogRef: MatDialogRef<AddPatientComponent>,
    private route: ActivatedRoute,
    private router: Router,
    private doctorService: DoctorService,
    private patientService: PatientService,
    @Inject(MAT_DIALOG_DATA) public data: User) { }

  ngOnInit() {
  }

  onOK(){
    console.log(this.user.name);
    console.log(this.user.email);
    console.log(this.user.password);
    console.log(this.confpassword);
    console.log(this.user.birthday);
    console.log(this.user.gender);
    // this.doctorService.getDoctorById(this.data.id_user).subscribe(response => { this.doctor = response; console.log(this.doctor.id_doctor);
    //   this.user.id_doctor = this.doctor;
    //   console.log(this.user.id_doctor.user.name);   
    // });

    this.patientService.addPatient(this.user, this.data.id_user).subscribe(response =>{this.userObj = response; });
    window.location.reload();
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}

