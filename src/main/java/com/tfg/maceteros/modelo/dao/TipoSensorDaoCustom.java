package com.tfg.maceteros.modelo.dao;


import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.TipoSensor;
@Repository
public interface TipoSensorDaoCustom {

	TipoSensor findByNombre(String i);
}
