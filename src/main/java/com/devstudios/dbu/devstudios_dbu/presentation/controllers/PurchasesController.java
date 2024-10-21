package com.devstudios.dbu.devstudios_dbu.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/purchases")
public class PurchasesController {

    @GetMapping("/script/{id}")
    public ResponseEntity<?> buyScript( @PathVariable Long id ){
        return ResponseEntity.ok(null);
    }

    @GetMapping("/subscription/{id}")
    public ResponseEntity<?> buySuscription( @PathVariable Long id ){
        return ResponseEntity.ok(null);
    }

}
