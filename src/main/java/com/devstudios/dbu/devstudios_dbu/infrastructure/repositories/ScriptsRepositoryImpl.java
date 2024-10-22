package com.devstudios.dbu.devstudios_dbu.infrastructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IScriptsRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
import com.devstudios.dbu.devstudios_dbu.domain.mappers.AutoMapper;


@Repository
public class ScriptsRepositoryImpl implements IScriptsRepository {

    @Autowired
    ScriptsRepositoryJpa repositoryJpa;
    @Autowired
    AutoMapper mapper;


    @Override
    public ScriptEntity save(ScriptEntity script) {
        return repositoryJpa.save(script);
    }

    @Override
    public List<IScript> findAll() {
        List<ScriptEntity> scriptsDb = repositoryJpa.findAll();
        List<IScript> scripts = scriptsDb.stream().map( s -> mapper.scriptEntityToScript(s) ).toList();

        return scripts;
    }

    @Override
    public void delete(Long id) {
        repositoryJpa.deleteById(id);
    }

}
