import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Caregiver } from '../model/caregiver';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class CaregiverService {

  constructor(private http: HttpClient) { }

  private urlbasic = '//localhost:8080';

  public getAllCaregivers(id_user: number): Observable<any> {
    const url = `${this.urlbasic}/${id_user}/doctor/caregiver-list`;
    return this.http.get(url);
  }

  public editCaregiver(caregiver: Caregiver): Observable<any> {
    
    console.log(caregiver.user.birthday);
    const url = `${this.urlbasic}/doctor/caregiver-list`;
    return this.http.post<Caregiver>(url, caregiver);
  }

  public addCaregiver(user: User, id_user: number): Observable<any> {
    console.log(id_user);
    const url = `${this.urlbasic}/${id_user}/add/caregiver`;
    return this.http.post<Caregiver>(url, user);
  }

  public deleteCaregiver(id_caregiver: number): Observable<any> {
    const url = `${this.urlbasic}/delete/caregiver`;
    return this.http.post<Caregiver>(url, id_caregiver);
  }
}
