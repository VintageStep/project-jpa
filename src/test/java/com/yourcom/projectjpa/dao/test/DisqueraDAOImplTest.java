/**
 * 
 */
package com.yourcom.projectjpa.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mycom.projectjpa.entity.Disquera;
import com.yourcom.projectjpa.dao.DisqueraDAO;
import com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl;

/**
 * @author Tom
 *
 */
class DisqueraDAOImplTest {
	
	private DisqueraDAO disqueraDAO = new DisqueraDAOImpl();

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl#guardar(com.mycom.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testGuardar() {
		
		Disquera disquera = new Disquera();
		disquera.setDescripcion("MegaForce");
		disquera.setFechaCreacion(LocalDateTime.now());
		disquera.setStatus(true);
		
		
		this.disqueraDAO.guardar(disquera);
		
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl#actualizar(com.mycom.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testActualizar() {
		Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
		
		disqueraConsultada.setDescripcion("Moe");
		
		this.disqueraDAO.actualizar(disqueraConsultada);
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl#eliminar(com.mycom.projectjpa.entity.Disquera)}.
	 */
	@Test
	void testEliminar() {
		Long Id = 10L;
		this.disqueraDAO.eliminar(Id);
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl#consultar()}.
	 */
	@Test
	void testConsultar() {
		List<Disquera> disquerasConsultadas = this.disqueraDAO.consultar();
		
		assertTrue(disquerasConsultadas.size() > 0);
		
		disquerasConsultadas.forEach(disquera -> {
			System.out.println("Disquera : " + disquera.getDescripcion());
		});
	}

	/**
	 * Test method for {@link com.yourcom.projectjpa.dao.impl.DisqueraDAOImpl#consultarById(java.lang.Long)}.
	 */
	@Test
	void testConsultarById() {
		Disquera disquera = this.disqueraDAO.consultarById(11L);
		
		assertNotNull(disquera);
		
		System.out.println("Disquera: " + disquera.getDescripcion());
	}
	
	@Test
	void testConsultarByDescripcionJPQL() {
		
		Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionJPQL("Moe");
		
		assertNotNull(disqueraConsultada);
		
		System.out.println("Disquera por descripcion: " + disqueraConsultada);
	}
	
	@Test
	void consultarByDescripcionNative() {
		
		Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionNative("Moe");
		
		assertNotNull(disqueraConsultada);
		
		System.out.println("Disquera por descripcion: " + disqueraConsultada);
	}

}
