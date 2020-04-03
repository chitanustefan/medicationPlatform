import { Component, OnInit, Inject  } from '@angular/core';
import { MedicationService } from '../service/medication.service';
import { Medication } from '../model/medication';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-medication-edit',
  templateUrl: './medication-edit.component.html',
  styleUrls: ['./medication-edit.component.css']
})
export class MedicationEditComponent implements OnInit {

  private medication: Medication;
  name: string;
  dosage: string;
  side_effect: string;
  id_user: number;

  constructor(             
    public dialogRef: MatDialogRef<MedicationEditComponent>,
    private route: ActivatedRoute,
    private router: Router,
    private medicationService: MedicationService,
    @Inject(MAT_DIALOG_DATA) public data: Medication) { }

  ngOnInit() {

    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });
    

  }
  onOK(medication: Medication ){
    
    this.data.name = this.name;
    this.data.side_effect= this.side_effect;
    this.data.dosage = this.dosage;

    console.log(this.data.name);

    this.medicationService.editMedication(this.data).subscribe(response =>{this.medication = response; });
    window.location.reload();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
