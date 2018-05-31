package com.vinit.angularspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.angularspringboot.InvalidCredentialException;
import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.services.UserProfileService;

@RestController
public class UserProfileContoller {

	@Autowired
	UserProfileService userProfileService;
	
	@CrossOrigin("*")
	@RequestMapping(value="/getUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> getUser(@RequestBody UserProfile user){
		UserProfile returnuser;
		try {
			returnuser = userProfileService.userLogin(user);
			return ResponseEntity.status(HttpStatus.OK).body(returnuser) ;
		} catch (InvalidCredentialException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}	
	}
}
