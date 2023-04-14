package com.ipn.escom.lit.hrmanager.service;

import com.ipn.escom.lit.hrmanager.exception.UserNotFoundException;
import com.ipn.escom.lit.hrmanager.model.Puesto;
import com.ipn.escom.lit.hrmanager.repo.PuestoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PuestoService {
    private final PuestoRepo puestoRepo;

    @Autowired
    public PuestoService(PuestoRepo puestoRepo) {
        this.puestoRepo = puestoRepo;
    }
    public Puesto addPuesto(Puesto puesto){
        return puestoRepo.save(puesto);
    }
    public List<Puesto> findAllPuestos(){
        return puestoRepo.findAll();
    }
    public Puesto updatePuesto(Puesto puesto){
        return puestoRepo.save(puesto);
    }

    public Puesto findPuestoById(Long id){
        return puestoRepo.findPuestoById(id).
                orElseThrow(() -> new UserNotFoundException("Puesto by id"+id+"was not found"));
    }

    @Transactional
    public void deletePuesto(Long id){
        puestoRepo.deletePuestoById(id);
    }

}
