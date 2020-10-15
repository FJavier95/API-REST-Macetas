package com.tfg.maceteros.controller;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.EventsDTO;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.service.IEnventosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//@ApiIgnore
@RestController
@RequestMapping(value = "/api/event")
@Api(tags = "Event Controller")
@ApiIgnore
public class EventController {

    @Autowired
    private IEnventosService service;

    @PutMapping(value = "/{action}/{client_id}")
    @ApiOperation(value = "Operación para registrar un nuevo evento")
    public EventsDTO registrarEvento(@NotNull @NotEmpty @PathVariable(value = "client_id") @ApiParam(value = "Identificador del cliente (Thingsboard)") String idThingsboard,
                                   @NotNull @NotEmpty @PathVariable(value = "action") @ApiParam(value = "Nombre de la accion (regla)") String accion) {
        return service.registrarEvento(accion,idThingsboard);
    }
}
