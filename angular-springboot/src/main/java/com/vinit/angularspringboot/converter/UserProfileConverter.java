package com.vinit.angularspringboot.converter;

import java.util.Base64;

import org.modelmapper.ModelMapper;

import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.dto.UserDTO;
import com.vinit.angularspringboot.exception.MyTripException;

public class UserProfileConverter {

	public UserProfileConverter() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO convertToUserDTO(UserProfile source) throws MyTripException{
		ModelMapper mapper = new ModelMapper();
		UserDTO userDto = mapper.map(source, UserDTO.class);
		userDto.setProfilePictureStr(Base64.getEncoder().encodeToString(source.getProfilePicture()));
		return userDto;
	}
}
