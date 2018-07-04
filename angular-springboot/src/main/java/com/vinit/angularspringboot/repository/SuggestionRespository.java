package com.vinit.angularspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinit.angularspringboot.domainObjects.Suggestion;

@Repository
public interface SuggestionRespository extends JpaRepository<Suggestion, Integer> {

//	@Query("select s.suggestionId, s.description from Suggestion s left join s.user")
	public List<Suggestion> findAll();
	public Suggestion findBySuggestionId(Integer suggestionId);
}
