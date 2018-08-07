import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { GlobalConstant } from "../global-constants";

@Injectable()
export class ProfileService {
  getUserInformationUrl : string = this.globalConstant.baseUrl +'/getUser';
  // const httpOptions : new Headers({});
  constructor(private http : HttpClient, private globalConstant :GlobalConstant ) { }


  getUserInformation() : Observable<any>{

    return this.http.get(this.getUserInformationUrl);
  }
}
