package com.ipn.escom.lit.hrmanager.repo;

import com.ipn.escom.lit.hrmanager.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepo extends JpaRepository<Estado, Long> {
    Optional<Estado> findEstadoById(Long id);

    void deleteEstadoById(Long id);
}
