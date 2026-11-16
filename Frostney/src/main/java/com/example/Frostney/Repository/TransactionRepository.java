package com.example.Frostney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Long>{

}
