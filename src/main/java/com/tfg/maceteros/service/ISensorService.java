package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.SensorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ISensorService {

SensorDTO añadirSensor(SensorDTO sensorDTO);
    void borrarSensor( String identificador);
    List<SensorDTO> listarSensores();
   SensorDTO modificarSensor(SensorDTO sensor, String identificador);
    List<SensorDTO> listarSensoresCliente(String cliente);
    SensorDTO buscarSensor(String sensorId);
}
