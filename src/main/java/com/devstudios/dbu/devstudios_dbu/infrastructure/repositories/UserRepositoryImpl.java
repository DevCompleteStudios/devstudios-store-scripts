package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IUserRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;




@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    private UserRepositoryJpa repository;


    @Override
    public Optional<UserEntity> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String name) {
        return repository.findUserByEmail(name);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

}
