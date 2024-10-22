package com.devstudios.dbu.devstudios_dbu.application.interfaces.projections;

import java.util.List;

import com.devstudios.dbu.devstudios_dbu.domain.entities.RoleEntity;

public interface IUser {
    public String getEmail();
    public List<RoleEntity> getRoles();
}
