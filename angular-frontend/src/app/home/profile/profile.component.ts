import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from "../../user";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userInfo : User;
  constructor() { }

  ngOnInit() {
    this.getUserInformation();
  }

  getUserInformation() : void {
    // this.userInfo = {
    //     emailAddress : 'vinit@gmail.com',
    //     firstName :'Vinit',
    //     lastName : 'Divekar',

    // }
  }
}
