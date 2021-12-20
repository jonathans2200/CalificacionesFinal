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

/**
 *
 * @author jonat
 */
@Entity
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;
    private String descripcion;

    @OneToMany(mappedBy = "materias")
    private List<MateriaEstudiante> estudianteMateria;
    
    
    
    @OneToMany(mappedBy = "materia") 
    private List<MateriaProfesor> profesorMateria;

    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<MateriaProfesor> getProfesorMateria() {
        return profesorMateria;
    }

    public void setProfesorMateria(List<MateriaProfesor> profesorMateria) {
        this.profesorMateria = profesorMateria;
    }

    public List<MateriaEstudiante> getEstudianteMateria() {
        return estudianteMateria;
    }

    public void setEstudianteMateria(List<MateriaEstudiante> estudianteMateria) {
        this.estudianteMateria = estudianteMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", descripcion=" + descripcion + ", profesorMateria=" + profesorMateria + '}';
    }

}
