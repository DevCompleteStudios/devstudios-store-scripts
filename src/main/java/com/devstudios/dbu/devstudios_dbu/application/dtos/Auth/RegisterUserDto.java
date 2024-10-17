package com.devstudios.dbu.devstudios_dbu.application.dtos.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
public class RegisterUserDto {
    @NotNull
    @Email
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
