/**
 * 
 */
package com.mycom.projectjpa.entity;

import java.time.LocalDateTime;

import javax.persistence.*;


/**
 * @author VintageStep
 * Clase que representa la entidad que mapea a la tabla de disquera con JPA
 */

@Entity
@Table(name = "disquera")
public class Disquera {

	// Atributos
	
	// @Column -> Si el atributo de la clase no es igual al de la BBDD esto es obligatorio
	// Cuando los nombres son iguales no es obligatorio pero se puede utilizar
	// Se pueden utilizar varios atributos además de nombre, como length si uno desea delimitar la cantidad de 
	// caracteres posibles para equipararlo a la BBDD
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDisquera") 
	private Long idDisquera;
	
	@Column(name="descripcion", length = 100) 
	private String descripcion;
	
	@Column(name="fechaCreacion")
	private LocalDateTime fechaCreacion;
	
	@Column(name="fechaModificacion")
	private LocalDateTime fechaModificacion;
	
	@Column(name="estatus")
	private boolean estatus;
	
	
	
	// Getters y Setters
	
	public Long getIdDisquera() {
		return idDisquera;
	}
	public void setIdDisquera(Long idDisquera) {
		this.idDisquera = idDisquera;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public boolean isStatus() {
		return estatus;
	}
	public void setStatus(boolean estatus) {
		this.estatus = estatus;
	}
	
}
