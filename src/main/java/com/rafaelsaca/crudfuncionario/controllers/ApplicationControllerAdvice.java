package com.rafaelsaca.crudfuncionario.controllers;

import com.rafaelsaca.crudfuncionario.exceptions.EntidadeNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException (EntidadeNaoEncontradaException ex){
        return ex.getMessage();
    }
}
