import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from "../user";
import { GlobalConstant } from '../global-constants';

const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json' });

@Injectable()
export class LoginService {
  loginUrl: string = this.global.baseUrl + "/login";
  signUpUrl : string = this.global.baseUrl + "/sign-up";

  constructor(private http: HttpClient, private global : GlobalConstant) { }
  
  userSignIn(user: User): Observable<HttpResponse<any>> {
    debugger;
    return this.http.post(this.loginUrl, user, { headers: httpOptions, observe: "response" });
  }

  userSignUp(user: User): Observable<HttpResponse<any>> {
    // return this.http.post(this)
    return this.http.post(this.signUpUrl, user, { headers: httpOptions, observe: "response" });
  }
}
