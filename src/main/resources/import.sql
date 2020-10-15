/*Cargamos Tipo Sensores*/
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor detector de agua', 'Detector de Agua');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de peso', 'Sensor Peso');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de humedad de la tierra', 'Humedad Superficie');
INSERT INTO sensor_type(descripcion,nombre) values ('Sonda de temperatura de la tierra', 'Temperatura Superficie');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de humedad ambiental', 'Humedad Ambiental');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de luminosidad ambiental', 'Luminosidad');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de temperatura ambiental', 'Temperatura Ambiental');
INSERT INTO sensor_type(descripcion,nombre) values ('Sensor de Co2', 'Co2');
/* Carga de las acciones*/
INSERT INTO action(action_desc) values ('abrir el riego');
INSERT INTO action(action_desc) values ('cerrar el riego');
INSERT INTO action(action_desc) values ('mover la tierra');
INSERT INTO action(action_desc) values ('echar alimento');
INSERT INTO action(action_desc) values ('cambiar parámetros de configuración');
INSERT INTO action(action_desc) values ('mandar aviso');
