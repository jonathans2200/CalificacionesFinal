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
import model.Profesor;
import model.Sesion;

/**
 *
 * @author jonat
 */
@Stateless
public class SesionFacade extends AbstractFacade<Sesion> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public SesionFacade() {
        super(Sesion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Sesion> listarSesionProfesor(int dato) {

        String jpl = "select p from Sesion p Where p.materiaProfesor.profesor.idProfesor =:dato";

        Query q = em.createQuery(jpl, Sesion.class);
        q.setParameter("dato", dato);
        return (List<Sesion>) q.getResultList();

        //return null;
    }

}
