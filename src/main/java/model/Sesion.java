/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jonat
 */
@Entity
public class Sesion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSesion;
    @ManyToOne
    private MateriaProfesor materiaProfesor;
    private String estado;
    @OneToMany(mappedBy = "sesion")
    private List<ActividadSesion> actividadSesion;

    public Sesion() {
    }

    public Sesion(MateriaProfesor materiaProfesor, String estado) {

        this.materiaProfesor = materiaProfesor;
        this.estado = estado;

    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MateriaProfesor getMateriaProfesor() {
        return materiaProfesor;
    }

    public void setMateriaProfesor(MateriaProfesor materiaProfesor) {
        this.materiaProfesor = materiaProfesor;
    }

}
