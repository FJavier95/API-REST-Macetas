package com.tfg.maceteros.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.tfg.maceteros.modelo.TipoSensor;

@Repository
public class TipoSensorDaoCustomImpl implements TipoSensorDaoCustom{
	/**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    public TipoSensor findByNombre(String a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TipoSensor> query = cb.createQuery(TipoSensor.class);
        Root<TipoSensor> tipoSensor = query.from(TipoSensor.class);
        query.select(tipoSensor).where(tipoSensor.get("nombre").in(a));
        return entityManager.createQuery(query).getSingleResult();
    }
}

