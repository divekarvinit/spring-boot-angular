package com.vinit.angularspringboot.services;

import com.vinit.angularspringboot.LoginException;
import com.vinit.angularspringboot.domainObjects.UserProfile;

public interface UserProfileService {

	public UserProfile userLogin(UserProfile userProfile) throws LoginException;

	public void signUp(UserProfile userProfile) throws LoginException; 
}
