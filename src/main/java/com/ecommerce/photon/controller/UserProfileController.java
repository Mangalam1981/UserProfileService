package com.ecommerce.photon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.photon.model.User;
import com.ecommerce.photon.service.UserProfileService;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileService service;
	
	@RequestMapping(method=RequestMethod.GET,value="/getUser")
	public User getUser(@RequestParam String email,@RequestParam String password) throws Exception {
		System.out.println("From Controller======Email==========>"+email);
		System.out.println("From Controller======password==========>"+password);
		return service.getUserByEmail(email, password);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/registerNewUser")
	public String registerNewUser(@RequestBody User user) {
		System.out.println("From Controller================>"+user.toString());
		return service.addNewUser(user);
	}
}
