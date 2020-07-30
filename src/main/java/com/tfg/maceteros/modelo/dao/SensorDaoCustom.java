package com.tfg.maceteros.modelo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Sensor;

@Repository
public interface SensorDaoCustom {

	List<Sensor> findByTipoSensor(String i);
	Sensor findByName(String a);
	
}
