package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;


import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ScriptsRepositoryJpa extends JpaRepository<ScriptEntity, Long> {}
