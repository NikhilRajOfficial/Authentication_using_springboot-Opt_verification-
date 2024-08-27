package com.nikhil.Authentication.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nikhil.Authentication.dto.LoginRequest;
import com.nikhil.Authentication.dto.Request;
import com.nikhil.Authentication.dto.Response;
import com.nikhil.Authentication.dto.UserInfo;
import com.nikhil.Authentication.entity.User;
import com.nikhil.Authentication.repositories.UserRepo;
import com.nikhil.Authentication.service.UserService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {


       
       private UserRepo userRepo;
       private ModelMapper modelMapper;
       private PasswordEncoder passwordEncoder;



    @Override
    public ResponseEntity<Response> signUp(Request request) {
        
             if(userRepo.findByEmail(request.getEmail()).isPresent())
             {
                  return  ResponseEntity.badRequest().body(Response.builder()
                  .statusCode(400)
                  .responseMessage("Attempt to save duplicate user")
                  .build());
             }

              User user= User.builder()
              .email(request.getEmail())
              .password(passwordEncoder.encode(request.getPassword()))
              .firstName(request.getFirstName())
              .lastName(request.getLastName())
              .build();
              

              User savedUser= userRepo.save(user);


              return ResponseEntity.ok(Response.builder()
              .statusCode(200)
              .responseMessage("Sucess")
              .userInfo(modelMapper.map(savedUser, UserInfo.class))
              .build());

    }

    @Override
    public ResponseEntity<Response> login(LoginRequest loginRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public Response sendOtp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendOtp'");
    }

    @Override
    public Response validation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validation'");
    }

    @Override
    public Response resetPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetPassword'");
    }

    @Override
    public Response changePassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }

}
