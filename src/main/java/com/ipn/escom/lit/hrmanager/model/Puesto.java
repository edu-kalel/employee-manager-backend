package com.ipn.escom.lit.hrmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RH_T_Puesto")
public class Puesto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "EstaActivo")
    @Value("${some.key:true}")
    private boolean state;

    @OneToMany(mappedBy = "puesto_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Employee> employee = new ArrayList<>();

    public Puesto() {
    }

    public Puesto(String name, boolean state) {
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

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
