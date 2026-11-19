package com.example.Frostney.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Frostney.Entity.User;
import com.example.Frostney.Repository.UserRepository;

@Service
public class UserServices {
	
	final UserRepository userRepository;
	final PasswordEncoder passwordEncoder;
	
	public UserServices(UserRepository userRepository , PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public String signUp(User newUser) {
		if(newUser.getUsername() == null || newUser.getEmail() == null || newUser.getPassword() == null ) {
			return " Please enter all the fields";
		}
		if(userRepository.existByEmail(newUser.getEmail())) {
			return " Email Already eists please sign in";
		}
		if(userRepository.existByUserName(newUser.getUsername())) {
			return " UserName Already Taken ";
		}
		
		String hashPassword = passwordEncoder.encode(newUser.getPassword());
		
		newUser.setPassword(hashPassword);
		userRepository.save(newUser);
		return " USer Registered Successfully";
	}
}
