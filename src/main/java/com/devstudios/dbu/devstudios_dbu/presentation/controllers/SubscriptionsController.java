package com.devstudios.dbu.devstudios_dbu.presentation.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/subscription")
public class SubscriptionsController {

    @PostMapping("/create")
    public ResponseEntity<?> createSubscription(@RequestBody Object subscription) {
        return ResponseEntity.ok(subscription);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete( @PathVariable Long id ){
        return ResponseEntity.ok(null);
    }


}
