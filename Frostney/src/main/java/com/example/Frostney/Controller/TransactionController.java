package com.example.Frostney.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.TransactionRequest;
import com.example.Frostney.Services.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	private final TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/create")
	public ResponseEntity<String> addtransaction(@RequestBody TransactionRequest request){
		
		String response = transactionService.addTransaction(request);
		
		return ResponseEntity.ok(response);
	}
	
}
