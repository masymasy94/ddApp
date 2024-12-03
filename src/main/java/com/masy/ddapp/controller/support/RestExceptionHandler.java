package com.masy.ddapp.controller.support;


import com.masy.ddapp.data.dto.ResponseDto;
import com.masy.ddapp.exception.PlayerAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseDto<Void> handle(Exception ex) {

        return ResponseDto.<Void>builder()
                .message("Unexpected error: " + ex.getMessage())
                .build();
    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<Void> handle(ConstraintViolationException e) {

        return ResponseDto.<Void>builder()
                .message("Validation failed: " + e.getMessage())
                .build();
    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<Void> handle(MissingServletRequestParameterException ex) {

        return ResponseDto.<Void>builder()
                .message(
                        format("required request parameter %s of type %s is not present",
                                ex.getParameterName(), ex.getParameterType()))
                .build();
    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<Void> handle(BindException ex) {

        return ResponseDto.<Void>builder()
                .message("Validation failed: " + ex.getMessage())
                .build();
    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<Void> handle(HttpMessageNotReadableException ex) {

        return ResponseDto.<Void>builder()
                .message("Could not parse body: " + ex.getMessage())
                .build();
    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<Void> handle(MethodArgumentTypeMismatchException ex) {

         return ResponseDto.<Void>builder()
                .message("Parameter cannot be parsed to the correct type: " + ex.getMessage())
                .build();

    }


    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    public ResponseDto<String> handle(PlayerAlreadyExistsException ex) {

        return ResponseDto.<String>builder()
                .message("Target player already exists")
                .body(ex.getPlayerName())
                .build();

    }



}