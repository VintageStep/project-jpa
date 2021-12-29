/**
 * 
 */
package com.yourcom.projectjpa.dao;

import java.util.List;

import com.mycom.projectjpa.entity.Disquera;

/**
 * @author VintageStep
 * Interfaz que genera el DAO para las transacciones del CRUD a la tabla de disquera.
 */
public interface DisqueraDAO {
	
	void guardar(Disquera disquera);
	
	void actualizar(Disquera disquera);
	
	void eliminar(Long Id);
	
	List<Disquera> consultar();
	
	Disquera consultarById(Long Id);
	/*
	 * Metodo que permite consultar con JPQL la disquera a partir de una descripcion
	 * @param descripcion {@link String} descripcion de la disquera
	 * @return {@link Disquera} la disquera consultada.
	 */
	
	Disquera consultarByDescripcionJPQL(String descripcion);
	
	/*
	 * Metodo qye permite consultar con SQL nativo la disquera a partir de la descripcion
	 * @param descripcion {@link String} descripcion de la disquera
	 * @return {@link Disquera} la disquera consultada.
	 */
	
	Disquera consultarByDescripcionNative(String descripcion);
	

}
