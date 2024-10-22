package com.devstudios.dbu.devstudios_dbu.application.dtos.User;

import java.util.List;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IUserPreview;
import com.devstudios.dbu.devstudios_dbu.domain.entities.RoleEntity;




public class UserPreviewDto implements IUserPreview {
    private Long id;
    private String email;
    private List<RoleEntity> roles;
    private Boolean isActive;


    public UserPreviewDto(Long id, String email, List<RoleEntity> roles, Boolean isActive) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.isActive = isActive;
    }


    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public List<RoleEntity> getRoles() {
        return roles;
    }
    public Boolean getIsActive() {
        return isActive;
    }

}
