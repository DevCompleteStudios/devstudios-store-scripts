package com.devstudios.dbu.devstudios_dbu.application.services;

import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.CreateScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.repositories.IScriptsRepository;
import com.devstudios.dbu.devstudios_dbu.domain.entities.ScriptEntity;
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

        if( createScriptDto.getDescription() != null ) newScript.setDescription(createScriptDto.getDescription());
        if( createScriptDto.getName() != null ) newScript.setName(createScriptDto.getName());
        if( createScriptDto.getPrice() != null ) newScript.setPrice(createScriptDto.getPrice());
        if( createScriptDto.getUrl() != null ) newScript.setUrl(createScriptDto.getUrl());

        ScriptEntity script = scriptsRepository.save(newScript);

        return new ResponseDto<>(mapper.scriptEntityToScript(script), 201, ":)");
    }

    public ResponseDto<List<IScript>> findAll(){
        return new ResponseDto<>(scriptsRepository.findAll(), 200, "Already send all");
    }

    public ResponseDto<Boolean> delete(Long id){
        return new ResponseDto<>(true, 200, ":(");
    }

    public ResponseDto<Object> update( Long id, Object dto ){
        return new ResponseDto<>();
    }

}
