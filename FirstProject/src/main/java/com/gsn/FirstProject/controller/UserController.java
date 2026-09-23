package com.gsn.FirstProject.controller;

import java.util.List;
import java.util.Optional;

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

import com.gsn.FirstProject.entity.UserEntity;
import com.gsn.FirstProject.exceptions.ResourceNotFoundException;
import com.gsn.FirstProject.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello World !";
	}
	
	@GetMapping()
	public List<UserEntity> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping()
	public UserEntity createUser(@RequestBody UserEntity user) {
		
		System.out.println(user.getName()+" "+user.getMail());
		return userRepository.save(user);
	}
	
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
	    return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User not found in this id "+id));
	}
	
	@PutMapping("/{id}")
	public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
		UserEntity userData = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User not found in this id "+id)); 
		userData.setName(user.getName());
		userData.setMail(user.getMail());
		return userRepository.save(userData);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		UserEntity userData = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("user not found in this id "+id) );
		userRepository.delete(userData);
		return ResponseEntity.ok().build();
	}
}
