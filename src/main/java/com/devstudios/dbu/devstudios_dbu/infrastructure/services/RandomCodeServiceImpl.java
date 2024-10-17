package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IRandomCodes;




@Service
public class RandomCodeServiceImpl implements IRandomCodes {

    private final Random random = new Random();

    @Override
    public String authGenerateCode(int countDigits) {
        String code = "";

        for( int i = 0; i < countDigits; i++ ){
            code += random.nextInt(0, 9);
        }

        return code;
    }

    @Override
    public UUID uuid() {
        return UUID.randomUUID();
    }

}
