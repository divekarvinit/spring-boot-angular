import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../../services/login.service';
import { User } from "../../user";
import { Router } from '@angular/router';
import { GlobalConstant } from './../../global-constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User; 
  isError : boolean = false;
  isSignIn : boolean = false;
  btnName : string = "Sign In";
  signInResponse : string = 'Invalid Username or Password.';

  constructor(
    private http: HttpClient,
    private loginService: LoginService,
    private router : Router,
    private global : GlobalConstant) { }

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
    this.isSignIn = true;
    this.isError = false;
    this.btnName = "Signing In...";
    this.loginService.userSignIn(this.user).subscribe(
      data => {
        this.isSignIn = false;
        this.btnName = "Sign In";
        if(data.status == 200){
          let authHeader = data.headers.get('Authorization');
          if(authHeader != undefined && authHeader != null){
            // debugger;
            localStorage.setItem('text', JSON.stringify({'val' : authHeader}));
            localStorage.setItem('user', JSON.stringify({'user' : this.user.userName}))
            this.global.isAuthenticated = true;
            this.router.navigate(["/home/suggestions"]);
          }
        }
      },
      error => {
        this.isSignIn = false;
        this.btnName = "Sign In";
        console.log("error" + error.error);
        this.isError = true;
        if(error.status != '403'){          
          this.signInResponse = "Couldn't log in. Please contact system Administrator.";
        }   
      }
    );
  }
}
