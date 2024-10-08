package com.nikhil.Authentication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.Authentication.dto.OtpRequest;
import com.nikhil.Authentication.dto.OtpValidationRequest;
import com.nikhil.Authentication.dto.Response;
import com.nikhil.Authentication.service.impl.OtpService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/otp")
@AllArgsConstructor
public class OtpController {
    
    private final OtpService otpService;
    
    
    @PostMapping("sendOtp")
    public Response sendOtp(@RequestBody OtpRequest otpRequest)
    {
             return otpService.sendOtp(otpRequest);
    }

     @PostMapping("validateOtp")
     public Response validateOtp(@RequestBody OtpValidationRequest otpValidationRequest)
     {
        return otpService.validateOtp(otpValidationRequest);
        }

}
