package com.estate.back.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 아이디 중복확인 Request Body Dto

@Getter
@Setter
@NoArgsConstructor
public class idCheckRequestDto
{
    @NotBlank
    private String userId;
}
/* 최종완료 */