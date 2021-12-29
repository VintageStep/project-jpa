/**
 * 
 */
package com.yourcom.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mycom.projectjpa.entity.SubGenero;
import com.yourcom.projectjpa.dao.SubGeneroDAO;

/**
 * @author VintageStep Clase que implementa el CRUD para las transacciones para
 *         la tabla de subgenero.
 *
 */
public class SubGeneroDAOImpl implements SubGeneroDAO {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("PersistenceUnitName");

	@Override
	public void guardar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(subGenero);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public void actualizar(SubGenero subGenero) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(subGenero);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}		

	}

	@Override
	public void eliminar(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		SubGenero subGeneroConsultado = em.find(SubGenero.class, id);
		
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(subGeneroConsultado);
			et.commit();
		} catch (Exception e) {
			if(et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}			

	}

	@Override
	public List<SubGenero> consultar() {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<SubGenero> typedQuery = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
		
		return typedQuery.getResultList();
	}

	@Override
	public SubGenero consultarById(Long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		return em.find(SubGenero.class, id);
	}

}
