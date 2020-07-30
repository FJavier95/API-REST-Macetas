package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.service.ISensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/sensors")
@Api(tags = "Sensor Controller")
public class SensorController {

    @Autowired
    private ISensorService service;

    @PutMapping(value = "")
    @ApiOperation(value = "Operacion para añadir un nuevo sensor a la Base de datos")
    @ApiIgnore
    public SensorDTO añadirSensor(
            @NotNull @NotEmpty @RequestBody @ApiParam(value = "Sensor que se desea añadir") SensorDTO sensor) {
        return service.añadirSensor(sensor);
    }

    @GetMapping(value = "")
    @ApiOperation(value = "Operacion para listar todos los sensores de la Base de Datos")
    public List<SensorDTO> listarSensores() {
        return service.listarSensores();
    }

    @GetMapping(value = "/{sensor_id}")
    @ApiOperation(value = "Operacion para obtener sensor por id")
    public SensorDTO buscarSensor(@PathVariable(value = "sensor_id") @ApiParam(value = "Identificador del sensor a buscar") String sensor_id ) {
        return service.buscarSensor(sensor_id);
    }

    @GetMapping(value = "/client/{cliente_id}")
    @ApiOperation(value = "Operacion para listar todos los sensores de un cliente")
    public List<SensorDTO> listarSensoresDeCliente(@PathVariable(value = "cliente_id") @ApiParam(value = "Identificador del cliente (Thingsboard)") String idThingsboard ) {
        return service.listarSensoresCliente(idThingsboard);
    }

}
