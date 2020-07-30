package com.tfg.maceteros.service;

import java.util.List;

import com.tfg.maceteros.dto.*;
import com.tfg.maceteros.modelo.Events;
import org.springframework.stereotype.Service;

@Service
public interface IServicio {
	List<TimeLineDTO> persisitirDatos(String device, String idThingsboard);
	String recogerConfiguracion( String device);
	List<EventsDTO> riego(String cliente);
}
