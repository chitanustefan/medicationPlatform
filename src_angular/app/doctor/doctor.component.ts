import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  id_user: number;

  ngOnInit() {
    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });
  }
  
  patientList(){
    this.router.navigate([this.id_user + '/doctor/patient-list']);
  }

  caregiverList(){
    console.log(this.id_user);
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }

  medicationList(){
    console.log(this.id_user);
    this.router.navigate([this.id_user + '/doctor/medication-list']);
  }
  medplanList(){
    this.router.navigate([this.id_user + '/doctor/med-plan']);
  }

}
