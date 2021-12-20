/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jonat
 */
@Entity
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesor;
    private String correo;
    private String contrasena;
    private String titulo;
    @OneToOne
    private Persona persona;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "profesor")
    private List<MateriaProfesor> profesorMateria;

    public Profesor() {
    }

    public Profesor(String correo, String contrasena, String titulo, Persona persona) {

        this.correo = correo;
        this.contrasena = contrasena;
        this.titulo = titulo;
        this.persona = persona;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<MateriaProfesor> getProfesorMateria() {
        return profesorMateria;
    }

    public void setProfesorMateria(List<MateriaProfesor> profesorMateria) {
        this.profesorMateria = profesorMateria;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", correo=" + correo + ", contrasena=" + contrasena + ", titulo=" + titulo + ", persona=" + persona + ", profesorMateria=" + profesorMateria + '}';
    }

   

}
