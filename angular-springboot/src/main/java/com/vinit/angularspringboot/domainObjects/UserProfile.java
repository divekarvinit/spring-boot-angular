package com.vinit.angularspringboot.domainObjects;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_master")
@JsonIgnoreProperties({"suggestions", "suggestionLikes"})
public class UserProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7400472171878370L;


	public UserProfile() {

	}
	
	public UserProfile(@NotNull String userName, @NotNull String password, @NotNull String firstName,
			@NotNull String lastName, @NotNull String emailAddress, String createdBy, String modifedBy,
			Date createdDate, Date modifiedDate, Character isActive, byte[] profilePicture) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.createdBy = createdBy;
		this.modifedBy = modifedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.isActive = isActive;
		this.profilePicture = profilePicture;
	}

	@Id
	@NotNull
	@Column(name = "username", length = 55)
	private String userName;

	@JsonIgnore
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "email_id")
	private String emailAddress;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_by")
	private String modifedBy;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", nullable = false, updatable = false)
	private Date createdDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	@Column(name="modified_date", nullable=false)
	private Date modifiedDate;
	
	@Column(name="is_active")
	private Character isActive;
	
	@Column(name="profile_picture", columnDefinition="BLOB")
	private byte[] profilePicture;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Suggestion> suggestions;
	
	@OneToMany(mappedBy = "user")
	private Set<SuggestionLike> suggestionLikes;
	
	public Set<Suggestion> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(Set<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public UserProfile(@NotNull String userName, @NotNull String password, @NotNull String firstName,
			@NotNull String lastName, @NotNull String emailAddress, String createdBy, String modifedBy,
			Date createdDate, Date modifiedDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.createdBy = createdBy;
		this.modifedBy = modifedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifedBy() {
		return modifedBy;
	}

	public void setModifedBy(String modifedBy) {
		this.modifedBy = modifedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public byte[] getProfilePicture(){
		return profilePicture;
	}
	
	public void setProfilePicture(byte[] profilePicture){
		this.profilePicture = profilePicture;
	}

	public UserProfile(String userName, String password, String firstName, String lastName, String emailAddress, byte[] profilePicture) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.profilePicture = profilePicture;
	}

	@Override
	public String toString() {
		return "UserProfile [userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", createdBy=" + createdBy
				+ ", modifedBy=" + modifedBy + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", isActive=" + isActive + "]";
	}
}
