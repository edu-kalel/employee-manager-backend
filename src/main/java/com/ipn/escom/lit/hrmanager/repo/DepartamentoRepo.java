package com.ipn.escom.lit.hrmanager.repo;

import com.ipn.escom.lit.hrmanager.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepo extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findDepartamentoById(Long id);

    void deleteDepartamentoById(Long id);
}
