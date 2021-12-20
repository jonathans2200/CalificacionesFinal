/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.EstudianteFacade;
import ejb.PersonaFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Estudiante;
import model.Persona;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable {

    @EJB
    private PersonaFacade ejbPersona;
    @EJB
    private EstudianteFacade ejbEstudiante;

    private List<Persona> listaPersona;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String direccion;
    private String rol;
    private String cedula;
    private String correo;

    public String crearPersona() {
        Persona p = new Persona();

        p.setCedula(cedula);
        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setCedula(cedula);
        p.setDireccion(direccion);
        p.setRol(rol);
        ejbPersona.crear(p);
        Estudiante est = new Estudiante();
        est.setContrasena(contrasena);
        est.setCorreo(correo);
        est.setPersona(p);
        ejbEstudiante.crear(est);
        return null;
    }

    public PersonaFacade getEjbPersona() {
        return ejbPersona;
    }

    public void setEjbPersona(PersonaFacade ejbPersona) {
        this.ejbPersona = ejbPersona;
    }

    public EstudianteFacade getEjbEstudiante() {
        return ejbEstudiante;
    }

    public void setEjbEstudiante(EstudianteFacade ejbEstudiante) {
        this.ejbEstudiante = ejbEstudiante;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
