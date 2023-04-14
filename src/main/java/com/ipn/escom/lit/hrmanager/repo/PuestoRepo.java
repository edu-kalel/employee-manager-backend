package com.ipn.escom.lit.hrmanager.repo;

import com.ipn.escom.lit.hrmanager.model.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PuestoRepo extends JpaRepository<Puesto, Long> {
    Optional<Puesto> findPuestoById(Long id);

    void deletePuestoById(Long id);
}
