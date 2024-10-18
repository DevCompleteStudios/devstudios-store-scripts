package com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories;

import java.util.Optional;

import com.devstudios.dbu.devstudios_dbu.domain.entities.UserEntity;




public interface IUserRepository {
    Optional<UserEntity> findUserById( Long id );
    Optional<UserEntity> findUserByEmail( String name );
    UserEntity save(UserEntity user);
}
