/**
 * 
 */
package com.yourcom.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mycom.projectjpa.entity.Genero;
import com.mycom.projectjpa.entity.SubGenero;
import com.yourcom.projectjpa.dao.SubGeneroDAO;
import com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl;

/**
 * @author VintageStep
 * clase test para comprobar el funcionamiento del CRUD de subgenero
 *
 */
class SubGeneroDAOImplTest {
	
	private SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl#guardar(com.mycom.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testGuardar() {
		
		/*
		 * Se instancia un subgenero y su genero correspondiente ya que el alta de los datos de la BBDD
		 * se produce en dos tablas diferentes que están relacionadas
		 */
		SubGenero subGenero = new SubGenero();
		subGenero.setDescripcion("Nu-disco");
		subGenero.setFechaCreacion(LocalDateTime.now());
		subGenero.setEstatus(true);
		
		Genero genero = new Genero();
		genero.setDescripcion("EDM");
		genero.setFechaCreacion(LocalDateTime.now());
		genero.setEstatus(true);
		

		subGenero.setGenero(genero);
		
		// Se llama al metodo que hace la transacción.
		
		this.subGeneroDAO.guardar(subGenero);
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl#actualizar(com.mycom.projectjpa.entity.SubGenero)}.
	 */
	@Test
	void testActualizar() {
		/*
		 * Se instancia un subgenero y su genero correspondiente ya que el alta de los datos de la BBDD
		 * se produce en dos tablas diferentes que están relacionadas
		 */
		SubGenero subGeneroConsultado = this.subGeneroDAO.consultarById(8L);
		
		subGeneroConsultado.setDescripcion("Liquid Funk");
		subGeneroConsultado.setFechaModificacion(LocalDateTime.now());
		subGeneroConsultado.setEstatus(true);
		
		// Se llama al metodo que hace la transacción.
		
		this.subGeneroDAO.actualizar(subGeneroConsultado);
	
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl#eliminar(java.lang.Long)}.
	 */
	@Test
	void testEliminar() {
		this.subGeneroDAO.eliminar(8L);
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<SubGenero> subGenerosConsultados = this.subGeneroDAO.consultar();
		
		assertTrue(subGenerosConsultados.size() > 0);
		
		for (SubGenero subGenero : subGenerosConsultados) {
			System.out.println("Subgenero: " + subGenero.getDescripcion());
			System.out.println("Genero: " + subGenero.getGenero().getDescripcion());
		}
	}
	
	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.SubGeneroDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		fail("Not yet implemented");
	}

}
