package com.nikhil.Authentication.service;

import org.springframework.http.ResponseEntity;

import com.nikhil.Authentication.dto.LoginRequest;
import com.nikhil.Authentication.dto.Request;
import com.nikhil.Authentication.dto.Response;

public interface UserService  {

      ResponseEntity<Response> signUp(Request request);
      ResponseEntity<Response> login(LoginRequest loginRequest);
      Response sendOtp();
      Response validation();
      Response resetPassword();
      Response changePassword();
} 
