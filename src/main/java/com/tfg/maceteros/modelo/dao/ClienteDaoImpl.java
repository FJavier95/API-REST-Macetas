package com.tfg.maceteros.modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.tfg.maceteros.modelo.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDaoCustom {
	/**
     * Entity Manager que gestiona los accesos a BD
     */
    @PersistenceContext
    private EntityManager entityManager;

    public Cliente findByThingsBoard(String a) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = query.from(Cliente.class);
        query.select(cliente).where(cliente.get("thingsboardId").in(a));
        return entityManager.createQuery(query).getSingleResult();
    }
}
