package com.rafaelsaca.crudfuncionario.dto;

import java.util.List;

public record FuncionarioPageDto(
        List<FuncionarioDto> funcionarios,
        int page,
        int size,
        long totalElements,
        int totalPages

) {

}
