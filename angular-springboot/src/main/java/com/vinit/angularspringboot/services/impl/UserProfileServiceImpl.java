package com.vinit.angularspringboot.services.impl;

import static java.util.Collections.emptyList;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Date;

import javax.validation.ValidationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vinit.angularspringboot.converter.UserProfileConverter;
import com.vinit.angularspringboot.domainObjects.UserProfile;
import com.vinit.angularspringboot.dto.UserDTO;
import com.vinit.angularspringboot.exception.LoginException;
import com.vinit.angularspringboot.exception.MyTripException;
import com.vinit.angularspringboot.repository.UserProfileRepository;
import com.vinit.angularspringboot.services.UserProfileService;

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

	@Override
	public UserDTO getUser() throws MyTripException {
		UserProfile user = userProfileRepo.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		UserDTO userDto = new UserProfileConverter().convertToUserDTO(user);
//		InputStream stream = new InputStream
		try
		{
			userDto.setContentType(URLConnection.guessContentTypeFromStream(
					new BufferedInputStream(
							new ByteArrayInputStream(user.getProfilePicture()))
					));	
		} catch(Exception e){
			throw new MyTripException("Error getting profile image");
		}
		return userDto;
	}

	@Override
	@Transactional
	public void uploadProfilePicture(MultipartFile file) throws IOException {
		if(file.getContentType() != null && file.getContentType().toLowerCase().contains("image")){
			userProfileRepo.saveProfilePicture(file.getBytes(), SecurityContextHolder.getContext().getAuthentication().getName());			
		} else {
			throw new ValidationException("Only image files can be uploaded");
		}		
	}
}
