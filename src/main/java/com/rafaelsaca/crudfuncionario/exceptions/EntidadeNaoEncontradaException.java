package com.rafaelsaca.crudfuncionario.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(Long id ) {
        super("Registro com id:" +id+ ", não encontrado!");
    }
}
