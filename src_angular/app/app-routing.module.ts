import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { PatientComponent } from './patient/patient.component';
import { DoctorComponent } from './doctor/doctor.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { CaregiverListComponent } from './caregiver-list/caregiver-list.component';
import { MedicationListComponent } from './medication-list/medication-list.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { MedplanEditComponent } from './medplan-edit/medplan-edit.component';
const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: ':id_user/patient', component: PatientComponent},
  {path: ':id_user/doctor', component: DoctorComponent},
  {path: ':id_user/doctor/patient-list', component: PatientListComponent},
  {path: ':id_user/doctor/caregiver-list', component: CaregiverListComponent},
  {path: ':id_user/doctor/medication-list', component: MedicationListComponent},
  {path: ':id_user/caregiver', component: CaregiverComponent},
  {path: ':id_user/doctor/med-plan', component: MedplanEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
