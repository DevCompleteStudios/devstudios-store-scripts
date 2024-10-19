package com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories;

import java.util.Optional;

import com.devstudios.dbu.devstudios_dbu.domain.entities.CodeAuthEntity;




public interface ICodeAuthRepository {
    void deleteById( Long id );
    Optional<CodeAuthEntity> findCodeByCode(String code);
}
