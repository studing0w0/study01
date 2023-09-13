package com.study.study01.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity exceptionHandler(BaseException e){
        BaseExceptionType baseExceptionType = e.getExceptionType();
        log.error("BaseException errorMessage() : {}",baseExceptionType.getErrorMessage());
        log.error("BaseException errorCode() : {}", baseExceptionType.getErrorCode());
        return new ResponseEntity(new ExceptionDto(baseExceptionType.getErrorCode(),baseExceptionType.getHttpStatus(), baseExceptionType.getErrorMessage()),baseExceptionType.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerMember(Exception e){
        e.printStackTrace();
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validationException(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c->{
                    errors.put(((FieldError) c).getField(), c.getDefaultMessage());
                });
        return ResponseEntity.badRequest().body(errors);
    }

    @Data
    @AllArgsConstructor
    static class ExceptionDto{
        private Integer errorCode;
        private HttpStatus httpStatus;
        private String errorMsg;

    }
}
