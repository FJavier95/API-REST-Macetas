/*Cargamos Tipo Sensores*/
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor detector de agua', 'agua');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de peso', 'peso');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de humedad de la tierra', 'humedad_tierra');
INSERT INTO sensor_type(descripcion,nombre) values ('Sonda de temperatura de la tierra', 'temperatura_interior');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de humedad ambiental', 'humedad_ambiental');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de luminosidad ambiental', 'luz_ambiental');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de temperatura ambiental', 'temperatura_ambiental');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de Co2', 'Co2');
/* Carga de las acciones*/
INSERT INTO action(action_desc) values ('abrir el riego');
INSERT INTO action(action_desc) values ('cerrar el riego');
INSERT INTO action(action_desc) values ('mover la tierra');
INSERT INTO action(action_desc) values ('echar alimento');
INSERT INTO action(action_desc) values ('cambiar parámetros de configuración');
INSERT INTO action(action_desc) values ('mandar aviso');
