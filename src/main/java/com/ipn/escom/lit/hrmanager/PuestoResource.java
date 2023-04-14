package com.ipn.escom.lit.hrmanager;

import com.ipn.escom.lit.hrmanager.model.Puesto;
import com.ipn.escom.lit.hrmanager.service.PuestoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puesto")
public class PuestoResource {
    private final PuestoService puestoService;

    public PuestoResource(PuestoService puestoService) {
        this.puestoService = puestoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Puesto>> getAllPuestos(){
        List<Puesto> puestos = puestoService.findAllPuestos();
        return new ResponseEntity<>(puestos, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Puesto> getPuestoById(@PathVariable("id") Long id){
        Puesto puesto = puestoService.findPuestoById(id);
        return new ResponseEntity<>(puesto, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Puesto> addPuesto(@RequestBody Puesto puesto){
        Puesto newPuesto = puestoService.addPuesto(puesto);
        return new ResponseEntity<>(newPuesto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Puesto> updatePuesto(@RequestBody Puesto puesto){
        Puesto updatePuesto = puestoService.updatePuesto(puesto);
        return new ResponseEntity<>(updatePuesto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePuesto(@PathVariable("id") Long id){
        puestoService.deletePuesto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
