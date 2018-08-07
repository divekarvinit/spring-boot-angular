import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from "../../user";
import { ProfileService } from "../../services/profile.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userInfo : User;
  fileToBeUploaded : File;
  constructor(private profileService : ProfileService) { }

  ngOnInit() {
    this.getUserInformation();
  }

  getUserInformation() : void {
    // this.userInfo = {
    //     emailAddress : 'vinit@gmail.com',
    //     firstName :'Vinit',
    //     lastName : 'Divekar',

    // }

    this.profileService.getUserInformation()
    .subscribe(user => this.userInfo = user);
  }

  handleFileInput(file : FileList) : void {
    this.fileToBeUploaded = file.item(0);
  }

  saveData() : void{
    this.profileService.uploadProfilePicture(this.fileToBeUploaded)
    .subscribe(response => {
      
    })
  }
}