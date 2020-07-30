package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Actions;
import com.tfg.maceteros.modelo.Events;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EventsDaoCustomImpl implements EventsDaoCustom {
    /**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Events> findByActionDesc(String desc, Long client) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Events> query = cb.createQuery(Events.class);
        Root<Events> event = query.from(Events.class);
        query.select(event).where(event.get("action.action_desc").in(desc)).where(event.get("cliente.id").in(client));
        return entityManager.createQuery(query).getResultList();
    }
}
