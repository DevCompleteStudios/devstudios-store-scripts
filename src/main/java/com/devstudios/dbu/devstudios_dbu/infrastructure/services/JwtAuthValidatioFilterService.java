package com.devstudios.dbu.devstudios_dbu.infrastructure.services;

import com.devstudios.dbu.devstudios_dbu.application.dtos.Auth.JsonGrantedAuthToJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;




public class JwtAuthValidatioFilterService extends BasicAuthenticationFilter {

    public AuthenticationManager manager;
    private SecretKey key;

    public JwtAuthValidatioFilterService(AuthenticationManager authenticationManager, SecretKey key) {
        super(authenticationManager);
        this.manager = authenticationManager;
        this.key = key;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        String prefix = "Bearer ";

        if( header == null || !header.startsWith(prefix) ){
            chain.doFilter(request, response);
            return;
        }

        String token = header.replace(prefix, "");

        try {
            Claims claims = Jwts.parser().verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

            String email = (String)claims.getSubject();
            Object authorities = claims.get("authorities");

            Collection<? extends GrantedAuthority> roles = Arrays.asList(
                new ObjectMapper()
                    .addMixIn(SimpleGrantedAuthority.class, JsonGrantedAuthToJson.class)
                    .readValue(authorities.toString().getBytes(), SimpleGrantedAuthority[].class)
            );

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                email,
                roles
            );

            SecurityContextHolder
                .getContext()
                .setAuthentication(auth);
            chain.doFilter(request, response);

            System.out.println("User si paso");
        } catch (Exception ex) {
            Map<String, Object> body = new HashMap<>();
            System.out.println(ex.getMessage());

            body.put("err", "Session expired");
            body.put("date", new Date());
            body.put("status", 401);

            response.getWriter().write(
                new ObjectMapper().writeValueAsString(body)
            );
            response.setStatus(401);
            response.setContentType("application/json");
        }
    }


}
