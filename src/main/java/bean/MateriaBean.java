/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.MateriaFacade;
import ejb.MateriaProfesorFacade;
import ejb.ProfesorFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Materia;
import model.MateriaProfesor;
import model.Profesor;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class MateriaBean implements Serializable {

    @EJB
    private MateriaFacade ejbMateria;

    @EJB
    private ProfesorFacade ejbProfesor;

    @EJB
    private MateriaProfesorFacade ejbMatProfesor;

    private List<MateriaProfesor> listadoMateria;

    public MateriaBean() {
    }

    @PostConstruct
    public void init() {

        listadoMateria = ejbMatProfesor.findAll();
    }

    public MateriaFacade getEjbMateria() {
        return ejbMateria;
    }

    public void setEjbMateria(MateriaFacade ejbMateria) {
        this.ejbMateria = ejbMateria;
    }

    public ProfesorFacade getEjbProfesor() {
        return ejbProfesor;
    }

    public void setEjbProfesor(ProfesorFacade ejbProfesor) {
        this.ejbProfesor = ejbProfesor;
    }

    public MateriaProfesorFacade getEjbMatProfesor() {
        return ejbMatProfesor;
    }

    public void setEjbMatProfesor(MateriaProfesorFacade ejbMatProfesor) {
        this.ejbMatProfesor = ejbMatProfesor;
    }

    public List<MateriaProfesor> getListadoMateria() {
        return listadoMateria;
    }

    public void setListadoMateria(List<MateriaProfesor> listadoMateria) {
        this.listadoMateria = listadoMateria;
    }

   

}
