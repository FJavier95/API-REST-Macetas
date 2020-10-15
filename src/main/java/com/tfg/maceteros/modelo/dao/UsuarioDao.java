package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Actions;
import com.tfg.maceteros.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}