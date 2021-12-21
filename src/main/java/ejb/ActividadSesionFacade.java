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
import model.ActividadSesion;

/**
 *
 * @author jonat
 */
@Stateless
public class ActividadSesionFacade extends AbstractFacade<ActividadSesion> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public ActividadSesionFacade() {
        super(ActividadSesion.class);
    }

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ActividadSesion> listarSesionProfesor(int dato) {

        String jpl = "select p from ActividadSesion p Where p.actividad.idActividad  =:dato";

        Query q = em.createQuery(jpl, ActividadSesion.class);
        q.setParameter("dato", dato);
        return (List<ActividadSesion>) q.getResultList();

        //return null;
    }
}
