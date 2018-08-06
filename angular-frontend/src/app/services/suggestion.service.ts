import { Injectable } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { GlobalConstant } from "../global-constants";

const httpOptions = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization' : localStorage.getItem('text') ? JSON.parse(localStorage.getItem('text')).val : '' });

@Injectable()
export class SuggestionService {
  getAllSuggestionsUrl: string = this.global.baseUrl + "/suggestions";
  constructor(private http : HttpClient, private global : GlobalConstant ) { }


  getAllSuggestion() : Observable<any>{    
    debugger;
    return this.http.get(this.getAllSuggestionsUrl, {headers : httpOptions});
  }
}
