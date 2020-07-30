package com.tfg.maceteros.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.tfg.maceteros.modelo.Sensor_Cliente;

import java.util.List;
import java.util.Optional;

public class SensorClienteDaoImpl implements SensorClienteDaoCustom{

	/**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    public Sensor_Cliente findBySensor(String a) {
    	Integer i = Integer.parseInt(a); 
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor_Cliente> query = cb.createQuery(Sensor_Cliente.class);
        Root<Sensor_Cliente> sensor_cliente = query.from(Sensor_Cliente.class);
        query.select(sensor_cliente).where(sensor_cliente.get("sensor").in(i));
        return entityManager.createQuery(query).getSingleResult();
    }

    public List<Sensor_Cliente> findByCliente(Long a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor_Cliente> query = cb.createQuery(Sensor_Cliente.class);
        Root<Sensor_Cliente> sensor_cliente = query.from(Sensor_Cliente.class);
        query.select(sensor_cliente).where(sensor_cliente.get("cliente").in(a));
        return entityManager.createQuery(query).getResultList();
    }

    public Sensor_Cliente findByClienteSensor(String cliente, String sensor ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sensor_Cliente> query = cb.createQuery(Sensor_Cliente.class);
        Root<Sensor_Cliente> sensor_cliente = query.from(Sensor_Cliente.class);
        query.select(sensor_cliente).where(sensor_cliente.get("cliente").get("thingsboardId").in(cliente)).where(sensor_cliente.get("sensor").get("nombre").in(sensor));
        return entityManager.createQuery(query).getSingleResult();
    }
}
