package com.es.validation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.validation.entity.User;
import com.es.validation.model.UserRequest;
import com.es.validation.model.UserResponse;
import com.es.validation.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest request){
		return new ResponseEntity<>(service.createUser(request), HttpStatus.CREATED);
		
	}

}
