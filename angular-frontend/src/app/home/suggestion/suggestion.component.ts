import { Component, OnInit } from '@angular/core';
import { Suggestion } from "../../suggestion";
import { SuggestionService } from "../../services/suggestion.service";
@Component({
  selector: 'app-suggestion',
  templateUrl: './suggestion.component.html',
  styleUrls: ['./suggestion.component.css']
})
export class SuggestionComponent implements OnInit {
  suggestions : Suggestion[];
  constructor(private suggestionService : SuggestionService) { }

  ngOnInit() {
    this.getAllSuggestions();  
  }

  getAllSuggestions() : void {
    this.suggestionService.getAllSuggestion()
    .subscribe(response => {
      debugger;
      this.suggestions = response;
    });
  }
}
