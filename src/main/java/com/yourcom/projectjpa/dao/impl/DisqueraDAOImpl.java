/**
 * 
 */
package com.yourcom.projectjpa.dao.impl;

import java.util.List;

import javax.persistence.*;

import com.mycom.projectjpa.entity.Disquera;
import com.yourcom.projectjpa.dao.DisqueraDAO;

/**
 * @author Tom Clase que implementa las transacciones para la tabla de disquera
 */
public class DisqueraDAOImpl implements DisqueraDAO {

	/**
	 * Usamos esto para indicarle el nombre de la unidad de persistencia que se
	 * encuentra en el archivo persistence.xml y cargar la información que se
	 * encuentra en la carpeta META-INF en la cual se encuentran mapeadas las clases
	 * y se encuentra la configuración del string de conexión y otras propiedades de
	 * configuración, es private static final porque a esta constante sólo accede la
	 * interfaz
	 */
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("PersistenceUnitName");

	@Override
	public void guardar(Disquera disquera) {
		/*
		 * El objeto entity manager contiene las funciones necesarias para
		 * contener(persistir) la ifnromación en la base de datos, este objeto es
		 * fundamental para iniciar una transacción
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		/*
		 * La clase EntityTransaction se emplea siempre que se quiera actualizar la
		 * información de la BBDD
		 */
		EntityTransaction et = em.getTransaction();
		et.begin();

		/*
		 * El método se encarga de guardar la información de un registro en la BBDD,
		 * obviamente hay que rodearlo en un bloque trycatch para recoger las
		 * excepciones que se pudieran producir si el acceso a BBDD falla
		 */
		try {
			em.persist(disquera);
			et.commit(); // Esta función asegura que el insert se confirme en la tabla
		} catch (Exception e) {
			// Si hay fallo en la transacción hacemos un rollback para evitar escribir datos
			// inconsistentes
			if (et != null) {
				et.rollback();
				e.printStackTrace(); // Nos muestra la información del error en la consola
			}
		} finally {
			// Falle o no se cierra la conexión a la BBDD
			em.close();
		}

	}

	@Override
	public void actualizar(Disquera disquera) {
		/*
		 * El objeto entity manager contiene las funciones necesarias para
		 * contener(persistir) la ifnromación en la base de datos, este objeto es
		 * fundamental para iniciar una transacción
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

		/*
		 * La clase EntityTransaction se emplea siempre que se quiera actualizar la
		 * información de la BBDD
		 */
		EntityTransaction et = em.getTransaction();
		et.begin();

		/*
		 * El método se encarga de hacer un update a la información de un registro en la BBDD,
		 * obviamente hay que rodearlo en un bloque trycatch para recoger las
		 * excepciones que se pudieran producir si el acceso a BBDD falla
		 */
		try {
			em.merge(disquera);
			et.commit(); // Esta función asegura que el insert se confirme en la tabla
		} catch (Exception e) {
			// Si hay fallo en la transacción hacemos un rollback para evitar escribir datos
			// inconsistentes
			if (et != null) {
				et.rollback();
				e.printStackTrace(); // Nos muestra la información del error en la consola
			}
		} finally {
			// Falle o no se cierra la conexión a la BBDD
			em.close();
		}

	}

	@Override
	public void eliminar(Long Id) {
		/*
		 * El objeto entity manager contiene las funciones necesarias para
		 * contener(persistir) la ifnromación en la base de datos, este objeto es
		 * fundamental para iniciar una transacción
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		// Hacemos una consulta para verificar que el Id existe
		
		Disquera disqueraConsultada = em.find(Disquera.class, Id);

		/*
		 * La clase EntityTransaction se emplea siempre que se quiera actualizar la
		 * información de la BBDD
		 */
		EntityTransaction et = em.getTransaction();
		et.begin();

		/*
		 * El método se encarga de borrar un registro en la BBDD,
		 * obviamente hay que rodearlo en un bloque trycatch para recoger las
		 * excepciones que se pudieran producir si el acceso a BBDD falla
		 */
		try {
			em.remove(disqueraConsultada);
			et.commit(); // Esta función asegura que el insert se confirme en la tabla
		} catch (Exception e) {
			// Si hay fallo en la transacción hacemos un rollback para evitar escribir datos
			// inconsistentes
			if (et != null) {
				et.rollback();
				e.printStackTrace(); // Nos muestra la información del error en la consola
			}
		} finally {
			// Falle o no se cierra la conexión a la BBDD
			em.close();
		}		

	}

	@Override
	public List<Disquera> consultar() {
		/*
		 * Para las consultas no hace falta utilizar las transacciones logicamente, pero
		 * sí el entity manager
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera ORDER BY descripcion");
		
		return queryDisquera.getResultList();
	}

	@Override
	public Disquera consultarById(Long Id) {
		/*
		 * Para las consultas no hace falta utilizar las transacciones logicamente, pero
		 * sí el entity manager
		 */
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		Disquera disqueraConsultada = em.find(Disquera.class, Id);
		
		if (disqueraConsultada == null) {
			throw new EntityNotFoundException("La disquera con id " + Id + " no se encuentra.");
		}
		
		return disqueraConsultada;

	}

	@Override
	public Disquera consultarByDescripcionJPQL(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createQuery("FROM Disquera WHERE descripcion = :desc");
		queryDisquera.setParameter("desc", descripcion);
		
		return queryDisquera.getSingleResult();
	}

	@Override
	public Disquera consultarByDescripcionNative(String descripcion) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		
		TypedQuery<Disquera> queryDisquera = (TypedQuery<Disquera>) em.createNativeQuery("Select idDisquera, descripcion, fechaCreacion, fechaModificacion, estatus FROM disquera WHERE descripcion = :desc", Disquera.class);
		queryDisquera.setParameter("desc", descripcion);
		
		return queryDisquera.getSingleResult();
	}

}
