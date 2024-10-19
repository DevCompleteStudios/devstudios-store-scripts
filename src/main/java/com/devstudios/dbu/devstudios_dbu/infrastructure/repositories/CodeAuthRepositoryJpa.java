package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;


public interface CodeAuthRepositoryJpa extends JpaRepository<CodeAuthEntity, Long> {
    Optional<CodeAuthEntity> findByCode(String code);
}
