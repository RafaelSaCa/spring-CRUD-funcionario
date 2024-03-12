package com.rafaelsaca.crudfuncionario.dto;

import com.rafaelsaca.crudfuncionario.enums.DepartamentoEnum;
import com.rafaelsaca.crudfuncionario.enums.TurnoEnum;

import java.time.LocalDateTime;

public record FuncionarioDto(

                Long id,
                String nome,
                String sobrenome,
                DepartamentoEnum departamento,
                TurnoEnum turno,
                Boolean ativo,
                LocalDateTime dataCriacao,
                LocalDateTime dataAlteracao

) {
}
