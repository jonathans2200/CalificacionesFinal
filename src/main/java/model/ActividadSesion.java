/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author jonat
 */
@Entity
public class ActividadSesion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActSesion;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "idActividad", referencedColumnName = "idActividad")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "idSesion", referencedColumnName = "idSesion")
    private Sesion sesion;

    @ManyToOne
    private Estudiante estudiante;

    private double calificaion;

    @Transient
    private boolean editable;

    public int getIdActSesion() {
        return idActSesion;
    }

    public void setIdActSesion(int idActSesion) {
        this.idActSesion = idActSesion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public double getCalificaion() {
        return calificaion;
    }

    public void setCalificaion(double calificaion) {
        this.calificaion = calificaion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

}
