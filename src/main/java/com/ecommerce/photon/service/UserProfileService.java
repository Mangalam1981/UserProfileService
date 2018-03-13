package com.ecommerce.photon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.photon.model.User;
import com.ecommerce.photon.repo.UserProfileRepo;
@Service
public class UserProfileService {

	@Autowired
	UserProfileRepo profileRepo;
	
	public User getUserByEmail(String email,String password) {
		return profileRepo.findUserByEmail(email,password);
	}
	
}
