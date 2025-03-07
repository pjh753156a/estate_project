package com.estate.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 로그인 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto
{
    @NotBlank
    private String userId;
    @NotBlank
    private String userPassword;
}
/* 최종완료 */