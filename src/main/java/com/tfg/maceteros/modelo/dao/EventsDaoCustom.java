package com.tfg.maceteros.modelo.dao;

import com.tfg.maceteros.modelo.Events;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsDaoCustom {
    List<Events> findByActionDesc(String desc, Long client);
}
