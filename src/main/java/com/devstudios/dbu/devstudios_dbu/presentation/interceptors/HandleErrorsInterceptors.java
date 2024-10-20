package com.devstudios.dbu.devstudios_dbu.presentation.interceptors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;





@ControllerAdvice
public class HandleErrorsInterceptors {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomError( CustomException ex ){
        return getResponse(ex.getStatus(), ex.getError());
    }



    private ResponseEntity<Map<String, Object>> getResponse( int status, Object response ){
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("message", "Bad request");
        res.put("err", response);

        return ResponseEntity.status(status).body(res);
    }

}
