package com.vinit.angularspringboot.services;

import com.vinit.angularspringboot.InvalidCredentialException;
import com.vinit.angularspringboot.domainObjects.UserProfile;

public interface UserProfileService {

	public UserProfile userLogin(UserProfile userProfile) throws InvalidCredentialException; 
}
