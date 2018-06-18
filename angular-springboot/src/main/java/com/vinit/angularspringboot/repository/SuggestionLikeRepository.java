package com.vinit.angularspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinit.angularspringboot.domainObjects.SuggestionLike;

public interface SuggestionLikeRepository extends JpaRepository<SuggestionLike, Integer> {

}
