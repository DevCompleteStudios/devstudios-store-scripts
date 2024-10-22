package com.devstudios.dbu.devstudios_dbu.application.services;

import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.CreateScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.UpdateScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IScriptsRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;
import com.devstudios.dbu.devstudios_dbu.domain.mappers.AutoMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ScriptsService {

    @Autowired
    IScriptsRepository scriptsRepository;
    @Autowired
    AutoMapper mapper;


    public ResponseDto<IScript> create( CreateScriptDto createScriptDto ){
        ScriptEntity newScript = new ScriptEntity();

        newScript.setDescription(createScriptDto.getDescription());
        newScript.setName(createScriptDto.getName());
        newScript.setPrice(createScriptDto.getPrice());
        newScript.setUrl(createScriptDto.getUrl());

        ScriptEntity script = scriptsRepository.save(newScript);

        return new ResponseDto<>(mapper.scriptEntityToScript(script), 201, ":)");
    }

    public ResponseDto<List<IScript>> findAll(){
        return new ResponseDto<>(scriptsRepository.findAll(), 200, "Already send all");
    }

    public ResponseDto<Boolean> delete(Long id){
        return new ResponseDto<>(true, 200, ":(");
    }

    public ResponseDto<IScript> update( Long id, UpdateScriptDto scriptDto ){
        ScriptEntity scriptDb = scriptsRepository.findById(id)
            .orElseThrow( () -> CustomException.NotFoundException("Script not found") );

        if( scriptDto.getDescription() != null ) scriptDb.setDescription(scriptDto.getDescription());
        if( scriptDto.getName() != null ) scriptDb.setName(scriptDto.getName());
        if( scriptDto.getPrice() != null ) scriptDb.setPrice(scriptDto.getPrice());
        if( scriptDto.getUrl() != null ) scriptDb.setUrl(scriptDto.getUrl());
        if( scriptDto.getIsActive() != null ) scriptDb.setIsActive(scriptDto.getIsActive());

        scriptsRepository.save(scriptDb);

        return new ResponseDto<>(mapper.scriptEntityToScript(scriptDb),  200, "Update succes");
    }

}
