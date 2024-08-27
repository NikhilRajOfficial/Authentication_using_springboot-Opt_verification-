package com.nikhil.Authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.Authentication.dto.Request;
import com.nikhil.Authentication.dto.Response;
import com.nikhil.Authentication.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping("signup")
    public ResponseEntity<Response> signup(@RequestBody Request request)
    {
        return userService.signUp(request);
    }
    
}
