package com.rafaelsaca.crudfuncionario.repository;

import com.rafaelsaca.crudfuncionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
