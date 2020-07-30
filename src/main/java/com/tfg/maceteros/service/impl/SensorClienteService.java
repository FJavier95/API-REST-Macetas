package com.tfg.maceteros.service.impl;

import com.tfg.maceteros.dto.ClienteDTO;
import com.tfg.maceteros.dto.SensorDTO;
import com.tfg.maceteros.dto.Sensor_ClienteDTO;
import com.tfg.maceteros.mappers.ClienteMapper;
import com.tfg.maceteros.mappers.SensorClienteMapper;
import com.tfg.maceteros.mappers.SensorMapper;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Sensor;
import com.tfg.maceteros.modelo.Sensor_Cliente;
import com.tfg.maceteros.modelo.TipoSensor;
import com.tfg.maceteros.modelo.dao.ClienteDao;
import com.tfg.maceteros.modelo.dao.SensorClienteDao;
import com.tfg.maceteros.modelo.dao.TipoSensorDao;
import com.tfg.maceteros.service.ISensorClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SensorClienteService implements ISensorClienteService {
    @Autowired
    private SensorClienteDao sensorClienteDao;
    @Autowired
    private SensorClienteMapper sensorClienteMapper;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private SensorMapper sensorMapper;
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private TipoSensorDao tipoSensorDao;
    @Override
    public Sensor_ClienteDTO añadirSensorCliente(Sensor_ClienteDTO sensor_clienteDTO) {
        Sensor_Cliente sensor_cliente = new Sensor_Cliente();
        TipoSensor tipoSensor = tipoSensorDao.findByNombre(sensor_clienteDTO.getSensores().getTipoSensorId());
        Cliente cliente = clienteDao.findByThingsBoard(sensor_clienteDTO.getCliente().getThingsboardId());
        sensor_cliente.setCliente(cliente);
        Sensor sensor = new Sensor();
        sensor.setId(sensor_clienteDTO.getSensores().getId());
        sensor.setNombre(sensor_clienteDTO.getSensores().getNombre());
        sensor.setTipoSensor(tipoSensor);
        sensor_cliente.setSensores(sensor);
        sensorClienteDao.save(sensor_cliente);
        return sensorClienteMapper.entityToDto(sensor_cliente);
    }
}
