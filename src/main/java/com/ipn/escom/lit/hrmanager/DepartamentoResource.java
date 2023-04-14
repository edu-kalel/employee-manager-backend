package com.ipn.escom.lit.hrmanager;

import com.ipn.escom.lit.hrmanager.model.Departamento;
import com.ipn.escom.lit.hrmanager.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoResource {
    private final DepartamentoService departamentoService;

    public DepartamentoResource(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departamento>> getAllDepartamentos(){
        List<Departamento> departamentos = departamentoService.findAllDepartamentos();
        return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Departamento> getDepartamentoById(@PathVariable("id") Long id){
        Departamento departamento = departamentoService.findDepartamentoById(id);
        return new ResponseEntity<>(departamento, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Departamento> addDepartamento(@RequestBody Departamento departamento){
        Departamento newDepartamento = departamentoService.addDepartamento(departamento);
        return new ResponseEntity<>(newDepartamento, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Departamento> updateDepartamento(@RequestBody Departamento departamento){
        Departamento updateDepartamento = departamentoService.updateDepartamento(departamento);
        return new ResponseEntity<>(updateDepartamento, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable("id") Long id){
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
