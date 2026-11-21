package com.example.Frostney.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.AccountRequest;
import com.example.Frostney.Entity.Account;
import com.example.Frostney.Services.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createaccount(@RequestBody AccountRequest acc){
		String res = accountService.createAccount(acc.getUser_id(), acc);
		
		return ResponseEntity.ok(res);
	}
}
