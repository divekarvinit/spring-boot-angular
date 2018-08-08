package com.vinit.angularspringboot.services;

import com.vinit.angularspringboot.exception.LoginException;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.vinit.angularspringboot.domainObjects.UserProfile;

public interface UserProfileService {

	public UserProfile userLogin(UserProfile userProfile) throws LoginException;

	public void signUp(UserProfile userProfile) throws LoginException;

	public UserProfile getUser();

	public void uploadProfilePicture(MultipartFile file) throws IOException ; 
}
