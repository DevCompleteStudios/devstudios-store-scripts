package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IUserRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;



@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private UserRepositoryJpa repository;


    @Override
    @Transactional(readOnly=true)
    public Optional<UserEntity> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<UserEntity> findUserByEmail(String name) {
        return repository.findUserByEmail(name);
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<UserEntity> findUserByCode(String code) {
        return repository.findByAuthCode_Code(code);
    }

}
