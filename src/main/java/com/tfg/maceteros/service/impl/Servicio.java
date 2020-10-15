package com.tfg.maceteros.service.impl;

import java.util.*;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import com.tfg.maceteros.dto.*;
import com.tfg.maceteros.mappers.*;
import com.tfg.maceteros.modelo.*;
import com.tfg.maceteros.modelo.dao.*;
import com.tfg.maceteros.service.IServicio;
import com.tfg.maceteros.service.config.Constantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Servicio implements IServicio {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private TimeLineDao timeLineDao;
	@Autowired
	private TimelineMapper timelineMapper;
	@Autowired
	private TipoSensorDao tipoSensorDao;
	@Autowired
	private SensorDao sensorDao;
	@Autowired
	private SensorClienteDao sensorClienteDao;
	@Autowired
	private EventsDao eventsDao;
	@Autowired
	private EventsMapper eventsMapper;
	@Autowired
	private UsuarioDao usuarioDao;
	@Bean
	private RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

	public Usuario login(String usuario, String pass){
	List<Usuario> usuarios =(ArrayList<Usuario>) usuarioDao.findAll();
	String passCod = Base64.getEncoder().encodeToString(pass.getBytes());
		for (Usuario user:usuarios ) {
			if(user.getUsuario().equals(usuario) && user.getPass().equals(passCod)){
				return user;
			}
		}
		return new Usuario();
	}
	private HttpHeaders cabeceras() {
		HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("X-Authorization", "Bearer ".concat(Constantes.TOKEN));
		headers.add("Accept", "*/*");
		headers.add("Cache-Control", "no-cache");
		headers.add("Accept-Encoding", "gzip, deflate");
		headers.add("Connection", "keep-alive");
		headers.add("cache-control", "no-cache");
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return headers;
	}

	public List<TimeLineDTO> persisitirDatos(String device, String idThingsboard){
		Logger logger = LoggerFactory.getLogger(Servicio.class);
		Cliente cliente = clienteDao.findByThingsBoard(idThingsboard);
		List<TimeLineDTO> listaResultado = new ArrayList<TimeLineDTO>();
		if (device != null) {
			String url = Constantes.ENDPOINT.concat(device).concat("/values/timeseries");
			ObjectMapper objectMapper = new ObjectMapper();
			HttpEntity<String> entity = new HttpEntity<String>(null, this.cabeceras());
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

			try {
				Map valores = objectMapper.readValue(response.getBody(), Map.class);
				logger.info("VALORES OBTENIDOS: ", valores);
				Object[] arrayKeys= valores.keySet().toArray();
				for(Object object : arrayKeys){
					Timeline timeline = new Timeline();
					Object lectura = valores.get(object);
					try {
						Sensor_Cliente sensor_cliente = sensorClienteDao.findByClienteSensor(idThingsboard, object.toString());
						String valor = ((LinkedHashMap) ((ArrayList) lectura).get(0)).get("value").toString();
						timeline.setFecha(new Date());
						timeline.setSensor(sensor_cliente.getSensores());
						timeline.setValor(valor);
						timeLineDao.save(timeline);
						listaResultado.add(timelineMapper.entityToDto(timeline));
					} catch (EmptyResultDataAccessException e) {

					}
				}
			} catch (JsonProcessingException  e ) {
				e.printStackTrace();
			}

		}
		return listaResultado;
	}

	public String recogerConfiguracion( String device) {
		String url = Constantes.ENDPOINT_ATTRIBUTES.concat(device).concat("/attributes");
		ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> entity = new HttpEntity<String>(null, this.cabeceras());
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return response.getBody();
	}

	public List<EventsDTO> riego(String cliente){
		Cliente client = clienteDao.findByThingsBoard(cliente);
	return eventsMapper.entitiesToDto(eventsDao.findByActionDesc("abrir el riego", client.getId()));
	}
}
