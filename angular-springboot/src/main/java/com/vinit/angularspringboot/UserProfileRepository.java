package com.vinit.angularspringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinit.angularspringboot.domainObjects.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

	public UserProfile findByUserNameAndPasswordAndIsActive(String userName, String password, Character isActive);

	public UserProfile findByUserName(String userName);

	public UserProfile findByEmailAddress(String emailAddress);
}
