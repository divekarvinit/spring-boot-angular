package com.vinit.angularspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinit.angularspringboot.InvalidCredentialException;
import com.vinit.angularspringboot.UserProfileRepository;
import com.vinit.angularspringboot.domainObjects.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepo;
	
	public UserProfileServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserProfile userLogin(UserProfile userProfile)throws InvalidCredentialException {
		UserProfile returnUser = userProfileRepo.findByUserNameAndPasswordAndIsActive(userProfile.getUserName(), userProfile.getPassword(), userProfile.getIsActive());
		if(returnUser == null){
			throw new InvalidCredentialException("Invalid Login Credentials");
		}
		return returnUser;
	}

}
