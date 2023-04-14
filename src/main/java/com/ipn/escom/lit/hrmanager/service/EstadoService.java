package com.ipn.escom.lit.hrmanager.service;

import com.ipn.escom.lit.hrmanager.exception.UserNotFoundException;
import com.ipn.escom.lit.hrmanager.model.Estado;
import com.ipn.escom.lit.hrmanager.repo.EstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {
    private final EstadoRepo estadoRepo;

    @Autowired
    public EstadoService(EstadoRepo estadoRepo) {
        this.estadoRepo = estadoRepo;
    }
    public Estado addEstado(Estado estado){
        return estadoRepo.save(estado);
    }
    public List<Estado> findAllEstados(){
        return estadoRepo.findAll();
    }
    public Estado updateEstado(Estado estado){
        return estadoRepo.save(estado);
    }

    public Estado findEstadoById(Long id){
        return estadoRepo.findEstadoById(id).
                orElseThrow(() -> new UserNotFoundException("Estado by id"+id+"was not found"));
    }

    @Transactional
    public void deleteEstado(Long id){
        estadoRepo.deleteEstadoById(id);
    }

}
