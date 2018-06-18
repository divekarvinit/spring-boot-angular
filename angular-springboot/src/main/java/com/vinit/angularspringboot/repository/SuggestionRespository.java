package com.vinit.angularspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinit.angularspringboot.domainObjects.Suggestion;

public interface SuggestionRespository extends JpaRepository<Suggestion, Integer> {

	public List<Suggestion> findAll();
}
