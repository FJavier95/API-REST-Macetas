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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/sensor-client")
@Api(tags = "Sensor_Cliente_Controller")
//@ApiIgnore
public class Sensor_ClientController {

    @Autowired
    private ISensorClienteService service;
    @ApiIgnore
    @PutMapping(value = "")
    @ApiOperation(value = "Operacion para añadir un nuevo sensor a un cliente en la Base de Datos.")
    public Sensor_ClienteDTO añadirSensorCliente( @RequestBody @ApiParam(value = "Cliente al que pertemece el sensor") Sensor_ClienteDTO sensor_cliente) {
        return service.añadirSensorCliente(sensor_cliente);
    }

    @ApiIgnore
    @PostMapping(value = "/{sensor_client_id}")
    @ApiOperation(value = "Operación para realizar la modificacion de un sensor_client")
    public Sensor_ClienteDTO modificarSensorCliente(@NotNull @NotEmpty @RequestBody @ApiParam(value = "Sensor_Cliente con las modificaciones") Sensor_ClienteDTO sensorCliente, @PathVariable("sensor_client_id") String identificador) {
        return service.modificarSensorCliente(sensorCliente,identificador);
    }

    @ApiIgnore
    @DeleteMapping(value = "/{sensor_client_id}")
    @ApiOperation(value = "Operación para realizar el borrado de un sensor_client")
    public void borrarSensorCliente( @PathVariable("sensor_client_id") String identificador) {
        service.borrarSensorCliente(identificador);
    }


    @GetMapping(value = "/{sensor_id}")
    @ApiOperation(value = "Operación para realizar la busqueda de un sensor_cliente mediante el sensor")
    public Sensor_ClienteDTO findSensorCliente( @PathVariable("sensor_id") String identificador) {
      return  service.buscarSensorCliente(identificador);
    }
}
