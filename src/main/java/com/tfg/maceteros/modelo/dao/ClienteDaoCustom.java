package com.tfg.maceteros.modelo.dao;

import org.springframework.stereotype.Repository;
import com.tfg.maceteros.modelo.Cliente;


@Repository
public interface ClienteDaoCustom {

	Cliente findByThingsBoard(String a);
}
