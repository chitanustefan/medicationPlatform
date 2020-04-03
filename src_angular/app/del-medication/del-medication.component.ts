import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { MedicationService } from '../service/medication.service';
import { Medication } from '../model/medication';

@Component({
  selector: 'app-del-medication',
  templateUrl: './del-medication.component.html',
  styleUrls: ['./del-medication.component.css']
})
export class DelMedicationComponent implements OnInit {

  medication: Medication;

  constructor(
    public dialogRef: MatDialogRef<DelMedicationComponent>,
    private route: ActivatedRoute,
    private router: Router,
    private medicationService: MedicationService,
    @Inject(MAT_DIALOG_DATA) public data: Medication
  ) { }

  ngOnInit() {
  }

  onClick(id: number){
    console.log(id);
    this.medicationService.deleteMedication(id).subscribe(x => {this.medication = x;});
    window.location.reload();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  

}
