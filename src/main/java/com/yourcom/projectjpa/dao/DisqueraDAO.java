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
	

}
