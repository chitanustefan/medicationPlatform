import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../model/patient';
import { PatientService } from '../service/patient.service';
import { Medication } from '../model/medication';
import { MedicationService } from '../service/medication.service';

@Component({
  selector: 'app-del-patient',
  templateUrl: './del-patient.component.html',
  styleUrls: ['./del-patient.component.css']
})
export class DelPatientComponent implements OnInit {


  patient: Patient;

  constructor(
    public dialogRef: MatDialogRef<DelPatientComponent>,
    private route: ActivatedRoute,
    private router: Router,
    
    private patientService: PatientService,
    @Inject(MAT_DIALOG_DATA) public data: Patient
  ) { }

  ngOnInit() {
  }

  onClick(id: number){
    console.log(id);
    this.patientService.deletePatient(id).subscribe(x => {this.patient = x;});
    window.location.reload();
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
