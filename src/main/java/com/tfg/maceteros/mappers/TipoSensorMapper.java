package com.tfg.maceteros.mappers;

import java.util.ArrayList;
import java.util.List;

import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.dto.TipoSensorDTO;
import com.tfg.maceteros.modelo.Timeline;
import com.tfg.maceteros.modelo.TipoSensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoSensorMapper {

    TipoSensorDTO entityToDto(TipoSensor entity);
    TipoSensor dtoToEntity(TipoSensorDTO dto);
    List<TipoSensorDTO> entitiesToDto(List<TipoSensor> entity);
    List<TipoSensor> dtosToEntities(List<TipoSensorDTO> dto);
}
