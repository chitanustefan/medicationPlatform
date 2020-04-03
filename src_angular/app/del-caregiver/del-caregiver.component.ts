import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { CaregiverService } from '../service/caregiver.service';
import { Caregiver } from '../model/caregiver';

@Component({
  selector: 'app-del-caregiver',
  templateUrl: './del-caregiver.component.html',
  styleUrls: ['./del-caregiver.component.css']
})
export class DelCaregiverComponent implements OnInit {


  caregiver: Caregiver;

  constructor(
    public dialogRef: MatDialogRef<DelCaregiverComponent>,
    private route: ActivatedRoute,
    private router: Router,
    
    private caregiverService: CaregiverService,
    @Inject(MAT_DIALOG_DATA) public data: Caregiver
  ) { }

  ngOnInit() {
  }

  onClick(id: number){
    console.log(id);
    this.caregiverService.deleteCaregiver(id).subscribe(x => {this.caregiver = x;});
    window.location.reload();
  }
  onNoClick(): void {
    this.dialogRef.close();
  }

}
