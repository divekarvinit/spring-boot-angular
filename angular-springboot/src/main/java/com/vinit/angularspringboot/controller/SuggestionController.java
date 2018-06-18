package com.vinit.angularspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.services.SuggestionService;

public class SuggestionController {

	@Autowired
	SuggestionService suggestionService;
	
	public SuggestionController() {
		
	}
	
	@RequestMapping(value="/suggestions", method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Suggestion>> getAllSuggestions(){
		
		suggestionService.getAllSuggestion();
		
		return null;
	}

}
