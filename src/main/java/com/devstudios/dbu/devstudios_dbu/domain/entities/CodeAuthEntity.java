package com.devstudios.dbu.devstudios_dbu.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="codes_auth")
public class CodeAuthEntity extends EntityBase {

    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
