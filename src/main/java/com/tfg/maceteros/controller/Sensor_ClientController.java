package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.dto.Sensor_ClienteDTO;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import com.tfg.maceteros.service.IClienteService;
import com.tfg.maceteros.service.ISensorClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/sensor-client")
@Api(tags = "Sensor_Cliente_Controller")
//@ApiIgnore
public class Sensor_ClientController {

    @Autowired
    private ISensorClienteService service;

    @PutMapping(value = "")
    @ApiOperation(value = "Operacion para añadir un nuevo sensor a un cliente en la Base de Datos.")
    public Sensor_ClienteDTO añadirSensorCliente( @RequestBody @ApiParam(value = "Cliente al que pertemece el sensor") Sensor_ClienteDTO sensor_cliente) {
        return service.añadirSensorCliente(sensor_cliente);
    }
}
