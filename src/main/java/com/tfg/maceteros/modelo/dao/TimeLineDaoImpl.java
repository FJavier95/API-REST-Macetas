package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Sensor;
import com.tfg.maceteros.modelo.Timeline;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TimeLineDaoImpl implements TimeLineDaoCustom {
    /**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    public List<Timeline> findBySensor(Sensor a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Timeline> query = cb.createQuery(Timeline.class);
        Root<Timeline> timeline = query.from(Timeline.class);
        query.select(timeline).where(timeline.get("sensor").in(a));
        return entityManager.createQuery(query).setMaxResults(100).getResultList();
    }

    public List<Timeline> findBySensorOrder(Sensor a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Timeline> query = cb.createQuery(Timeline.class);
        Root<Timeline> timeline = query.from(Timeline.class);
        query.select(timeline).where(timeline.get("sensor").in(a)).orderBy(cb.desc(timeline.get("timestamp")));
        return entityManager.createQuery(query).setMaxResults(100).getResultList();
    }
}

