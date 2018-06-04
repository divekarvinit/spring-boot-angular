package com.vinit.angularspringboot.services;

import static java.util.Collections.emptyList;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vinit.angularspringboot.LoginException;
import com.vinit.angularspringboot.UserProfileRepository;
import com.vinit.angularspringboot.domainObjects.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService, UserDetailsService {

	@Autowired
	UserProfileRepository userProfileRepo;

	public UserProfileServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserProfile userLogin(UserProfile userProfile) throws LoginException {
		UserProfile returnUser = userProfileRepo.findByUserNameAndPasswordAndIsActive(userProfile.getUserName(),
				userProfile.getPassword(), userProfile.getIsActive());
		if (returnUser == null) {
			throw new LoginException("Invalid Login Credentials");
		}
		return returnUser;
	}

	@Override
	public void signUp(UserProfile userProfile) throws LoginException {
		if (userProfile != null) {

			UserProfile registeredUserName = userProfileRepo.findByUserName(userProfile.getUserName());
			if (registeredUserName != null) {
				throw new LoginException("Username is already taken. Please select a different username.");
			}

			UserProfile registeredEmail = userProfileRepo.findByEmailAddress(userProfile.getEmailAddress());
			if (registeredEmail != null) {
				throw new LoginException(
						"User with the given Email Address already exists. "
						+ "Please use a different email address");
			}

			userProfile.setCreatedDate(new Date());
			userProfile.setCreatedBy(userProfile.getUserName());
			userProfile.setModifiedDate(new Date());
			userProfile.setModifedBy(userProfile.getUserName());
			userProfileRepo.save(userProfile);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserProfile userProfile = userProfileRepo.findByUserName(userName);
		if (userProfile == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new User(userProfile.getUserName(), userProfile.getPassword(), emptyList());
	}

}
