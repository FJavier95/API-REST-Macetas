package com.tfg.maceteros.dto;

import io.swagger.annotations.ApiModelProperty;

public class Sensor_ClienteDTO {
	@ApiModelProperty(value = "Campo autocompletado")
	private Long id;
	@ApiModelProperty(value = "Sensor")
	private SensorDTO sensores;
	@ApiModelProperty(value = "Cliente")
	private ClienteDTO cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SensorDTO getSensores() {
		return sensores;
	}

	public void setSensores(SensorDTO sensores) {
		this.sensores = sensores;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	
}
