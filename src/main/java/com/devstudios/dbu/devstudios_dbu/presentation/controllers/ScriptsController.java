package com.devstudios.dbu.devstudios_dbu.presentation.controllers;

import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.CreateScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.dtos.scripts.UpdateScriptDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.services.ScriptsService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/script")
public class ScriptsController {

    @Autowired
    ScriptsService service;


    @GetMapping("/find-all")
    public ResponseEntity<ResponseDto<List<IScript>>> findAll(){
        var res = service.findAll();
        return ResponseEntity.status(res.getStatus()).body(res);
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER') or hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto<IScript>> create( @Valid @ModelAttribute CreateScriptDto scriptDto ){
        var res = service.create(scriptDto);
        return ResponseEntity.status(res.getStatus()).body(res);
    }

    @PreAuthorize("hasRole('ROLE_DEVELOPER') or hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto<IScript>> update( @PathVariable Long id, @Valid @ModelAttribute UpdateScriptDto scriptDto ){
        var res = service.update(id, scriptDto);
        return ResponseEntity.status(res.getStatus()).body(res);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(){
        return ResponseEntity.ok(null);
    }

}
