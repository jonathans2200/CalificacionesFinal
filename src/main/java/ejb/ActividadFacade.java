/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Actividad;
import model.Estudiante;

/**
 *
 * @author jonat
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public ActividadFacade() {
        super(Actividad.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


public List<Actividad> listarSesionProfesor(int dato) {

        String jpl = "select p from Actividad p Where p.sesion.idSesion =:dato";

        Query q = em.createQuery(jpl, Actividad.class);
        q.setParameter("dato", dato);
        return (List<Actividad>) q.getResultList();

        //return null;
    }
}
