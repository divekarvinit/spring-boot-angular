package com.vinit.angularspringboot.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.dto.UserDTO;
import com.vinit.angularspringboot.exception.LoginException;
import com.vinit.angularspringboot.exception.MyTripException;

public interface UserProfileService {

	public UserProfile userLogin(UserProfile userProfile) throws LoginException;

	public void signUp(UserProfile userProfile) throws LoginException;

	public UserDTO getUser() throws MyTripException;

	public void uploadProfilePicture(MultipartFile file) throws IOException ; 
}
