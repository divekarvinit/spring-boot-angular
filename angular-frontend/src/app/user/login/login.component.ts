import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../../services/login.service';
import { User } from "../../user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User; 

  constructor(
    private http: HttpClient,
    private loginService: LoginService) { }

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
        console.log("Successs" + data.status);
      },
      error => {
        console.log("error" + error.error);
      }
    );
  }
}
