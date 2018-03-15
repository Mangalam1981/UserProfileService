package com.ecommerce.photon.repo;

import com.ecommerce.photon.model.User;

public interface UserProfileRepo {

	User findUserByEmail(String email, String password) throws Exception;
	String addNewUser(User user);
}
