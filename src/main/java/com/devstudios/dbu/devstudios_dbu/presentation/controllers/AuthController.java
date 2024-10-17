package com.devstudios.dbu.devstudios_dbu.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devstudios.dbu.devstudios_dbu.application.dtos.Auth.RegisterUserDto;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> validateAccount( @Validated @RequestBody RegisterUserDto register ){
        return ResponseEntity.ok(register);
    }

}
