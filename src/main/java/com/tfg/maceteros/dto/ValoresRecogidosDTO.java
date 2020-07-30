package com.tfg.maceteros.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValoresRecogidosDTO {

	@JsonProperty(value = "agua")
	private List<jsonDTO> agua;

	@JsonProperty(value = "peso")
	private List<jsonDTO> peso;

	@JsonProperty(value = "humedad_superior")
	private List<jsonDTO> humedad_superior;

	@JsonProperty(value = "humedad_inferior")
	private List<jsonDTO> humedad_inferior;

	@JsonProperty(value = "temperatura_interior")
	private List<jsonDTO> temperatura_interior;

	@JsonProperty(value = "humedad_ambiental")
	private List<jsonDTO> humedad_ambiental;
	
	@JsonProperty(value = "luz_ambiental")
	private List<jsonDTO> luz_ambiental;

	@JsonProperty(value = "temperatura_ambiental")
	private List<jsonDTO> temperatura_ambiental;

	@JsonProperty(value = "co2")
	private List<jsonDTO> c02;

	public List<jsonDTO> getAgua() {
		return agua;
	}

	public void setAgua(List<jsonDTO> agua) {
		this.agua = agua;
	}

	public List<jsonDTO> getPeso() {
		return peso;
	}

	public void setPeso(List<jsonDTO> peso) {
		this.peso = peso;
	}

	public List<jsonDTO> getHumedad_superior() {
		return humedad_superior;
	}

	public void setHumedad_superior(List<jsonDTO> humedad_superior) {
		this.humedad_superior = humedad_superior;
	}

	public List<jsonDTO> getHumedad_inferior() {
		return humedad_inferior;
	}

	public void setHumedad_inferior(List<jsonDTO> humedad_inferior) {
		this.humedad_inferior = humedad_inferior;
	}

	public List<jsonDTO> getTemperatura_interior() {
		return temperatura_interior;
	}

	public void setTemperatura_interior(List<jsonDTO> temperatura_interior) {
		this.temperatura_interior = temperatura_interior;
	}

	public List<jsonDTO> getHumedad_ambiental() {
		return humedad_ambiental;
	}

	public void setHumedad_ambiental(List<jsonDTO> humedad_ambiental) {
		this.humedad_ambiental = humedad_ambiental;
	}

	public List<jsonDTO> getLuz_ambiental() {
		return luz_ambiental;
	}

	public void setLuz_ambiental(List<jsonDTO> luz_ambiental) {
		this.luz_ambiental = luz_ambiental;
	}

	public List<jsonDTO> getTemperatura_ambiental() {
		return temperatura_ambiental;
	}

	public void setTemperatura_ambiental(List<jsonDTO> temperatura_ambiental) {
		this.temperatura_ambiental = temperatura_ambiental;
	}

	public List<jsonDTO> getC02() {
		return c02;
	}

	public void setC02(List<jsonDTO> c02) {
		this.c02 = c02;
	}

}
