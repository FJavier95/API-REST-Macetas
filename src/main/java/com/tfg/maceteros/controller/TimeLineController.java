package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.dto.ValoresangularDTO;
import com.tfg.maceteros.service.ITimeLineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping(value = "/api/timeLine")
@CrossOrigin(value = "*")
@Api(tags = "Timeline Controller")
public class TimeLineController {

    @Autowired
    private ITimeLineService service;

    @GetMapping(value = "/{sensor_id}")
    @ApiOperation(value = "Operación para listar los 100 ultimos  valores recogidos por un sensor")
    public List<TimeLineDTO> valoresSensor(@PathVariable(value = "sensor_id") @ApiParam(value = "Identificador del sensor a buscar") String sensorId ) {
        return service.valoresSensor(sensorId);
    }

    @ApiIgnore
    @GetMapping(value = "all")
    @ApiOperation(value = "Operación para listar los valores de todos los sensores de un cliente")
    public List<ValoresangularDTO> valoresCliente( ) {
        return service.valoresCliente();
    }
}
