package com.rafaelsaca.crudfuncionario.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rafaelsaca.crudfuncionario.dto.FuncionarioDto;
import com.rafaelsaca.crudfuncionario.dto.mapper.FuncionarioMapper;
import com.rafaelsaca.crudfuncionario.exceptions.EntidadeNaoEncontradaException;
import com.rafaelsaca.crudfuncionario.model.Funcionario;
import com.rafaelsaca.crudfuncionario.repository.FuncionarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioService(FuncionarioRepository repository, FuncionarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public FuncionarioDto create(@Valid @NotNull FuncionarioDto funcionarioDto) {
        return mapper.toDto(repository.save(mapper.toEntity(funcionarioDto)));
    }

    public List<FuncionarioDto> list() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // public FuncionarioPageDto list(@PositiveOrZero int numeroDaPagina, @Positive
    // @Max(5) int qtdePorPagina) {
    // Page<Funcionario> page = repository.findAll(PageRequest.of(numeroDaPagina,
    // qtdePorPagina));
    // List<FuncionarioDto> funcionarios =
    // page.get().map(mapper::toDto).collect(Collectors.toList());

    // return new FuncionarioPageDto(funcionarios, page.getNumber(), page.getSize(),
    // page.getTotalElements(),
    // page.getTotalPages());
    // }

    public Funcionario findById(@PathVariable @NotNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(id));
    }

    @Transactional
    public FuncionarioDto update(@NotNull @Positive Long id, @Valid @NotNull FuncionarioDto funcionarioDto) {
        return repository.findById(id)
                .map(dadoEncontrado -> {
                    dadoEncontrado.setNome(funcionarioDto.nome());
                    dadoEncontrado.setSobrenome(funcionarioDto.sobrenome());
                    dadoEncontrado.setDepartamento(funcionarioDto.departamento());
                    dadoEncontrado.setTurno(funcionarioDto.turno());

                    dadoEncontrado.setDataAlteracao(LocalDateTime.now());
                    return mapper.toDto(repository.save(dadoEncontrado));

                }).orElseThrow(() -> new EntidadeNaoEncontradaException(id));
    }

    @Transactional
    public void delete(@PathVariable @NotNull @Positive Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(id)));
    }

    @Transactional
    public void inativar(Long id) {
        Funcionario funcionarioAtual = findById(id);
        funcionarioAtual.inativar();
    }

    @Transactional
    public void ativar(Long id) {
        Funcionario funcionarioAtual = findById(id);
        funcionarioAtual.ativar();
    }

}
