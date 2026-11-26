package com.example.Frostney.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Frostney.DTO.TransactionRequest;
import com.example.Frostney.Entity.Transaction;
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
	
	@GetMapping("/get/{transaction_id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable Long transaction_id) {
		Transaction transc = transactionService.getTransactionById(transaction_id);
		
		return ResponseEntity.ok(transc);
	}
	
	@GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUserId(
            @PathVariable Long userId) {

        return transactionService.getAllTransaction(userId);
    }

    // Get transactions by user and type
    @GetMapping("/user/{userId}/type/{type}")
    public List<Transaction> getTransactionsByUserIdAndType(
            @PathVariable Long userId,
            @PathVariable String type) {

        return transactionService
                .getTransactionsByUserIdAndType(userId, type);
    }

    // Get transactions by user and account
    @GetMapping("/user/{userId}/account/{accountId}")
    public List<Transaction> getTransactionsByUserIdAndAccount(
            @PathVariable Long userId,
            @PathVariable Long accountId) {

        return transactionService
                .getTransactionsByUserIdAndAccount(userId, accountId);
    }
	
}
