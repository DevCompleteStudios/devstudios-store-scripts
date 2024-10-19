package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.ICodeAuthRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;




@Repository
public class CodeAuthRepositoryImpl implements ICodeAuthRepository {

    @Autowired
    CodeAuthRepositoryJpa repositoryJpa;


    @Override
    @Transactional
    public void deleteById(Long id) {
        repositoryJpa.deleteById(id);
    }


    @Override
    public Optional<CodeAuthEntity> findCodeByCode(String code) {
        return repositoryJpa.findByCode(code);
    }
}
