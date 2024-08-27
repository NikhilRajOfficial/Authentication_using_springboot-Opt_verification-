package com.nikhil.Authentication.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserOtp {
   
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String otp;
     private String email;

     @CreationTimestamp
     private LocalDateTime createdAt;
     private LocalDateTime expiredAt;


}
