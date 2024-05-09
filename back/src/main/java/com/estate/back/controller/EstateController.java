package com.estate.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.back.service.EstateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/vi/estate")
@RequiredArgsConstructor
public class EstateController 
{
    private final EstateService estateService;
}
//???
