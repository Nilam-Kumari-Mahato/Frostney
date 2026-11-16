package com.example.Frostney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Frostney.Entity.User;

public interface UserRepository extends JpaRepository<User , Long> {

}
