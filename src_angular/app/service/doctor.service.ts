import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Doctor } from '../model/doctor';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  private urlbasic = '//localhost:8080';

  public getDoctorById(id_user: number): Observable<any> {
    const url = `${this.urlbasic}/${id_user}/doctor/get`;
    return this.http.get(url);
  }
}
