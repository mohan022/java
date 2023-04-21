package com.es.validation.service;

import com.es.validation.entity.User;
import com.es.validation.model.UserRequest;

public interface UserService {
	
	 User createUser(UserRequest request);

}
