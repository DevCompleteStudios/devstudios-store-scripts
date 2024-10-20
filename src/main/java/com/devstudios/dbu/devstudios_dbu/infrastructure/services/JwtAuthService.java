package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.services.IJwtService;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class JwtAuthService extends UsernamePasswordAuthenticationFilter {

    private IJwtService jwtService;
    private AuthenticationManager manager;

    public JwtAuthService( IJwtService jwtService, AuthenticationManager manager ){
        this.jwtService = jwtService;
        this.manager = manager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = null;
        UserEntity user = null;

        try {
            user = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
            email = user.getEmail();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, email);
        return manager.authenticate(auth);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        // TODO Auto-generated method stub
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date());
        res.put("err", "email is not valid, contact support");
        res.put("status", 400);

        response.getWriter().write(new ObjectMapper().writeValueAsString(res));
        response.setStatus(400);
    }

}
