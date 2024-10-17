package com.devstudios.dbu.devstudios_dbu.application.interfaces.services;

import java.util.UUID;




public interface IRandomCodes {
    String authGenerateCode( int countDigits );
    UUID uuid();
}
