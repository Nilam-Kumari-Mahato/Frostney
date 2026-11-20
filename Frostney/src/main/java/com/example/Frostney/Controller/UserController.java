package com.example.Frostney.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.SignInRequest;
import com.example.Frostney.Entity.User;
import com.example.Frostney.Services.UserService;



@RestController
@RequestMapping("/api/auth")
public class UserController {
	
	final UserService userService;
	
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	
	//SignUP API
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		
		String res = userService.signUp(user);
		return ResponseEntity.ok(res);
	}
	
	//SignIn APi
	@PostMapping("/signin")
	public ResponseEntity<String> signIn(@RequestBody SignInRequest request){
		String result = userService.signIn(request);
		
		return ResponseEntity.ok(result);
	}
}
