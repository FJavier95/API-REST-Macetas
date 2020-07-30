package com.tfg.maceteros.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ActionsDTO {

    @ApiModelProperty(value = "Campo autocompletado")
    private Long id;
    @ApiModelProperty(value = "Descripción de la acción")
    private String actionDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }
}
