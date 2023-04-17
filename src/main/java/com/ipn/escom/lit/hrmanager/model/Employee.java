package com.ipn.escom.lit.hrmanager.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "RH_T_RecursoHumano")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "Nombre", nullable = false, length = 50)
    private String name;
    @Column(name="PrimerApellido", length = 50)
    private String firstSurname;
    @Column(name="SegundoApellido", length = 50)
    private String secondSurname;
    @Column(name = "CURP", length = 50)
    private String curp;

    @ManyToOne
    @JoinColumn(name = "Puesto_id", referencedColumnName = "id")
    private Puesto puesto_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Estado_id", referencedColumnName = "id")
    private Estado estado_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Departamento_id", referencedColumnName = "id")
    private Departamento departamento_id;

    public Employee() {
    }

    public Employee(String name, String firstSurname, String secondSurname, String curp, Puesto puesto_id, Estado estado_id, Departamento departamento_id) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.curp = curp;
        this.puesto_id = puesto_id;
        this.estado_id = estado_id;
        this.departamento_id = departamento_id;
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

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Puesto getPuesto_id() {
        return puesto_id;
    }

    public void setPuesto_id(Puesto puesto_id) {
        this.puesto_id = puesto_id;
    }

    public Estado getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Estado estado_id) {
        this.estado_id = estado_id;
    }

    public Departamento getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(Departamento departamento_id) {
        this.departamento_id = departamento_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", curp='" + curp + '\'' +
                ", puesto_id=" + puesto_id +
                ", estado_id=" + estado_id +
                ", departamento_id=" + departamento_id +
                '}';
    }
}
