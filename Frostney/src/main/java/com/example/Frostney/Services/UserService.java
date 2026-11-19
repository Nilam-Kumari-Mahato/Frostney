package com.example.Frostney.Services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Frostney.DTO.SignInRequest;
import com.example.Frostney.Entity.User;
import com.example.Frostney.Repository.UserRepository;



@Service
public class UserService {
	
	final UserRepository userRepository;
	final PasswordEncoder passwordEncoder;
	
	//Signup
	
	public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public String signUp(User newUser) {
		if(newUser.getUsername() == null || newUser.getEmail() == null || newUser.getPassword() == null ) {
			return " Please enter all the fields";
		}
		if(userRepository.existsByEmail(newUser.getEmail())) {
			return " Email Already eists please sign in";
		}
		if(userRepository.existsByUsername(newUser.getUsername())) {
			return " UserName Already Taken ";
		}
		
		String hashPassword = passwordEncoder.encode(newUser.getPassword());
		
		newUser.setPassword(hashPassword);
		userRepository.save(newUser);
		return " USer Registered Successfully";
	}
	
	
	//SignIn
	public String signIn(SignInRequest request) {
		
		if(request.getEmail() == null || request.getEmail().isBlank() ||
				request.getPassword() == null || request.getPassword().isBlank()) {
			return " Please Provide Email and Password ";
		}
		
		Optional<User> load_user = userRepository.findByEmail(request.getEmail().trim().toLowerCase());
		
		if (load_user.isEmpty()) {
	        return "Invalid email or password";
	    }

	    User user = load_user.get();
		
		boolean isPasswordValid = passwordEncoder.matches(request.getPassword(), user.getPassword());
		
		if(!isPasswordValid) {
			return "Invalid Password";
		}
		
		String u= user.getUsername() + " " + user.getEmail();
		return "Login Successful" + u;
	}
}
