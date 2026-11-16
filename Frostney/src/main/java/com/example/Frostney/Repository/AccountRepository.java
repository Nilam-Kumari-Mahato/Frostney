package com.example.Frostney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.Account;

public interface AccountRepository extends JpaRepository<Account , Long>{

}
