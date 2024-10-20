package com.devstudios.dbu.devstudios_dbu.presentation.controllers;

import com.devstudios.dbu.devstudios_dbu.application.dtos.Auth.RegisterUserDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.services.AuthService;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService service;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto<UserEntity>> validateAccount( @Validated @RequestBody RegisterUserDto register ){
        var res = service.RegisterUser(register);
        return ResponseEntity.status(res.getStatus()).body(res);
    }

    @GetMapping("/verify-account/{code}")
    public ResponseEntity<ResponseDto<String>> verifyAccount( @PathVariable String code ){
        var res = service.verifyAccountByCode(code);
        return ResponseEntity.status(res.getStatus()).body(res);
    }

}
