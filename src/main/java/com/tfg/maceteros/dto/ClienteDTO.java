package com.tfg.maceteros.dto;

import io.swagger.annotations.ApiModelProperty;

public class ClienteDTO {

	@ApiModelProperty(value = "Campo autocompletado")
	 private Long id;
	@ApiModelProperty(value = "Descripción del cliente")
	private String descripcion;
	@ApiModelProperty(value = "Campo para identificar el cliente en la interfaz")
	private String letra;
	@ApiModelProperty(value = "Identificador asignado por la plataforma ThingsBaord")
	private String thingsboardId;

	
	public String getThingsboardId() {
		return thingsboardId;
	}

	public void setThingsboardId(String thingsboardId) {
		this.thingsboardId = thingsboardId;
	}

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

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}
	
		
}
