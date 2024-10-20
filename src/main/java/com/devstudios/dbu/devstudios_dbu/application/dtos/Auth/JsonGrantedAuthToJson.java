package com.devstudios.dbu.devstudios_dbu.application.dtos.Auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonGrantedAuthToJson {

    @JsonCreator
    public JsonGrantedAuthToJson(
        @JsonProperty("authority") String role
    ){}

}
