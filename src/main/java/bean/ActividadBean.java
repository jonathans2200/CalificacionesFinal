/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ActividadFacade;
import ejb.SesionFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Actividad;
import model.Sesion;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ActividadBean implements Serializable {

    private String titulo;
    private String codigo;
    private String descripcion;
    private double calificacion;
    private String observacion;
    private List<Actividad> listarActividad;
    private int idSesion;
    @EJB
    private ActividadFacade ejbActividad;
    @EJB
    private SesionFacade ejbSesion;

    @PostConstruct
    public void init() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        if (codigo != null) {
            listarActividad = ejbActividad.listarSesionProfesor(Integer.parseInt(codigo));
        }
    }

    public List<Actividad> getListarActividad() {
        return listarActividad;
    }

    public void setListarActividad(List<Actividad> listarActividad) {
        this.listarActividad = listarActividad;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;

    }

    public ActividadFacade getEjbActividad() {
        return ejbActividad;
    }

    public void setEjbActividad(ActividadFacade ejbActividad) {
        this.ejbActividad = ejbActividad;
    }

    public String crearActividad() {
        Actividad a = new Actividad();
        a.setTitulo(titulo);
        a.setDescripcion(descripcion);
        a.setObservacion(observacion);
        Sesion s = ejbSesion.buscarId(Integer.parseInt(codigo));
        a.setSesion(s);
        ejbActividad.crear(a);
        listarActividad=ejbActividad.listarSesionProfesor(Integer.parseInt(codigo));

        return null;
    }
}
