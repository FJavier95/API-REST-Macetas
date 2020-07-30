package com.tfg.maceteros.mappers;

import java.util.ArrayList;
import java.util.List;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.modelo.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	ClienteDTO entityToDto(Cliente entity);
	Cliente dtoToEntity(ClienteDTO dto);
	List<ClienteDTO> entitiesToDto(List<Cliente> entity);
	List<Cliente> dtosToEntities(List<ClienteDTO> dto);
}
