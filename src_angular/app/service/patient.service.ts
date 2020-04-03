import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Patient } from '../model/patient';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) { }

  private urlbasic = '//localhost:8080';

  public getAllPatients(id_user: number): Observable<any> {
    const url = `${this.urlbasic}/${id_user}/doctor/patient-list`;
    return this.http.get(url);
  }

  public getPatientsByCaregiver(id_user: number): Observable<any>{
    const url = `${this.urlbasic}/${id_user}/caregiver`;
    return this.http.get(url);
  }

  public editPatient(patient: Patient): Observable<any> {
    
    console.log(patient.user.birthday);
    const url = `${this.urlbasic}/doctor/patient-list`;
    return this.http.post<Patient>(url, patient);
  }

  public addPatient(user: User, id_user: number): Observable<any> {
    console.log(id_user);
    const url = `${this.urlbasic}/${id_user}/add/patient`;
    return this.http.post<Patient>(url, user);
  }

  public deletePatient(id_patient: number): Observable<any> {
    const url = `${this.urlbasic}/delete/patient`;
    return this.http.post<Patient>(url, id_patient);
  }


}
