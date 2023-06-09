package com.ipn.escom.lit.hrmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RH_T_Estado")
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Nombre", nullable = false, length = 50)
    private String name;
    @Column(name = "EstaActivo")
    @Value("${some.key:true}")
    private boolean state;

    @OneToMany(mappedBy = "estado_id", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Employee> employee = new ArrayList<>();

    public Estado() {
    }

    public Estado(String name, boolean state) {
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
        return "Estado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                '}';
    }
}
