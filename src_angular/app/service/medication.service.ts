import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { Medication } from '../model/medication';

@Injectable({
  providedIn: 'root'
})
export class MedicationService {

  constructor(private http: HttpClient) { }

  private urlbasic = '//localhost:8080';

  public getAlltMedications(id_user: number): Observable<any> {
    const url = `${this.urlbasic}/doctor/medication-list`;
    return this.http.get(url);
  }

  public getAllMedicationPlans(id_patient: number): Observable<any> {
    const url = `${this.urlbasic}/doctor/medication-plan-byid/${id_patient}`;
    return this.http.get(url);
  }

  public getAllMedicationTaken(id_patient: number, date: String): Observable<any> {
    console.log(date);
    const url = `${this.urlbasic}/doctor/medication-taken/${id_patient}/${date}`;
    return this.http.get(url);
  }


  public editMedication(medication: Medication): Observable<any> {
    const url = `${this.urlbasic}/doctor/medication-list`;
    return this.http.post<Medication>(url, medication);
  }

  public addtMedication(medication: Medication): Observable<any> {
    console.log(medication);
    const url = `${this.urlbasic}/add/medication`;
    return this.http.post<Medication>(url, medication);
  }

  
  public addtMedPlan(id_patient: number, intake: string, period: string, medication: Medication[]): Observable<any> {
    console.log(id_patient)
    console.log(intake);
    console.log(period);
    console.log(medication);
    const url = `${this.urlbasic}/${id_patient}/${intake}/${period}/add/medplan`;
    return this.http.post<Medication>(url, medication);
  }


  public deleteMedication(id_medication: number): Observable<any> {
    const url = `${this.urlbasic}/delete/medication`;
    return this.http.post<Medication>(url, id_medication);
  }
}
