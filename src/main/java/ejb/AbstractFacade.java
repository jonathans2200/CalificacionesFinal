/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Persona;

/**
 *
 * @author jonat
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
   public AbstractFacade(Class<T> entityClass) {
	this.entityClass = entityClass;
    }
 protected abstract EntityManager getEntityManager();
 
  public void crear(T entity) {
	getEntityManager().persist(entity);
    }

    public void editar(T entity) {
	getEntityManager().merge(entity);
    }

    public void eliminar(T entity) {
	getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T buscarId(Object id) {
	return getEntityManager().find(entityClass, id);
    }

   
    
    
    
    public List<T> findAll() {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	cq.select(cq.from(entityClass));
	return getEntityManager().createQuery(cq).getResultList();
    }

/*

    public int count() {
	CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	Root<T> rt = cq.from(entityClass);
	cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	Query q = getEntityManager().createQuery(cq);
	return ((Long) q.getSingleResult()).intValue();
    }




*/

}
