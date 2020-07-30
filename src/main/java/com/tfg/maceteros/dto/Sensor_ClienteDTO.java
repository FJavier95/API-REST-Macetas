package com.tfg.maceteros.dto;

import io.swagger.annotations.ApiModelProperty;

public class Sensor_ClienteDTO {
	@ApiModelProperty(value = "Sensor")
	private SensorDTO sensores;
	@ApiModelProperty(value = "Cliente")
	private ClienteDTO cliente;

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
