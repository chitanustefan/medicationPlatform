import { Component, OnInit, ViewChild  } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { CaregiverService } from '../service/caregiver.service';
import {MatTableDataSource, MatSort, MatPaginator, MatDialog, MatDialogConfig } from '@angular/material';
import { Caregiver } from '../model/caregiver';
import { CaregiverEditComponent } from '../caregiver-edit/caregiver-edit.component';
import { AddCaregiverComponent } from '../add-caregiver/add-caregiver.component';
import { DelCaregiverComponent } from '../del-caregiver/del-caregiver.component';

@Component({
  selector: 'app-caregiver-list',
  templateUrl: './caregiver-list.component.html',
  styleUrls: ['./caregiver-list.component.css']
})
export class CaregiverListComponent implements OnInit {


  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  caregivers: Caregiver[];
  list: MatTableDataSource<any>;
  id_user: number;

  constructor(private router: Router,
     private route: ActivatedRoute,
     private caregoverservice: CaregiverService,
     private dialog: MatDialog,
     ) { }

  ngOnInit() {

    this.route.params.forEach((urlParams) => {
      this.id_user = urlParams.id_user;
    });

    this.caregoverservice.getAllCaregivers(this.id_user).subscribe(
      response => {this.caregivers = response; this.list = new MatTableDataSource(response);
                   this.list.paginator = this.paginator; }
      );

  }
  displayedColumns: string[] = ['id_caregiver', 'name', 'gender', 'birthday', 'email','actions'];

  openDialog(caregiver: Caregiver): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(CaregiverEditComponent, {
      data: caregiver
    });
  }

  openDialogAdd(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(AddCaregiverComponent,{
      data: {id_user: this.id_user}
    });
  }

  openDialogDelete(id: number): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "60%";
    this.dialog.open(DelCaregiverComponent,{
      data: {id_patient: id}
    });
  }

  patientList(){
    this.router.navigate([this.id_user + '/doctor/patient-list']);
  }

  caregiverList(){
    this.router.navigate([this.id_user + '/doctor/caregiver-list']);
  }
  medicationList(){
    this.router.navigate([this.id_user + '/doctor/medication-list']);
  }
  medplanList(){
    this.router.navigate([this.id_user + '/doctor/med-plan']);
  }
}
