import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from '../services/login.service';
import { User } from "../user";
import { Router } from '@angular/router';
import { GlobalConstant } from '../global-constants';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private loginService: LoginService, private global : GlobalConstant) { }

  ngOnInit() {
  }

  logoutUser(): void {
    this.loginService.userLogout();
  }

  get checkIfLoggedIn() {
    if(localStorage.getItem("user") && JSON.parse(localStorage.getItem("user")).user){
      return true;
    }
    return false;
  }
}
