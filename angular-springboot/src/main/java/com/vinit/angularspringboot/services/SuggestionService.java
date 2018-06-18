package com.vinit.angularspringboot.services;

import java.util.List;

import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.domainObjects.SuggestionLike;

public interface SuggestionService {

	public List<Suggestion> getAllSuggestion();
	
	public List<SuggestionLike> getSuggestionLikes(Integer suggestionId);
}
