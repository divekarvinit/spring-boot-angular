package com.vinit.angularspringboot.domainObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="suggestion_like")
@JsonIgnoreProperties({"suggestion"})
public class SuggestionLike {

	public SuggestionLike() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="suggestion_like_id")
	private Integer suggestionLikeId;
	
	@Column(name="like_date")
	private Date likeDate;
	
	@Column(name="is_active")
	private Character isActive;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@ManyToOne
	@JoinColumn(name="suggestion_id")
	private Suggestion suggestion;
	
	@ManyToOne
	@JoinColumn(name="like_user_id")
	private UserProfile user;

	public Integer getSuggestionLikeId() {
		return suggestionLikeId;
	}

	public void setSuggestionLikeId(Integer suggestionLikeId) {
		this.suggestionLikeId = suggestionLikeId;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}
}
