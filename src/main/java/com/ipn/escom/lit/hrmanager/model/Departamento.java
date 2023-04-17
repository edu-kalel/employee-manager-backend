package com.ipn.escom.lit.hrmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "RH_T_Departamento")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre", nullable = false, length = 50)
    private String name;
    @Column(name = "EstaActivo")
    private boolean state;

    @OneToMany(mappedBy = "departamento_id", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Employee> employee = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isState() {
        return state;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
