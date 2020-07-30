package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsDao extends CrudRepository<Events, Long>, EventsDaoCustom {
}
