package com.ipn.escom.lit.hrmanager.service;

import com.ipn.escom.lit.hrmanager.exception.UserNotFoundException;
import com.ipn.escom.lit.hrmanager.model.Departamento;
import com.ipn.escom.lit.hrmanager.model.Employee;
import com.ipn.escom.lit.hrmanager.model.Estado;
import com.ipn.escom.lit.hrmanager.model.Puesto;
import com.ipn.escom.lit.hrmanager.repo.DepartamentoRepo;
import com.ipn.escom.lit.hrmanager.repo.EmployeeRepo;
import com.ipn.escom.lit.hrmanager.repo.EstadoRepo;
import com.ipn.escom.lit.hrmanager.repo.PuestoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final DepartamentoRepo departamentoRepo;
    private final PuestoRepo puestoRepo;
    private final EstadoRepo estadoRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, DepartamentoRepo departamentoRepo, PuestoRepo puestoRepo, EstadoRepo estadoRepo) {
        this.employeeRepo = employeeRepo;
        this.departamentoRepo = departamentoRepo;
        this.puestoRepo = puestoRepo;
        this.estadoRepo = estadoRepo;
    }

    public Employee addEmployee(Employee employee){
        // Obtener una instancia administrada de Departamento, puesto y estado
        Departamento departamento = departamentoRepo.findDepartamentoById(employee.getDepartamento_id().getId())
                .orElseThrow(() -> new UserNotFoundException("No se encontró el departamento con el ID proporcionado"));
        Puesto puesto = puestoRepo.findPuestoById(employee.getPuesto_id().getId())
                .orElseThrow(() -> new UserNotFoundException("No se encontró el puesto con el ID proporcionado"));
        Estado estado = estadoRepo.findEstadoById(employee.getEstado_id().getId())
                .orElseThrow(() -> new UserNotFoundException("No se encontró el estado con el ID proporcionado"));
        // Asignar el departamento administrado a la entidad Employee

        employee.setDepartamento_id(departamento);
        employee.setPuesto_id(puesto);
        employee.setEstado_id(estado);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id"+ id +"was not found"));
    }

    @Transactional
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
