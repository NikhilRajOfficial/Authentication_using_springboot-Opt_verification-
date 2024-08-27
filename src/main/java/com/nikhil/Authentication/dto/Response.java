package com.nikhil.Authentication.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int statusCode;
    private UserInfo userInfo;
    private String responseMessage;
    private OtpResponse otpResponse;

}
