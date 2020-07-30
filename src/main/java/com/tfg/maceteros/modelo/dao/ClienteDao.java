package com.tfg.maceteros.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tfg.maceteros.modelo.Cliente;
@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long>, ClienteDaoCustom {

}
