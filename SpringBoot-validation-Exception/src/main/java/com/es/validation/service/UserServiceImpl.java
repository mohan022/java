package com.es.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.validation.entity.User;
import com.es.validation.model.UserRequest;
import com.es.validation.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;

	@Override
	public User createUser(UserRequest userRequest) {
		 User user = User.builder()
		            .name(userRequest.getName())
		            .email(userRequest.getEmail())
		            .mobile(userRequest.getMobile())
		            .age(userRequest.getAge())
		        .build();

		return repo.save(user);
	}
}
