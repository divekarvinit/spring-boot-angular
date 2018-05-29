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
  user: User = {
    id: null,
    userName: null,
    password: null,
    firstName: null,
    lastName: null
  };

  constructor(
    private http: HttpClient,
    private loginService: LoginService) { }

  ngOnInit() {
    // this.userName ="Vinit";
  }

  signIn(): void {
    this.loginService.userSignIn(this.user).subscribe(
      response => {
        console.log(response);
      }
    );
  }
}
