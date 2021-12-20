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
import javax.persistence.OneToOne;

/**
 *
 * @author jonat
 */
@Entity
public class Representante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRepresentante;
    private String correo;
    private String contrasena;
    @OneToOne
    private Persona persona;
    @ManyToOne
    private Estudiante estudiante;

    public Representante() {
    }

    public Representante(String correo, String contrasena, Persona persona, Estudiante estudiante) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.persona = persona;
        this.estudiante = estudiante;
    }

    public int getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(int idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    

}
