import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from "../user";

const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json' });

@Injectable()
export class LoginService {
  loginUrl: string = "http://localhost:8080/getUser";
  constructor(private http: HttpClient) { }

  userSignIn(user: User) : Observable<HttpResponse<any>> {
    return this.http.post(this.loginUrl, user, {headers : httpOptions, observe : "response"});
  }
}
