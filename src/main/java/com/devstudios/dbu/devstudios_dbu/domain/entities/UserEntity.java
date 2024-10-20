package com.devstudios.dbu.devstudios_dbu.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class UserEntity extends EntityBase {

    @Column(unique=true)
    private String email;

    @ManyToMany
    private final List<RoleEntity> roles = new ArrayList<>();
    @OneToOne(cascade=CascadeType.ALL)
    private CodeAuthEntity authCode;
    @OneToMany
    private List<PurchacesEntity> purchases = new ArrayList<>();


    public UserEntity(){}
    public UserEntity(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<RoleEntity> getRoles() {
        return roles;
    }
    public void setRole(RoleEntity role) {
        this.roles.add(role);
    }
    public CodeAuthEntity getAuthCode() {
        return authCode;
    }
    public void setAuthCode(CodeAuthEntity code) {
        this.authCode = code;
    }

    @Override
    public String toString() {
        return "UserEntity [email=" + email + ", robloxAccounts=" + ", roles=" + roles + ", authCode="
                + authCode + ", getEmail()=" + getEmail()
                + ", getId()=" + getId() + ", getRoles()=" + getRoles() + ", getAuthCode()=" + getAuthCode() + "]";
    }

}
