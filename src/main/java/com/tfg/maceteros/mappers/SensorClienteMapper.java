package com.tfg.maceteros.mappers;
import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.Sensor_ClienteDTO;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, SensorMapper.class})
public interface SensorClienteMapper {

    Sensor_ClienteDTO entityToDto(Sensor_Cliente entity);
    Sensor_Cliente dtoToEntity(Sensor_ClienteDTO dto);
    List<Sensor_ClienteDTO> entitiesToDto(List<Sensor_Cliente> entity);
    List<Sensor_Cliente> dtosToEntities(List<Sensor_ClienteDTO> dto);
}
