package com.ipn.escom.lit.hrmanager.resource;

import com.ipn.escom.lit.hrmanager.model.Estado;
import com.ipn.escom.lit.hrmanager.model.Puesto;
import com.ipn.escom.lit.hrmanager.service.EstadoService;
import com.ipn.escom.lit.hrmanager.service.PuestoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoResource {
    private final EstadoService estadoService;

    public EstadoResource(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Estado>> getAllEstados(){
        List<Estado> estados = estadoService.findAllEstados();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable("id") Long id){
        Estado estado = estadoService.findEstadoById(id);
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Estado> addEstado(@RequestBody Estado estado){
        Estado newEstado = estadoService.addEstado(estado);
        return new ResponseEntity<>(newEstado, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Estado> updateEstado(@RequestBody Estado estado){
        Estado updateEstado = estadoService.updateEstado(estado);
        return new ResponseEntity<>(updateEstado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEstado(@PathVariable("id") Long id){
        estadoService.deleteEstado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
