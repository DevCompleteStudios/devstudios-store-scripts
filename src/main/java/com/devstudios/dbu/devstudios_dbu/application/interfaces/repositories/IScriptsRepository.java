package com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories;

import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
import java.util.List;
import java.util.Optional;


public interface IScriptsRepository {

    public ScriptEntity save(ScriptEntity script);
    public List<IScript> findAll();
    public void delete( Long id );
    public Optional<ScriptEntity> findById(Long id);

}
