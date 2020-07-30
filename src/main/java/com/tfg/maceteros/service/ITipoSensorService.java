package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.TipoSensorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ITipoSensorService {
    List<TipoSensorDTO> listarTipoSensor();
    TipoSensorDTO buscarTipoSensor(String identificador);;
}
