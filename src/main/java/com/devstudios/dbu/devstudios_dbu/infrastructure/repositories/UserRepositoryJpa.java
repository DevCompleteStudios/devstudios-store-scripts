package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;




public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findByAuthCode_Code(String code);
}
