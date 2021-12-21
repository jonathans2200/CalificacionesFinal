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
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private MateriaEstudiante estudiante;

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

    public MateriaEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(MateriaEstudiante estudiante) {
        this.estudiante = estudiante;
    }


}
