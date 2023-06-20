package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.repo.UserRepo;
import com.app.weather.service.EmailService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController 
{
	@Autowired
	private EmailService emailSendService;
	
	@Autowired
	private UserRepo repo;
	@PostMapping("/user")
	
	public ResponseEntity<?> User(@RequestBody User userData){
		
		 String email = userData.getEmail();
	        boolean exist = repo.existsById(email);
	        if(exist)
	                return (ResponseEntity<?> ) ResponseEntity.badRequest();
	        User user =repo.save(userData);
	       String userEmail = userData.getEmail();
	        String emailBody = "Hi\n\n You have been registered successfully on Weather Forecast. You may proceed for login.\n\nThanks";
	        String subject  = "Registration Successful";
	        emailSendService.sendSimpleEmail(userEmail, emailBody, subject);
	        
	        return ResponseEntity.ok(user);		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData){
	   User user = repo.findByEmail(userData.getEmail());
	   if(user.getPassword().equals(userData.getPassword()))
	      return ResponseEntity.ok(user);
	    
	   
	   return (ResponseEntity<?>) ResponseEntity.badRequest();
	   
	}
	
	

}



