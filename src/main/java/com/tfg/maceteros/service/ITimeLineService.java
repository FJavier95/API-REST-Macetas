package com.tfg.maceteros.service;

import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.dto.ValoresangularDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ITimeLineService {
    List<TimeLineDTO> valoresSensor(String sensor_id);
    List<ValoresangularDTO> valoresCliente();
}
