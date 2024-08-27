package com.nikhil.Authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.Authentication.entity.UserOtp;
import java.util.List;


public interface OtpRepo extends JpaRepository<UserOtp, Long> {

  UserOtp  findByEmail(String email);
    
} 
