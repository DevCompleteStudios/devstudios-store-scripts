package com.devstudios.dbu.devstudios_dbu.presentation.interceptors;

import com.devstudios.dbu.devstudios_dbu.domain.exceptions.CustomException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





@ControllerAdvice
public class HandleErrorsInterceptors {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomError( CustomException ex ){
        return getResponse(ex.getStatus(), ex.getError());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleArgumentsExceptions( MethodArgumentNotValidException ex ){
        List<Map<String, Object>> errs = ex.getFieldErrors()
            .stream().map( e -> {
                Map<String, Object> err = new HashMap<>();
                err.put(e.getField(), e.getDefaultMessage());
                return err;
            }).toList();

        return getResponse(400, errs);
    }

    private ResponseEntity<Map<String, Object>> getResponse( int status, Object response ){
        Map<String, Object> res = new HashMap<>();
        res.put("status", status);
        res.put("message", "Bad request");
        res.put("err", response);

        return ResponseEntity.status(status).body(res);
    }

}
