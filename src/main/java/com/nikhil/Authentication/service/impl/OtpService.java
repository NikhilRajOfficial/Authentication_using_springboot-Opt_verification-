package com.nikhil.Authentication.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.nikhil.Authentication.dto.EmailDetails;
import com.nikhil.Authentication.dto.OtpRequest;
import com.nikhil.Authentication.dto.OtpResponse;
import com.nikhil.Authentication.dto.OtpValidationRequest;
import com.nikhil.Authentication.dto.Response;
import com.nikhil.Authentication.entity.UserOtp;
import com.nikhil.Authentication.repositories.OtpRepo;
import com.nikhil.Authentication.utils.AppUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {

    private final OtpRepo otpRepo;
    private final EmailServiceImp emailServiceImp;

    public Response sendOtp(OtpRequest otpRequest)
    {
        UserOtp existionOtp = otpRepo.findByEmail(otpRequest.getEmail());
        if(existionOtp!=null)
        {
             otpRepo.delete(existionOtp);
        }


        String otp= AppUtils.generateOtp();
        log.info("Otp : {}" ,  otp);

        
         otpRepo.save(UserOtp.builder()
         .email(otpRequest.getEmail())
         .otp(otp)
         .expiredAt(LocalDateTime.now().plusMinutes(4))
         
         .build());
        emailServiceImp.sendEmail(EmailDetails.builder()
        .subject("DO NOT DISCLOSE !!")
        .recipient(otpRequest.getEmail())
        .messageBody("Truly Nike sent you an Otp : " + otp)
        .build());


        return Response.builder()
        .statusCode(200)
        .responseMessage("SUCESS")
        .build();

    }

    
       public Response validateOtp(OtpValidationRequest otpValidationRequest)
       {
           UserOtp otp= otpRepo.findByEmail(otpValidationRequest.getEmail());
           log.info("Email : {}" , otpValidationRequest.getEmail());
           if(otp==null)
           {
            return Response.builder()
            .statusCode(400)
            .responseMessage("Invalid Email")
            .build();
            }

             if(otp.getExpiredAt().isBefore(LocalDateTime.now()))
             {
                return Response.builder()
                .statusCode(400)
                .responseMessage("Otp Expired")
                .build();

             }

             if(!otp.getOtp().equals(otpValidationRequest.getOtp()))
             {
                return Response.builder()
                .statusCode(400)
                .responseMessage("Invalid Otp")
                .build();
            
             }

             return Response.builder()
             .statusCode(200)
             .responseMessage("Valid Otp")
             .otpResponse(OtpResponse.builder()
                         .isOtpValid(true)  
                        .build())
             .build();

       }

}
