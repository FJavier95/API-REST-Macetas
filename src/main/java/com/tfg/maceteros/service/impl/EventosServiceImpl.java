package com.tfg.maceteros.service.impl;

import com.tfg.maceteros.dto.EventsDTO;
import com.tfg.maceteros.mappers.EventsMapper;
import com.tfg.maceteros.modelo.Actions;
import com.tfg.maceteros.modelo.Cliente;
import com.tfg.maceteros.modelo.Events;
import com.tfg.maceteros.modelo.dao.ActionDao;
import com.tfg.maceteros.modelo.dao.ClienteDao;
import com.tfg.maceteros.modelo.dao.EventsDao;
import com.tfg.maceteros.service.IEnventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class EventosServiceImpl implements IEnventosService {
     @Autowired
    private EventsDao eventsDao;
    @Autowired
    private ClienteDao clienteDao;
    @Autowired
    private ActionDao actionDao;
    @Autowired
    private EventsMapper eventsMapper;

    public EventsDTO registrarEvento(String actions, String cliente){
        Events evento =  new Events();
        Actions accion = actionDao.findByDesc(actions);
        Cliente client = clienteDao.findByThingsBoard(cliente);
        accion.setActionDesc(actions);
        evento.setAction(accion);
        evento.setCliente(client);
        evento.setTimestamp(new Date());
        eventsDao.save(evento);
        return eventsMapper.entityToDto(evento);
    }
}
