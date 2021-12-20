/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.SesionFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Sesion;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SesionBean implements Serializable {

    public SesionBean() {
    }

    @EJB
    private SesionFacade ejbSesion;
    private String codigo;
    private List<Sesion> listaSesiones;

    @PostConstruct
    public void init() {

    }

    public SesionFacade getEjbSesion() {
        return ejbSesion;
    }

    public void setEjbSesion(SesionFacade ejbSesion) {
        this.ejbSesion = ejbSesion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        if (codigo != null) {
            listaSesiones = ejbSesion.listarSesionProfesor(Integer.parseInt(codigo));
        }
    }

    public List<Sesion> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(List<Sesion> listaSesiones) {
        this.listaSesiones = listaSesiones;

    }

}
