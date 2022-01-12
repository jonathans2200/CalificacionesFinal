/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author jonat
 */
@Entity
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;
    private String correo;
    @Transient
    private boolean editable;
    private String contrasena;
    @OneToOne
    private Persona persona;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "estudiante")
    private List<MateriaEstudiante> estudianteMateria;

    @ManyToOne
    private Representante representante;

    public Estudiante() {
    }

    public Estudiante(String correo, String contrasena, Persona persona) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.persona = persona;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
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

    public List<MateriaEstudiante> getEstudianteMateria() {
        return estudianteMateria;
    }

    public void setEstudianteMateria(List<MateriaEstudiante> estudianteMateria) {
        this.estudianteMateria = estudianteMateria;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

}
