package com.vinit.angularspringboot.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.vinit.angularspringboot.exception.LoginException;
import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.services.UserProfileService;

@RestController
public class UserProfileContoller {

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		UserProfile returnUser = userProfileService.getUser();
		return ResponseEntity.status(200).body(returnUser);
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> signUp(@RequestBody HashMap<String, String> requestParam) {
		Map<String, String> returnMap = new HashMap<>();
		try {
			if ((requestParam.get("userName") == null && requestParam.get("emailAddress")== null)
					|| requestParam.get("password")== null || requestParam.get("firstName") == null
					|| requestParam.get("lastName") == null) {
				returnMap.put("message", "Please enter mandatory fields");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnMap);
			}
			UserProfile userProfile = new UserProfile();
			userProfile.setUserName(requestParam.get("userName"));
			userProfile.setPassword(bCryptPasswordEncoder.encode(requestParam.get("password")));
			userProfile.setEmailAddress(requestParam.get("emailAddress"));
			userProfile.setFirstName(requestParam.get("firstName"));
			userProfile.setLastName(requestParam.get("lastName"));
			userProfileService.signUp(userProfile);
			
		} catch (LoginException e) {
			returnMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnMap);
		} catch (Exception e) {
			returnMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(returnMap);
		}
		returnMap.put("message", "You have successfully registered. Please login to continue");
		return ResponseEntity.status(HttpStatus.OK).body(returnMap);
	}

	@RequestMapping(value = "/getAllSUggestions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getAllSuggestion() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	}
}
