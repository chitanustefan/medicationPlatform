import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Medication } from '../model/medication';
import { MedicationService } from '../service/medication.service';


@Component({
  selector: 'app-add-medication',
  templateUrl: './add-medication.component.html',
  styleUrls: ['./add-medication.component.css']
})
export class AddMedicationComponent implements OnInit {


  medication = new Medication();
  medicationObj: Medication;
  name: string;
  side_effect: string;
  dosage: string;


  constructor( public dialogRef: MatDialogRef<AddMedicationComponent>,
    private route: ActivatedRoute,
    private router: Router,
    private medicationService: MedicationService,
    @Inject(MAT_DIALOG_DATA) public data: Medication) { }

  ngOnInit() {
  }

  onOK(){
    this.medicationService.addtMedication(this.medication).subscribe(response =>{this.medicationObj = response; });
    window.location.reload();
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
