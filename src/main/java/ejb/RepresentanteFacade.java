/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Profesor;
import model.Representante;

/**
 *
 * @author jonat
 */
@Stateless
public class RepresentanteFacade extends AbstractFacade<Representante> {

    @PersistenceContext(unitName = "calificacion")
    private EntityManager em;

    public RepresentanteFacade() {
        super(Representante.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



     public Representante obtenerUsuario(String correo, String contrasena) throws Exception {
        try {
            String jpl = "select p from Representante p Where p.correo =:usu AND p.contrasena =:contr";
            Query q = em.createQuery(jpl, Representante.class);
            q.setParameter("usu", correo);
            q.setParameter("contr", contrasena);
            return (Representante) q.getSingleResult();

        } catch (NoResultException e) {
          
            System.out.println("Credenciaales Inocorrectas");
        }
        return null;
    }

}
