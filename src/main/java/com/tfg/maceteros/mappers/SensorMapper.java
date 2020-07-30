package com.tfg.maceteros.mappers;

import java.util.ArrayList;
import java.util.List;
import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.dto.Sensor_ClienteDTO;
import com.tfg.maceteros.modelo.Sensor;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = TipoSensorMapper.class)
public interface SensorMapper {

    @Mapping(target = "tipoSensorId", source = "tipoSensor.nombre")
    SensorDTO entityToDto(Sensor entity);
    @InheritInverseConfiguration
    Sensor dtoToEntity(SensorDTO dto);
    List<SensorDTO> entitiesToDto(List<Sensor> entity);
    List<Sensor> dtosToEntities(List<SensorDTO> dto);
}
