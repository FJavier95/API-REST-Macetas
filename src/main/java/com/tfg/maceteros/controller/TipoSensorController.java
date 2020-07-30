package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.TipoSensorDTO;
import com.tfg.maceteros.service.ITipoSensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/tipoSensor")
@Api(tags = "Sensor Type Controller")
public class TipoSensorController{
    @Autowired
    private ITipoSensorService service;

    @GetMapping(value = "")
    @ApiOperation(value = "Operación para listar todos los tipos de sensores de la Base de Datos")
    public List<TipoSensorDTO> listarTipoSensor() {
        return service.listarTipoSensor();
    }

    @GetMapping(value = "/{tipoSensor_id}")
    @ApiOperation(value = "Operación para buscar un tipo de sensor concreto" )
    public TipoSensorDTO buscarTipoSensor(@NotNull @NotEmpty @PathVariable(value = "tipoSensor_id")
                                              @ApiParam(value = "Identificador del tipo de sensor") String tipoSensorId) {
        return service.buscarTipoSensor(tipoSensorId);
    }
}
