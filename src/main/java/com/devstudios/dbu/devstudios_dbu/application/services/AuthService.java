package com.devstudios.dbu.devstudios_dbu.application.services;

import com.devstudios.dbu.devstudios_dbu.application.dtos.Auth.RegisterUserDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.ICodeAuthRepository;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IUserRepository;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IJwtService;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IRandomCodes;
import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;
import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRandomCodes randomCode;
    @Autowired
    ICodeAuthRepository codeAuthRepository;
    @Autowired
    IJwtService jwtService;


    public ResponseDto<UserEntity> RegisterUser( RegisterUserDto userDto ){
        Optional<UserEntity> userDb = userRepository.findUserByEmail(userDto.getEmail());
        UserEntity user;
        int status = 200;

        if( userDb.isPresent() ){
            user = userDb.get();
            var codeDb = user.getAuthCode();

            if( codeDb != null ){
                user.setAuthCode(null);
                codeAuthRepository.deleteById(codeDb.getId());
            }
        } else {
            user = userRepository.save(new UserEntity(userDto.getEmail()));
            status = 201;
        }

        CodeAuthEntity codeAuth = new CodeAuthEntity();
        codeAuth.setCode(randomCode.authGenerateCode(6));

        user.setAuthCode(codeAuth);
        userRepository.save(user);

        return new ResponseDto<>(user, status, "Check the code that was sent to your email.");
    }

    public ResponseDto<String> verifyAccountByCode( String code ){
        UserEntity userDb = userRepository.findUserByCode(code)
            .orElseThrow( () -> CustomException.NotFoundException("Code expired"));
        var codeDb = userDb.getAuthCode();

        userDb.setAuthCode(null);
        codeAuthRepository.deleteById(codeDb.getId());
        userRepository.save(userDb);

        return new ResponseDto<>(jwtService.createToken(userDb.getRoles(), userDb.getEmail()), 200, "its working!");
    }

}
