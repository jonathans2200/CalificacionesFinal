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
import model.Persona;
import model.Profesor;

/**
 *
 * @author jonat
 */
@Stateless
public class ProfesorFacade extends AbstractFacade<Profesor> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public ProfesorFacade() {
        super(Profesor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Profesor> listarAsignaciones() {

        String jpl = "Select p from Profesor p Inner JOIN Materia m where p.idProfeosr= m.idmateria";
        Query q = em.createQuery(jpl, Profesor.class);

        return q.getResultList();

    }
}
