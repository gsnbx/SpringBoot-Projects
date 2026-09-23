package com.gsn.UserManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsn.UserManagement.entity.UserEntity;
import com.gsn.UserManagement.exceptions.ResourceNotFoundException;
import com.gsn.UserManagement.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String greet() {
		return "Hellow";
	}
	
	@GetMapping("/userlist")
	public List<UserEntity> getUserList(){
		return userRepository.findAll();
	}
	
	@PostMapping("/create")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/select/{id}")
	public UserEntity selectById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id"+id));
	}
	
	@PutMapping("/update/{id}")
	public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
		UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id"+id));
		userData.setName(user.getName());
		userData.setMail(user.getMail());
		return userRepository.save(userData);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		UserEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id"+id));
		userRepository.delete(userData);
		return ResponseEntity.ok().build();
	}
	
	
	
}
