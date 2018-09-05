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
  imagePath : string;
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
    .subscribe(user => {
      debugger;
      this.userInfo = user;
      this.imagePath = 'data:' + this.userInfo.contentType + ';base64,' + this.userInfo.profilePictureStr;
    });
  }

  handleFileInput(file : FileList) : void {
    debugger;
    this.fileToBeUploaded = file.item(0);
  }

  saveData() : void{
    this.profileService.uploadProfilePicture(this.fileToBeUploaded)
    .subscribe(response => {
      console.log(response);
    })
  }
}
