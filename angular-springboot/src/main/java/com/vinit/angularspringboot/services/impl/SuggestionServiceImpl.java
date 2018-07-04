package com.vinit.angularspringboot.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vinit.angularspringboot.domainObjects.Suggestion;
import com.vinit.angularspringboot.domainObjects.SuggestionLike;
import com.vinit.angularspringboot.repository.SuggestionRespository;
import com.vinit.angularspringboot.services.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	SuggestionRespository suggestionRespository;
	
	public SuggestionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Suggestion> getAllSuggestion() {
		ArrayList<Suggestion> suggestions = (ArrayList<Suggestion>) suggestionRespository.findAll();

		Collections.sort(suggestions, new Comparator<Suggestion>() {
			@Override
			public int compare(Suggestion o1, Suggestion o2) {

//				if(o1.getSuggestionLikes().size() > o2.getSuggestionLikes().size()){
//					return 1;
//				} else if(o1.getSuggestionLikes().size() < o2.getSuggestionLikes().size()){
//					return -1;
//				}
				return Integer.valueOf(o1.getSuggestionLikes().size()).compareTo(Integer.valueOf(o2.getSuggestionLikes().size()));
			}
		});
		Collections.reverse(suggestions);
		return suggestions;
	}

	@Override
	public List<SuggestionLike> getSuggestionLikes(Integer suggestionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Suggestion getSuggestion(Integer suggestionId) {
		// TODO Auto-generated method stub
		Suggestion suggestion = suggestionRespository.findBySuggestionId(suggestionId);
		System.out.print(suggestion.getUser().getFirstName());
		return suggestion;
	}

	@Override
	public Map<String, Object> postSuggestion(Suggestion suggestion) {
		if(SecurityContextHolder.getContext() != null &&
				SecurityContextHolder.getContext().getAuthentication() != null &&
				SecurityContextHolder.getContext().getAuthentication().getName() != null){
			String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();			
		}
		return null;
	}

}
