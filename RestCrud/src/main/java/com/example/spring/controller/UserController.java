package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.User;
import com.example.spring.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUserDetails")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user){
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserDetails/{id}")
	public ResponseEntity<User> getUserDetailsByID(@PathVariable Long id){
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUserDetails")
	public ResponseEntity<List<User>> getAllUserDetails(){
		List<User> listOfUsers = userService.getAllUsers();
		return new ResponseEntity<>(listOfUsers ,HttpStatus.OK);
	}
	
	@PutMapping("/updateUserDetails/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable Long id,@RequestBody User user){
		user.setId(id);
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserDetails/{id}")
	public ResponseEntity<User> deleteUserDetails(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
