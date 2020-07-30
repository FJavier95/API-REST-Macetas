package com.tfg.maceteros.dto;

import com.tfg.maceteros.modelo.TipoSensor;
import io.swagger.annotations.ApiModelProperty;

public class SensorDTO {

	@ApiModelProperty(value = "Campo autocompletado")
    private Long id;
	@ApiModelProperty(value = "Nombre del sensor")
	private String nombre;
	@ApiModelProperty(value = "Tipo de Sensor asignado")
	private String tipoSensorId;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoSensorId() {
		return tipoSensorId;
	}

	public void setTipoSensorId(String tipoSensorId) {
		this.tipoSensorId = tipoSensorId;
	}

}
