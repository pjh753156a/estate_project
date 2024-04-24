package com.estate.back.service;

import org.springframework.http.ResponseEntity;

import com.estate.back.dto.request.auth.EmailAuthCheckRequestDto;
import com.estate.back.dto.request.auth.EmailAuthRequestDto;
import com.estate.back.dto.request.auth.SignInRequestDto;
import com.estate.back.dto.request.auth.SignUpRequestDto;
import com.estate.back.dto.request.auth.idCheckRequestDto;
import com.estate.back.dto.response.ResponseDto;

public interface AuthService 
{
    ResponseEntity<? super SignInRequestDto> signIn (SignInRequestDto dto);
    ResponseEntity<ResponseDto> idCheck(idCheckRequestDto dto);
    ResponseEntity<ResponseDto> emailAuth(EmailAuthRequestDto dto);
    ResponseEntity<ResponseDto> emailAuthCheck(EmailAuthCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);

}
