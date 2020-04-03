import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Monitoreddata2 } from '../model/monitoreddata2';
import { Recomandation } from '../model/recomandation';

@Injectable({
  providedIn: 'root'
})
export class ActivityService {

  constructor(private http: HttpClient) { }

  private urlbasic = '//localhost:8080';

  public getAllActivitysById(id: number): Observable<any> {
    const url = `${this.urlbasic}/${id}/doctor/activity-list`;
    return this.http.get(url);
  }
  public getAllDurationById(id: number, date: string): Observable<any> {
   // console.log(date);
    const url = `${this.urlbasic}/${id}/${date}/doctor/activity-time`;
    return this.http.get(url);
  }
  public postRecomandation(id: number, reco: string, date: string): Observable<any> {
    // console.log(date);
     const url = `${this.urlbasic}/${id}/${date}/doctor/recomandation`;
     return this.http.post<Recomandation>(url, reco);
   }
   public getAllRecommendations(): Observable<any> {
    // console.log(date);
     const url = `${this.urlbasic}/caregiver/recommendations`;
     return this.http.get(url);
   }

}
