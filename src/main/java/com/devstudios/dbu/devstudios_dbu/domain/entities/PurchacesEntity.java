package com.devstudios.dbu.devstudios_dbu.domain.entities;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.enums.PurchaseStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purhcases")
public class PurchacesEntity extends EntityBase {

    private PurchaseStatus status;
    private String key;
    @ManyToOne
    private UserEntity user;


    public PurchaseStatus getStatus() {
        return status;
    }
    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
