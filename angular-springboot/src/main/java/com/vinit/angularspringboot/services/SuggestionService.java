package com.vinit.angularspringboot.services;

import java.util.List;
import java.util.Map;

import com.vinit.angularspringboot.exception.LoginException;
import com.vinit.angularspringboot.exception.MyTripException;
import com.vinit.angularspringboot.exception.ValidationException;
import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.domainObjects.SuggestionLike;

public interface SuggestionService {

	public List<Suggestion> getAllSuggestion();
	
	public List<SuggestionLike> getSuggestionLikes(Integer suggestionId);

	public Suggestion getSuggestion(Integer suggestionId);

	public Suggestion postSuggestion(Suggestion suggestion) throws ValidationException, LoginException, MyTripException;
}
