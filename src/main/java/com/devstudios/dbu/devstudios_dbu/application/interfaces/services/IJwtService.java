package com.devstudios.dbu.devstudios_dbu.application.interfaces.services;

import com.devstudios.dbu.devstudios_dbu.domain.entities.RoleEntity;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;


public interface IJwtService {

    public String createToken( Collection<GrantedAuthority> roles, String username );
    public String createToken( List<RoleEntity> roles, String username );
    public Collection<GrantedAuthority> rolesToCollection( List<RoleEntity> roles );

}
