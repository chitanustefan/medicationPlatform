import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import { Caregiver } from '../model/caregiver';
import { CaregiverService } from '../service/caregiver.service';

@Component({
  selector: 'app-caregiver-edit',
  templateUrl: './caregiver-edit.component.html',
  styleUrls: ['./caregiver-edit.component.css']
})
export class CaregiverEditComponent implements OnInit {

  private caregiver: Caregiver;
  name: string;
  email: string;
  id_user: number;

  constructor(             
    public dialogRef: MatDialogRef<CaregiverEditComponent>,
    private route: ActivatedRoute,
    private router: Router,
    
    private caregiverService: CaregiverService,
    @Inject(MAT_DIALOG_DATA) public data: Caregiver) { }

  ngOnInit() {

    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });
    

  }

  onOK(caregiver: Caregiver){
    
    this.data.user.name = this.name;
    this.data.user.email = this.email;

    console.log(this.data.user.name);

    this.caregiverService.editCaregiver(this.data).subscribe(response =>{this.caregiver = response; });
    //window.location.reload();
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
