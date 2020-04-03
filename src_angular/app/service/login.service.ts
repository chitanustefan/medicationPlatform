import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private usersUrlLog: string;
  private usersUrlReg: string;

  constructor(private http: HttpClient) {
    this.usersUrlLog = 'http://localhost:8080/login';
    this.usersUrlReg = 'http://localhost:8080/register';
   }

  public login(user: User): Observable<User>{
    return this.http.post<User>(this.usersUrlLog, user);
  }
}
