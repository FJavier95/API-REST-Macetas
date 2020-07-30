package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Actions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class ActionDaoCustomImpl implements ActionDaoCustom {
    /**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Actions findByDesc(String desc) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actions> query = cb.createQuery(Actions.class);
        Root<Actions> action = query.from(Actions.class);
        query.select(action).where(action.get("actionDesc").in(desc));
        return entityManager.createQuery(query).getSingleResult();
    }
}
