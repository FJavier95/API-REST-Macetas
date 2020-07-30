package com.tfg.maceteros.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Sensor_Cliente;

@Repository
public interface SensorClienteDao extends CrudRepository<Sensor_Cliente, Long>, SensorClienteDaoCustom {

}
