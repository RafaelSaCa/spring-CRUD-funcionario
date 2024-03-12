package com.rafaelsaca.crudfuncionario.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.rafaelsaca.crudfuncionario.enums.DepartamentoEnum;
import com.rafaelsaca.crudfuncionario.enums.TurnoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(min = 3, max = 50)
    @Column(nullable = false)
    private String nome;
    @Length(min = 3, max = 50)
    @Column(nullable = false)
    private String sobrenome;
    private DepartamentoEnum departamento;
    private TurnoEnum turno;
    private Boolean Ativo = true;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime dataAlteracao;

    public void inativar() {
        setAtivo(false);
    }

    public void ativar() {
        setAtivo(true);
    }
}
