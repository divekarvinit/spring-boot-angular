package com.vinit.angularspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileContoller {

	@RequestMapping(value="/GetUser",method=RequestMethod.GET)
	public String getUser(){
		return "I am the only user";		
	}
}
