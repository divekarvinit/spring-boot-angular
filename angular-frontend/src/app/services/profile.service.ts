import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { GlobalConstant } from "../global-constants";

@Injectable()
export class ProfileService {
  getUserInformationUrl : string = this.globalConstant.baseUrl +'/getUser';
  uploadProfileUrl : string = this.globalConstant.baseUrl + '/uploadProfilePicture';

  
  constructor(private http : HttpClient, private globalConstant :GlobalConstant ) { }


  getUserInformation() : Observable<any>{
    let httpOptions = new HttpHeaders({'Content-Type' : 'application/json', 
    'Authorization' : localStorage.getItem('text') ? JSON.parse(localStorage.getItem('text')).val : '' });
    return this.http.get(this.getUserInformationUrl, {headers : httpOptions});
  }

  uploadProfilePicture(file:File) : Observable<any>{
    debugger;
    let httpOptions = new HttpHeaders({
      'Authorization' : localStorage.getItem('text') ? JSON.parse(localStorage.getItem('text')).val : '' 
    });
    const formData: FormData = new FormData();
    
    formData.append('file', file);
    return this.http.post(this.uploadProfileUrl, formData, { headers : httpOptions});
  }
}

