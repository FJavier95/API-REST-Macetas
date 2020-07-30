package com.tfg.maceteros.dto;

import com.tfg.maceteros.service.config.Constantes;
import io.swagger.annotations.ApiModelProperty;

public class TipoSensorDTO {

	@ApiModelProperty(value = "Campo autocompletado")
	private Long id;
	@ApiModelProperty(value = "Descripción del tipo de sensor")
	private String descripcion;

	@ApiModelProperty(value = "Nombre del tipo de sensor",allowableValues = Constantes.KEYS)
	private String nombre;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	

}
