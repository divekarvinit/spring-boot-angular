import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from "../user";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {
  loginUrl: string = "http://localhost:8080/loginUser";
  constructor(private http: HttpClient) { }

  userSignIn(user: User) : Observable<any> {
    return this.http.post(this.loginUrl, user, httpOptions);
  }
}
