import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { GlobalConstant } from "../global-constants";

@Injectable()
export class ProfileService {
  getUserInformationUrl : string = this.globalConstant.baseUrl +'/getUser';
  uploadFileUrl : string = this.globalConstant.baseUrl + '/uploadFile';

  
  constructor(private http : HttpClient, private globalConstant :GlobalConstant ) { }


  getUserInformation() : Observable<any>{
    let httpOptions = new HttpHeaders({'Content-Type' : 'application/json', 
    'Authorization' : localStorage.getItem('text') ? JSON.parse(localStorage.getItem('text')).val : '' });
    return this.http.get(this.getUserInformationUrl, {headers : httpOptions});
  }

  uploadProfilePicture(file:File) : Observable<any>{
    let httpOptions = new HttpHeaders({'Content-Type' : undefined, 
    'Authorization' : localStorage.getItem('text') ? JSON.parse(localStorage.getItem('text')).val : '' });
    const formData: FormData = new FormData();
    
    formData.append('fileKey', file, file.name);
    return this.http.post(this.uploadFileUrl, formData, { headers : httpOptions})

  }
}

