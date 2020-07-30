package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Timeline;

import java.util.List;

@Repository
public interface TimeLineDao extends CrudRepository<Timeline, Long>,TimeLineDaoCustom {

    List<Timeline> findBySensor(Sensor a);
    List<Timeline> findBySensorOrder(Sensor a);


}
