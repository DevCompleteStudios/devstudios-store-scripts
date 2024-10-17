package com.devstudios.dbu.devstudios_dbu.domain.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;

    private List<String> robloxAccounts = new ArrayList<>();
    private final List<RoleEntity> roles = new ArrayList<>();
    private final List<String> authCodes = new ArrayList<>();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<String> getRobloxAccounts() {
        return robloxAccounts;
    }
    public void setRobloxAccounts(List<String> robloxAccounts) {
        this.robloxAccounts = robloxAccounts;
    }
    public List<RoleEntity> getRoles() {
        return roles;
    }
    public void setRole(RoleEntity role) {
        this.roles.add(role);
    }
    public List<String> getAuthCodes() {
        return authCodes;
    }
    public void setAuthCode(String code) {
        this.authCodes.add(code);
    }

}
