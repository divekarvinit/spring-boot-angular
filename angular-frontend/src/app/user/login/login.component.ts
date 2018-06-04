import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../../services/login.service';
import { User } from "../../user";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User; 

  constructor(
    private http: HttpClient,
    private loginService: LoginService,
  private router : Router) { }

  ngOnInit() {
    // this.userName ="Vinit";
    this.resetForm();
  }

  resetForm() : void {
    this.user = {
      userName: null,
      password: null,
      firstName: null,
      lastName: null
    };
  }

  signIn(): void {
    this.loginService.userSignIn(this.user).subscribe(
      data => {
        if(data.status == 200){
          let authHeader = data.headers.get('Authorization');
          if(authHeader != undefined && authHeader != null){
            localStorage.setItem('text', JSON.stringify({'val' : authHeader}));
            this.router.navigate(["/suggestions"]);
          }
        }
      },
      error => {
        console.log("error" + error.error);
      }
    );
  }
}
