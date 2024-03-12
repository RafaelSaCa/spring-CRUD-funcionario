package com.rafaelsaca.crudfuncionario.dto.mapper;

import org.springframework.stereotype.Component;

import com.rafaelsaca.crudfuncionario.dto.FuncionarioDto;
import com.rafaelsaca.crudfuncionario.model.Funcionario;

@Component
public class FuncionarioMapper {

    public FuncionarioDto toDto(Funcionario funcionario) {
        return new FuncionarioDto(
                funcionario.getId(), funcionario.getNome(), funcionario.getSobrenome(),
                funcionario.getDepartamento(), funcionario.getTurno(), funcionario.getAtivo(),
                funcionario.getDataCriacao(), funcionario.getDataAlteracao());
    }

    public Funcionario toEntity(FuncionarioDto funcionarioDto) {

        if (funcionarioDto == null) {
            return null;
        }

        Funcionario funcionario = new Funcionario();
        if (funcionarioDto.id() != null) {
            funcionario.setId(funcionarioDto.id());
        }

        funcionario.setNome(funcionarioDto.nome());
        funcionario.setSobrenome(funcionarioDto.sobrenome());
        funcionario.setDepartamento(funcionarioDto.departamento());
        funcionario.setTurno(funcionarioDto.turno());
        funcionario.setAtivo(true);

        return funcionario;

    }
}
