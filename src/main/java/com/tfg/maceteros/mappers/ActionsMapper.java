package com.tfg.maceteros.mappers;

import com.tfg.maceteros.dto.ActionsDTO;
import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.modelo.Actions;
import com.tfg.maceteros.modelo.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionsMapper {

    ActionsDTO entityToDto(Actions entity);
    Actions dtoToEntity(ActionsDTO dto);
    List<ActionsDTO> entitiesToDto(List<Actions> entity);
    List<Actions> dtosToEntities(List<ActionsDTO> dto);
}
