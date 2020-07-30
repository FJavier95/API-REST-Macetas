package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.service.IClienteService;
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
@RequestMapping(value = "/api/client")
@Api(tags = "Client Controller")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @ApiIgnore
    @PutMapping(value = "")
    @ApiOperation(value = "Operación para añadir un nuevo cliente en la Base de Datos.")
    public ClienteDTO añadirCliente(@NotNull @NotEmpty @RequestBody @ApiParam(value = "Cliente que se desea añadir") ClienteDTO cliente) {
        return service.añadirCliente(cliente);
    }

    @GetMapping(value = "")
    @ApiOperation(value = "Operacion para listar todos los clientes de la Base de Datos")
    public List<ClienteDTO> listarClientes() {
        return service.listarClientes();
    }

    @GetMapping(value = "/{client_id}")
    @ApiOperation(value = "Operación para buscar un cliente concreto por su identificador del Thingsboard")
    public ClienteDTO buscarCliente(@NotNull @NotEmpty @PathVariable(value = "client_id")
                                    @ApiParam(value = "Identificador del cliente a buscar") String clienteId) {
        return service.buscarCliente(clienteId);
    }

    @ApiIgnore
    @PostMapping(value = "/{client_id}")
    @ApiOperation(value = "Operación para realizar la modificacion de un cliente")
    public ClienteDTO modificarCliente(@NotNull @NotEmpty @RequestBody @ApiParam(value = "Cliente que se desea añadir") ClienteDTO cliente) {
        return service.modificarCliente(cliente);
    }

    @ApiIgnore
    @DeleteMapping(value = "/{client_id}")
    @ApiOperation(value = "Operación para eliminar un cliente concreto por su identificador del Thingsboard")
    public ClienteDTO borrarCliente(@NotNull @NotEmpty @PathVariable(value = "client_id")
                                    @ApiParam(value = "Identificador del cliente a eliminar") String clienteId) {
        return service.borrarCliente(clienteId);
    }

    @GetMapping(value = "/sensor/{sensor_id}")
    @ApiOperation(value = "Operación para buscar cliente donde está instalado el sensor")
    public ClienteDTO buscarClienteSensor(@NotNull @NotEmpty @PathVariable(value = "sensor_id") @ApiParam(value = "Identificador del sensor a buscar") String sensorId) {
        return service.buscarPorSensor(sensorId);
    }

}
