import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MaterialModule} from './material';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { PatientComponent } from './patient/patient.component';
import {  HttpClientModule  } from '@angular/common/http';
import { DoctorComponent } from './doctor/doctor.component';
import { HeaderComponent } from './components/header/header.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { CaregiverListComponent } from './caregiver-list/caregiver-list.component';
import { PatientEditComponent } from './patient-edit/patient-edit.component';
import { MedplanEditComponent } from './medplan-edit/medplan-edit.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { DelPatientComponent } from './del-patient/del-patient.component';
import { CaregiverEditComponent } from './caregiver-edit/caregiver-edit.component';
import { AddCaregiverComponent } from './add-caregiver/add-caregiver.component';
import { DelCaregiverComponent } from './del-caregiver/del-caregiver.component';
import { MedicationListComponent } from './medication-list/medication-list.component';
import { AddMedicationComponent } from './add-medication/add-medication.component';
import { DelMedicationComponent } from './del-medication/del-medication.component';
import { MedicationEditComponent } from './medication-edit/medication-edit.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { SnackBarComponent } from './snack-bar/snack-bar.component';
import { DatePipe } from '@angular/common';
import { ChartsModule } from 'ng2-charts';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PatientComponent,
    DoctorComponent,
    HeaderComponent,
    PatientListComponent,
    CaregiverListComponent,
    PatientEditComponent,
    MedplanEditComponent,
    AddPatientComponent,
    DelPatientComponent,
    CaregiverEditComponent,
    AddCaregiverComponent,
    DelCaregiverComponent,
    MedicationListComponent,
    AddMedicationComponent,
    DelMedicationComponent,
    MedicationEditComponent,
    CaregiverComponent,
    SnackBarComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MaterialModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ChartsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
  entryComponents:[PatientEditComponent, AddPatientComponent, DelPatientComponent,
    CaregiverEditComponent, AddCaregiverComponent, DelCaregiverComponent,
    AddMedicationComponent, DelMedicationComponent, MedicationEditComponent]
})
export class AppModule { }
