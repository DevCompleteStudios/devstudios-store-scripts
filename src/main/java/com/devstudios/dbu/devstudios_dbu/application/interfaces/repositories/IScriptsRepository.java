package com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;

import java.util.List;


public interface IScriptsRepository {

    public ScriptEntity save(ScriptEntity script);
    public List<IScript> findAll();
    public void delete( Long id );

}
