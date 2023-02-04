package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.User;

public interface UserService {

	void saveUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	User updateUser(User user);
	
	void deleteUser(Long id);
	
}
