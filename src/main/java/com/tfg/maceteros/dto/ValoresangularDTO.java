package com.tfg.maceteros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ValoresangularDTO {


    private List<String> Co2;
    private List<String> agua_detectada ;
    private List<String> peso ;
    private List<String> luz_ambiental ;
    private List<String> humedad_ambiental ;
    private List<String> humedad_tierra ;
    private List<String> temperatura_interior ;
    private List<String> temperatura_ambiental ;
    private ClienteDTO clienteDTO;

    public ValoresangularDTO(){
        this.Co2 = new ArrayList<String>();
        this.agua_detectada = new ArrayList<String>();
        this.peso = new ArrayList<String>();
        this.luz_ambiental = new ArrayList<String>();
        this.humedad_ambiental = new ArrayList<String>();
        this.humedad_tierra = new ArrayList<String>();
        this.temperatura_interior = new ArrayList<String>();
        this.temperatura_ambiental = new ArrayList<String>();
        this.clienteDTO = new ClienteDTO();

    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public List<String> getCo2() {
        return Co2;
    }

    public void setCo2(List<String> co2) {
        Co2 = co2;
    }

    public List<String> getAgua_detectada() {
        return agua_detectada;
    }

    public void setAgua_detectada(List<String> agua_detectada) {
        this.agua_detectada = agua_detectada;
    }

    public List<String> getPeso() {
        return peso;
    }

    public void setPeso(List<String> peso) {
        this.peso = peso;
    }

    public List<String> getLuz_ambiental() {
        return luz_ambiental;
    }

    public void setLuz_ambiental(List<String> luz_ambiental) {
        this.luz_ambiental = luz_ambiental;
    }

    public List<String> getHumedad_ambiental() {
        return humedad_ambiental;
    }

    public void setHumedad_ambiental(List<String> humedad_ambiental) {
        this.humedad_ambiental = humedad_ambiental;
    }

    public List<String> getHumedad_tierra() {
        return humedad_tierra;
    }

    public void setHumedad_tierra(List<String> humedad_tierra) {
        this.humedad_tierra = humedad_tierra;
    }

    public List<String> getTemperatura_interior() {
        return temperatura_interior;
    }

    public void setTemperatura_interior(List<String> temperatura_interior) {
        this.temperatura_interior = temperatura_interior;
    }

    public List<String> getTemperatura_ambiental() {
        return temperatura_ambiental;
    }

    public void setTemperatura_ambiental(List<String> temperatura_ambiental) {
        this.temperatura_ambiental = temperatura_ambiental;
    }
}
