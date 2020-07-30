package com.tfg.maceteros.dto;

import com.tfg.maceteros.modelo.Actions;
import com.tfg.maceteros.modelo.Cliente;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

public class EventsDTO  {

    @ApiModelProperty(value = "Campo autocompletado")
    private Long id;
    @ApiModelProperty(value = "Instante en  el que se registro el evento")
    private Date timestamp;
    @ApiModelProperty(value = "Cliente que registro el evento")
    private Cliente cliente;
    @ApiModelProperty(value = "Acción que se realiza en el evento")
    private Actions action;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }
}
