package com.nikhil.Authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nikhil.Authentication.dto.EmailDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImp {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;


    public  void sendEmail(EmailDetails emailDetails)
    {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(emailSender);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setText(emailDetails.getMessageBody());

            javaMailSender.send(mailMessage);

            log.info("Message sent to {}" , emailDetails.getRecipient());
            log.info("Message Sender : {}", emailSender);
        
        
        
        } catch (Exception e) {
           e.printStackTrace();
        }



    }

}
