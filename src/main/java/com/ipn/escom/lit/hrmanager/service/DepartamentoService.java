package com.ipn.escom.lit.hrmanager.service;

import com.ipn.escom.lit.hrmanager.exception.UserNotFoundException;
import com.ipn.escom.lit.hrmanager.model.Departamento;
import com.ipn.escom.lit.hrmanager.repo.DepartamentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoService {
    private final DepartamentoRepo departamentoRepo;

    @Autowired
    public DepartamentoService(DepartamentoRepo departamentoRepo) {
        this.departamentoRepo = departamentoRepo;
    }
    public Departamento addDepartamento(Departamento departamento){
        return departamentoRepo.save(departamento);
    }
    public List<Departamento> findAllDepartamentos(){
        return departamentoRepo.findAll();
    }
    public Departamento updateDepartamento(Departamento departamento){
        return departamentoRepo.save(departamento);
    }

    public Departamento findDepartamentoById(Long id){
        return departamentoRepo.findDepartamentoById(id).
                orElseThrow(() -> new UserNotFoundException("Departamento by id"+id+"was not found"));
    }

    @Transactional
    public void deleteDepartamento(Long id){
        departamentoRepo.deleteDepartamentoById(id);
    }

}
