import { Component, OnInit, Inject  } from '@angular/core';
import { Medication } from '../model/medication';
import { MedicationService } from '../service/medication.service';
import {MatTableDataSource, MatSort, MatPaginator, MatDialog, MatDialogConfig } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';
import { PatientService } from '../service/patient.service';
import { Patient } from '../model/patient';
import { Medicationplan } from '../model/medicationplan';
import { Medicationperplan } from '../model/medicationperplan';

@Component({
  selector: 'app-medplan-edit',
  templateUrl: './medplan-edit.component.html',
  styleUrls: ['./medplan-edit.component.css']
})
export class MedplanEditComponent implements OnInit {

  constructor(private router: Router,
    private route: ActivatedRoute,
    private medicationService: MedicationService,
    private patientService: PatientService) { }

  medications: Medication[];
  displayedColumns = ['id_medication', 'name', 'dosage', 'actions'];
  list: MatTableDataSource<any>;
  id_user: number;
  patients: Patient[];
  intake_intervals: string;
  period: string;
  id: number;
  selected: string;
  medPlan = new Medicationplan();
  perPlan: Medicationperplan[] = [];
  medPlan2: Medicationplan;

  ngOnInit() {

    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });

    this.patientService.getAllPatients(this.id_user).subscribe(
      response => {this.patients = response;}
    )

    this.medicationService.getAlltMedications(this.id_user).subscribe(
      response => {this.medications = response; this.list = new MatTableDataSource(response);}
      );

  }


  // topics: string[] = ['Topic1', 'Topic2', 'Topic3', 'Topic4', 'Topic5'];
  selectedMed: Medication[] = [];

  // isSelected(value: string): boolean {
  //   return this.selectedTopics.indexOf(value) >= 0;
  // }

  i: number = 0;
  onChange(value: Medication) {
   
      console.log(value);
      //this.perPlan = this.medPlan.medicationPerPlans;
      //this.perPlan.push(new Medicationperplan(value)); 
      this.selectedMed.push(value);    

    // console.log(value, checked);
    // if (checked) {
    //   this.selectedTopics.push(value);
    // } else {
    //   let index = this.selectedTopics.indexOf(value);
    //   this.selectedTopics.splice(index, 1);
    // }
    // console.log(this.selectedTopics);
  }


  onOK(){
    console.log(this.intake_intervals);
    console.log(this.period);
    console.log(this.id)
    console.log(this.selectedMed);

    this.medicationService.addtMedPlan(this.id,this.intake_intervals,this.period,this.selectedMed).subscribe(response =>{this.medPlan2 = response; });
  }

  patientList(){
    this.router.navigate([this.id_user + '/doctor/patient-list']);
  }
  
  medplanList(){

  }

  caregiverList(){
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }

  medicationList(){
    this.router.navigate([this.id_user + '/doctor/medication-list']);
  }
  

}
