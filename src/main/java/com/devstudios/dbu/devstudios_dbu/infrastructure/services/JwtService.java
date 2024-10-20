package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IJwtService;
import static com.devstudios.dbu.devstudios_dbu.config.JwtEnvs.getDateExpire;
import static com.devstudios.dbu.devstudios_dbu.config.JwtEnvs.getKey;
import com.devstudios.dbu.devstudios_dbu.domain.entities.RoleEntity;
import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;



@Service
public class JwtService implements IJwtService {

    @Override
    public String createToken(Collection<GrantedAuthority> roles, String username) {
        try {
            Claims claims = Jwts.claims()
                .add("authorities", new ObjectMapper().writeValueAsString(roles))
                .build();

                String token = Jwts.builder()
                .subject(username)
                .claims(claims)
                .signWith(getKey())
                .expiration(getDateExpire())
                .compact();

            return token;
        } catch (JsonProcessingException e) {
            throw CustomException.InternalServerError(e.getMessage());
        }
    }

    @Override
    public String createToken(List<RoleEntity> roles, String username) {
        Collection<GrantedAuthority> authorities = this.rolesToCollection(roles);
        return this.createToken(authorities, username);
    }

    @Override
    public Collection<GrantedAuthority> rolesToCollection(List<RoleEntity> roles) {
        Collection<GrantedAuthority> authorities = roles.stream()
            .map( r -> new SimpleGrantedAuthority(r.getRole()) )
            .collect(Collectors.toList());

        return authorities;
    }

}
