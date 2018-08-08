package com.vinit.angularspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinit.angularspringboot.domainObjects.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

	public UserProfile findByUserNameAndPasswordAndIsActive(String userName, String password, Character isActive);

	public UserProfile findByUserName(String userName);

	public UserProfile findByEmailAddress(String emailAddress);
	
	@Modifying
	@Query("Update UserProfile u set u.profilePicture = ?1 where u.userName = ?2")
	public void saveProfilePicture(byte[] fileBytes, String userName);
}
