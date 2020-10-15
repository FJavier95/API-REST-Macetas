package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IClienteService {
    ClienteDTO añadirCliente(ClienteDTO cliente);
    ClienteDTO modificarCliente(ClienteDTO clienteDto, String identificador);
    ClienteDTO borrarCliente(String clienteId);
    ClienteDTO buscarCliente(String identificador);
    ClienteDTO buscarPorSensor(String sensorId);
    List<ClienteDTO> listarClientes();
}
