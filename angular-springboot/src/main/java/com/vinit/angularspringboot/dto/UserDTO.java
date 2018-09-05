package com.vinit.angularspringboot.dto;

public class UserDTO {

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	private String userName;
	private String firstName;
	private String lastName;
	private byte[] profilePicture;
	private String profilePictureStr;
	private String contentType;
	private String emailId;

	public UserDTO(String userName, String firstName, String lastName, byte[] profilePicture, String profilePictureStr,
			String contentType, String emailId) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profilePicture = profilePicture;
		this.profilePictureStr = profilePictureStr;
		this.contentType = contentType;
		this.emailId = emailId;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getProfilePictureStr() {
		return profilePictureStr;
	}

	public void setProfilePictureStr(String profilePictureStr) {
		this.profilePictureStr = profilePictureStr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
