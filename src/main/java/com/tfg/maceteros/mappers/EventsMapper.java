package com.tfg.maceteros.mappers;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.EventsDTO;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Events;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventsMapper {
    EventsDTO entityToDto(Events entity);
    Events dtoToEntity(EventsDTO dto);
    List<EventsDTO> entitiesToDto(List<Events> entity);
    List<Events> dtosToEntities(List<EventsDTO> dto);
}
