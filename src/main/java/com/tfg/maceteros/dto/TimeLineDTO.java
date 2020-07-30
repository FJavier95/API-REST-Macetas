package com.tfg.maceteros.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TimeLineDTO {

	@ApiModelProperty(value = "Campo autocompletado")
    private Long id;
	@ApiModelProperty(value = "Sensor que recoge el valor")
	private SensorDTO sensor;
	@ApiModelProperty(value = "Valor recogido por el sensor")
	private String valor;
	@ApiModelProperty(value = "Instante en el que se almacena el valor")
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SensorDTO getSensor() {
		return sensor;
	}

	public void setSensor(SensorDTO sensor) {
		this.sensor = sensor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
