package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.EventsDTO;
import org.springframework.stereotype.Service;

@Service
public interface IEnventosService {

    EventsDTO registrarEvento(String accion, String clienteId);
}
