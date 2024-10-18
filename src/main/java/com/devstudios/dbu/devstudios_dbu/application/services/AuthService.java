package com.devstudios.dbu.devstudios_dbu.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devstudios.dbu.devstudios_dbu.application.dtos.Auth.RegisterUserDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IUserRepository;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IRandomCodes;
import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;



@Service
public class AuthService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRandomCodes randomCode;


    public ResponseDto<UserEntity> RegisterUser( RegisterUserDto userDto ){
        Optional<UserEntity> userDb = userRepository.findUserByEmail(userDto.getEmail());
        UserEntity user;
        int status = 200;

        if( userDb.isPresent() ){
            user = userDb.get();
        } else {
            user = userRepository.save(new UserEntity(userDto.getEmail()));
            status = 201;
        }

        user.getAuthCodes().clear();
        CodeAuthEntity codeAuth = new CodeAuthEntity();
        codeAuth.setCode(randomCode.authGenerateCode(6));

        user.setAuthCode(codeAuth);
        userRepository.save(user);

        return new ResponseDto<>(user, status, "Check the code that was sent to your email.");
    }

}
