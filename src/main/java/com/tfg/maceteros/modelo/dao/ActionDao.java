package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Actions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionDao extends CrudRepository<Actions, Long>, ActionDaoCustom {
}
