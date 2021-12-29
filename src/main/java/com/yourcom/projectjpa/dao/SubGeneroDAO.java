/**
 * 
 */
package com.yourcom.projectjpa.dao;

import java.util.List;


import com.mycom.projectjpa.entity.SubGenero;

/**
 * @author VintageStep
 * Interfaz DAO que realiza el CRUD con JPA para la tabla de subgenero.
 *
 */
public interface SubGeneroDAO {
	
	/*
	 * Metodo que permite guardar un dubgenero
	 * @param subGenero {@link SubGenero} objeto a guardar.
	 */
	void guardar(SubGenero subGenero);
	
	/*
	 * Metodo que permite actualizar un dubgenero
	 * @param subGenero {@link SubGenero} objeto a actualizar.
	 */
	void actualizar(SubGenero subGenero);
	
	/*
	 * Metodo que permite eliminar un subgenero por su identificador
	 * @param subGenero {@link Long} identificador del subgenero a eliminar.
	 */
	void eliminar(Long Id);
	
	/*
	 * Metodo que permite consultar la lista de subgeneros.
	 * @return {@link Lista} lista de subgeneros consultados.
	 */
	List<SubGenero> consultar();
	
	/*
	 * Metodo que permite consultar un subgenero a partir de su identificador.
	 * @param id {@link Long} identificador del subgenero a consultar.
	 * @return {@link Subgenero} un objeto subgenero consultado.
	 */
	SubGenero consultarById(Long Id);
;
}
