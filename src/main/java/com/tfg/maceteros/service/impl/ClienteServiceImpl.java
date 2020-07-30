package com.tfg.maceteros.service.impl;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.mappers.ClienteMapper;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import com.tfg.maceteros.modelo.dao.ClienteDao;
import com.tfg.maceteros.modelo.dao.SensorClienteDao;
import com.tfg.maceteros.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private SensorClienteDao sensorClienteDao;

    public ClienteDTO añadirCliente(ClienteDTO clienteDto) {

        clienteDao.save(clienteMapper.dtoToEntity(clienteDto));
        return clienteMapper.entityToDto(clienteDao.findByThingsBoard(clienteDto.getThingsboardId()));
    }

    public ClienteDTO modificarCliente(ClienteDTO clienteDto) {
        Optional<Cliente> cliente = clienteDao.findById(clienteDto.getId());
        if(cliente.isPresent()) {
            if (!cliente.get().getDescripcion().equals(clienteDto.getDescripcion())) {
                cliente.get().setDescripcion(clienteDto.getDescripcion());
            }
            if (!cliente.get().getLetra().equals(clienteDto.getLetra())) {
                cliente.get().setLetra(clienteDto.getLetra());
            }
            if (!cliente.get().getThingsboardId().equals(clienteDto.getThingsboardId())) {
                cliente.get().setThingsboardId(clienteDto.getThingsboardId());
            }
            clienteDao.save(cliente.get());
            return clienteMapper.entityToDto(cliente.get());
        }
        return null;
    }

    public ClienteDTO borrarCliente(String clienteId) {
        Cliente cliente = clienteDao.findByThingsBoard(clienteId);
        clienteDao.deleteById(cliente.getId());
        return clienteMapper.entityToDto(cliente);
    }

    public ClienteDTO buscarCliente(String identificador){
        return clienteMapper.entityToDto(clienteDao.findByThingsBoard(identificador));
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteDao.findAll();
        return clienteMapper.entitiesToDto(clientes);
    }

    public ClienteDTO buscarPorSensor(String sensorId) {
        Sensor_Cliente sensorCliente = sensorClienteDao.findBySensor(sensorId);

        return clienteMapper.entityToDto(sensorCliente.getCliente());
    }


}
