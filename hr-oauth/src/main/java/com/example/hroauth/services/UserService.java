package com.example.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	UserFeignClient userFeignClient;
	
	public User findByEmail(String Email) {
		User user = userFeignClient.findByEmail(Email).getBody();
		
		if(user == null) {
			throw new IllegalArgumentException("Email not found.");
		}
		
		return user;
	}
	
}
