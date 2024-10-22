package com.devstudios.dbu.devstudios_dbu.presentation.controllers;

import com.devstudios.dbu.devstudios_dbu.application.dtos.ResponseDto;
import com.devstudios.dbu.devstudios_dbu.application.interfaces.projections.IScript;
import com.devstudios.dbu.devstudios_dbu.application.services.ScriptsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<IScript> create(){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(){
        return ResponseEntity.ok(null);
    }

}
