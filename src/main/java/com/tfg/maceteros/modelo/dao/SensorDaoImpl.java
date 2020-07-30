package com.tfg.maceteros.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Sensor;
@Repository
public class SensorDaoImpl implements SensorDaoCustom{
	/**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    public List<Sensor> findByTipoSensor(String a) {
    	Integer i = Integer.parseInt(a); 
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor> query = cb.createQuery(Sensor.class);
        Root<Sensor> sensor = query.from(Sensor.class);
        query.select(sensor).where(sensor.get("tipoSensor").in(i));
        return entityManager.createQuery(query).getResultList();
    }

    public Sensor findByName(String a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor> query = cb.createQuery(Sensor.class);
        Root<Sensor> sensor = query.from(Sensor.class);
        query.select(sensor).where(sensor.get("nombre").in(a));
        return entityManager.createQuery(query).getSingleResult();
    }
}
