package com.vinit.angularspringboot.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.domainObjects.SuggestionLike;
import com.vinit.angularspringboot.repository.SuggestionRespository;
import com.vinit.angularspringboot.services.SuggestionService;

public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	SuggestionRespository suggestionRespository;
	
	public SuggestionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Suggestion> getAllSuggestion() {
		ArrayList<Suggestion> suggestions = (ArrayList<Suggestion>) suggestionRespository.findAll();

		suggestions.sort(new Comparator<Suggestion>() {
			@Override
			public int compare(Suggestion o1, Suggestion o2) {

				if(o1.getSuggestionLikes().size() > o2.getSuggestionLikes().size()){
					return 1;
				} else if(o1.getSuggestionLikes().size() < o2.getSuggestionLikes().size()){
					return -1;
				}
				return 0;
			}
		});
		
		return suggestions;
	}

	@Override
	public List<SuggestionLike> getSuggestionLikes(Integer suggestionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
