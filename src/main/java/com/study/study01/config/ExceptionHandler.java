package com.study.study01.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity exceptionHandler(Exception e){
        log.info(e.getMessage());
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
