package com.vinit.angularspringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.angularspringboot.exception.LoginException;
import com.vinit.angularspringboot.exception.MyTripException;
import com.vinit.angularspringboot.exception.ValidationException;
import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.services.SuggestionService;

@RestController
public class SuggestionController {

	@Autowired
	SuggestionService suggestionService;

	public SuggestionController() {

	}

	@RequestMapping(value = "/suggestions", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Suggestion>> getAllSuggestions() {

		return ResponseEntity.status(HttpStatus.OK).body(suggestionService.getAllSuggestion());
	}

	@RequestMapping(value = "/getSuggestion/{suggestionId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Suggestion> getSuggestion(@PathVariable Integer suggestionId) {

		return ResponseEntity.status(HttpStatus.OK).body(suggestionService.getSuggestion(suggestionId));
	}

	@RequestMapping(value = "/postSuggestion", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Suggestion> postSuggestion(@RequestBody Suggestion suggestion)
			throws ValidationException, MyTripException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			suggestion = suggestionService.postSuggestion(suggestion);
		} catch (LoginException e) {
			returnMap.put("message", e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(suggestion);
	}
}
