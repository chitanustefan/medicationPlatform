import { Component, OnInit, Inject  } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';
import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material';
import { User } from '../model/user';
import { CaregiverService } from '../service/caregiver.service';

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
  selector: 'app-add-caregiver',
  templateUrl: './add-caregiver.component.html',
  styleUrls: ['./add-caregiver.component.css'],
  providers: [ 
    {provide: DateAdapter,useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ],
})
export class AddCaregiverComponent implements OnInit {

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


  constructor(    public dialogRef: MatDialogRef<AddCaregiverComponent>,
    private route: ActivatedRoute,
    private router: Router,
    private caregiverService: CaregiverService,
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

    this.caregiverService.addCaregiver(this.user, this.data.id_user).subscribe(response =>{this.userObj = response; });
    window.location.reload();
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
