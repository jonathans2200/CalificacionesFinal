/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Materia;

/**
 *
 * @author jonat
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public MateriaFacade() {
        super(Materia.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
