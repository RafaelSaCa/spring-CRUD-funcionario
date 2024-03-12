package com.rafaelsaca.crudfuncionario.controllers;

import com.rafaelsaca.crudfuncionario.dto.FuncionarioDto;
import com.rafaelsaca.crudfuncionario.dto.FuncionarioPageDto;
import com.rafaelsaca.crudfuncionario.dto.mapper.FuncionarioMapper;
import com.rafaelsaca.crudfuncionario.model.Funcionario;
import com.rafaelsaca.crudfuncionario.service.FuncionarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;
    private final FuncionarioMapper mapper;

    public FuncionarioController(FuncionarioService service, FuncionarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // @GetMapping
    // public FuncionarioPageDto list(@RequestParam(defaultValue = "0")
    // @PositiveOrZero int numeroDaPagina,
    // @RequestParam(defaultValue = "6") @Positive @Max(10) int qtdePorPagina) {
    // return service.list(numeroDaPagina, qtdePorPagina);
    // }

    @GetMapping
    public List<FuncionarioDto> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public FuncionarioDto findById(@PathVariable @NotNull @Positive Long id) {
        Funcionario funcionario = service.findById(id);
        return mapper.toDto(funcionario);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FuncionarioDto create(@RequestBody @Valid @NotNull FuncionarioDto funcionarioDto) {
        return service.create(funcionarioDto);
    }

    @PutMapping("/{id}")
    public FuncionarioDto update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull FuncionarioDto funcionarioDto) {
        return service.update(id, funcionarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}/inativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> inativar(@PathVariable @NotNull @Positive Long id) {
        service.inativar(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> ativar(@PathVariable @NotNull @Positive Long id) {
        service.ativar(id);

        return ResponseEntity.noContent().build();
    }
}
