package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Actions;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionDaoCustom {

    Actions findByDesc(String desc);
}
