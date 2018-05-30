package com.vinit.angularspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinit.angularspringboot.domainObjects.UserProfile;

@RestController
public class UserProfileContoller {

	@CrossOrigin("*")
	@RequestMapping(value="/getUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getUser(@RequestBody UserProfile user){
		Map<String,Object> returnmap = new HashMap<>();
		
		user.setFirstName("Vinit");
		user.setLastName("Divekar");
		user.setEmailAddress("vinit@flink.co.nz");
		returnmap.put("user", user);
		returnmap.put("success", true);
		returnmap.put("message", "Login Successful!");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(returnmap);		
	}
}
