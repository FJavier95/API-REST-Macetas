package com.tfg.maceteros.mappers;

import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.modelo.Sensor;
import com.tfg.maceteros.modelo.Timeline;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = SensorMapper.class)
public interface TimelineMapper {

    TimeLineDTO entityToDto(Timeline entity);
    Timeline dtoToEntity(TimeLineDTO dto);
    List<TimeLineDTO> entitiesToDto(List<Timeline> entity);
    List<Timeline> dtosToEntities(List<TimeLineDTO> dto);
}
