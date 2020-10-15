package com.tfg.maceteros.service.impl;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.TimeLineDTO;
import com.tfg.maceteros.dto.ValoresangularDTO;
import com.tfg.maceteros.mappers.ClienteMapper;
import com.tfg.maceteros.mappers.TimelineMapper;
import com.tfg.maceteros.modelo.*;
import com.tfg.maceteros.modelo.dao.*;
import com.tfg.maceteros.service.ITimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeLineServiceImpl implements ITimeLineService {
    @Autowired
    private SensorDao sensorDao;
    @Autowired
    private TimeLineDao timeLineDao;
    @Autowired
    private TimelineMapper timelineMapper;
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private SensorClienteDao sensorClienteDao;
    @Autowired
    private TipoSensorDao tipoSensorDao;

    public List<TimeLineDTO> valoresSensor(String sensor_id){
        Optional<Sensor> sensor = sensorDao.findById(Long.parseLong(sensor_id));
        return sensor.isPresent() ? timelineMapper.entitiesToDto(timeLineDao.findBySensorOrder(sensor.get())) : null;
    }

    public List<ValoresangularDTO> valoresCliente(){

        List<ValoresangularDTO> response = new ArrayList<ValoresangularDTO>();
        List<ClienteDTO> clienteDTOS = clienteMapper.entitiesToDto((List<Cliente>) clienteDao.findAll());
        List<TipoSensor> tipoSensors = (List<TipoSensor>) tipoSensorDao.findAll();
        for(ClienteDTO client :clienteDTOS){
                List<Sensor_Cliente> sensor_clientes = sensorClienteDao.findByCliente(client.getId());
                ValoresangularDTO valores = new ValoresangularDTO();
                valores.setClienteDTO(client);
                for(Sensor_Cliente sensor_cliente : sensor_clientes) {
                    switch (sensor_cliente.getSensores().getNombre()) {
                        case "Detector de Agua": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getAgua_detectada().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Sensor Peso": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getPeso().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Humedad Superficie": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getHumedad_tierra().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Temperatura Superficie": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getTemperatura_interior().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Humedad Ambiental": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getHumedad_ambiental().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Luminosidad": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getLuz_ambiental().add(timeline.getValor());
                            }
                            break;
                        }
                        case "Temperatura Ambiental": {
                            for (Timeline timeline : timeLineDao.findBySensorOrder(sensor_cliente.getSensores())) {
                                valores.getTemperatura_ambiental().add(timeline.getValor());
                            }
                            break;
                        }
                    }
                }
            response.add(valores);
        }
        return response;
    }
}
