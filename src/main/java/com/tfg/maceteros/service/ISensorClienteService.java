package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.dto.Sensor_ClienteDTO;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ISensorClienteService {

    Sensor_ClienteDTO añadirSensorCliente(Sensor_ClienteDTO sensor_cliente);
}
