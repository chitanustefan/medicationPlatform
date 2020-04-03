import { Component, OnInit } from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import { User } from '../model/user';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../service/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  user: User;

  constructor(private route: ActivatedRoute, private router: Router, private loginService: LoginService) {
    this.user = new User(); }

  hide = true;
  email = new FormControl('', [Validators.required, Validators.email]);

  ngOnInit() {
  }

  onSubmit() {
    this.loginService.login(this.user).subscribe(x => {this.user = x; console.log(this.user.role);
                                                       if (this.user.role === 'patient') {
      this.router.navigate(['/' + this.user.id_user + '/patient']);
    } else if (this.user.role === 'doctor') {
      this.router.navigate(['/' + this.user.id_user + '/doctor']);
         } else if (this.user.role === 'caregiver') {
      this.router.navigate(['/' + this.user.id_user + '/caregiver']);
                }
     }
    );
}

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
        this.email.hasError('email') ? 'Not a valid email' :
            '';
  }

}
