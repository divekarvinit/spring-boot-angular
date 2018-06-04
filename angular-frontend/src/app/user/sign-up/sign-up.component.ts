import { Component, OnInit } from '@angular/core';
import { User } from '../../User';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  user: User;
  isError : boolean;
  isSuccess : boolean;
  signUpResponse : string;
  constructor(private loginService : LoginService) { }

  ngOnInit() {
    this.user = {
      userName: null,
      firstName: null,
      lastName: null,
      password: null,
      emailAddress: null
    };
    
    this.isError = false;
    this.isSuccess = false;
    this.signUpResponse = "";
  }

  signUp() {
    this.loginService.userSignUp(this.user).subscribe(
      data => {
        if(data.status == 200){
          this.isSuccess = true;
          this.isError = false;
          this.signUpResponse = data.body.message;
        }        
      },
      error => {
          this.isError = true;
          this.isSuccess = false;
          this.signUpResponse = error.error.message;
      }
    );
  }
}
