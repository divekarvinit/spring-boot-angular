package com.vinit.angularspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.angularspringboot.LoginException;
import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.services.UserProfileService;

@RestController
public class UserProfileContoller {

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public ResponseEntity<Object> getUser(@RequestBody UserProfile user) {
		UserProfile returnuser;
		//UserProfile userDetails = userProfileService.getUser(user);
		// return ResponseEntity.status(HttpStatus.OK).body(returnuser) ;
		return ResponseEntity.status(200).body(user);
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> signUp(@RequestBody UserProfile userProfile) {
		try {
			if ((userProfile.getUserName() == null && userProfile.getEmailAddress() == null)
					|| userProfile.getPassword() == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}

			userProfile.setPassword(bCryptPasswordEncoder.encode(userProfile.getPassword()));
			userProfileService.signUp(userProfile);
		} catch (LoginException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.OK).body("You are successfully registered. Please log in.");
	}

	@RequestMapping(value = "/getAllSUggestions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getAllSuggestion() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getCredentials());
	}
}
