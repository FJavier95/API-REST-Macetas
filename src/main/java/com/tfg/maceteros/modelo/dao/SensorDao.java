package com.tfg.maceteros.modelo.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Sensor;
@Repository
public interface SensorDao extends CrudRepository<Sensor, Long>, SensorDaoCustom {
	
}
