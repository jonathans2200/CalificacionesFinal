/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ActividadFacade;
import ejb.ActividadSesionFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Actividad;
import model.ActividadSesion;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ActividadSesionBean implements Serializable {

    @EJB
    private ActividadSesionFacade ejbActividadSesion;
    @EJB
    private ActividadFacade ejbActividad;

    private Actividad buscarActividad;

    private List<ActividadSesion> listaActividad;
    private String codigo;

    @PostConstruct
    public void init() {

    }

    public ActividadSesionBean() {
    }

    public ActividadSesionFacade getEjbActividadSesion() {
        return ejbActividadSesion;
    }

    public void setEjbActividadSesion(ActividadSesionFacade ejbActividadSesion) {
        this.ejbActividadSesion = ejbActividadSesion;
    }

    public List<ActividadSesion> getListaActividad() {
        return listaActividad;
    }

    public void setListaActividad(List<ActividadSesion> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        if (codigo != null) {
            listaActividad = ejbActividadSesion.listarSesionProfesor(Integer.parseInt(codigo));
            buscarActividad = ejbActividad.buscarId(Integer.parseInt(codigo));
        }
    }

    public ActividadFacade getEjbActividad() {
        return ejbActividad;
    }

    public void setEjbActividad(ActividadFacade ejbActividad) {
        this.ejbActividad = ejbActividad;
    }

    public Actividad getBuscarActividad() {
        return buscarActividad;
    }

    public void setBuscarActividad(Actividad buscarActividad) {
        this.buscarActividad = buscarActividad;

    }

    public String edit(ActividadSesion c) {
        c.setEditable(true);
        return null;
    }

    public String save(ActividadSesion c) {
        ejbActividadSesion.editar(c);
        c.setEditable(false);
        listaActividad = ejbActividadSesion.listarSesionProfesor(Integer.parseInt(codigo));
        return null;
    }

}
