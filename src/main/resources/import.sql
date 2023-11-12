-- Inserciones en la tabla 'servicio'
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('10', 'Activo', '2023-10-18', 'Desayuno');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('15', 'Activo', '2023-10-20', 'Almuerzo');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('12', 'Activo', '2023-10-22', 'Cena');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('8', 'Activo', '2023-10-25', 'Merienda');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('18', 'Activo', '2023-10-30', 'Habitación Limpia');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('7', 'Inactivo', '2023-11-02', 'Servicio de Lavandería');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('20', 'Activo', '2023-11-05', 'Wi-Fi');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('9', 'Activo', '2023-11-10', 'Estacionamiento');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('14', 'Activo', '2023-11-15', 'Spa');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('11', 'Activo', '2023-11-18', 'Piscina');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('16', 'Activo', '2023-11-21', 'Gimnasio');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('13', 'Activo', '2023-11-25', 'Recepción 24/7');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('19', 'Activo', '2023-11-28', 'Servicio de Habitaciones');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('21', 'Activo', '2023-12-02', 'Seguridad');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('22', 'Activo', '2023-12-05', 'Excursiones Organizadas');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('17', 'Inactivo', '2023-12-08', 'Transporte al Aeropuerto');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('23', 'Activo', '2023-12-12', 'Alquiler de Bicicletas');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('24', 'Activo', '2023-12-15', 'Limpieza de Piscina');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('25', 'Activo', '2023-12-18', 'Entretenimiento en Vivo');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES ('30', 'Activo', '2023-12-21', 'Conferencias');

-- Inserciones en la tabla 'usuario'
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('12345678', '2023-10-07', '987654321', 'López', 'password123', 'juan.lopez@example.com', 'Activo', 'Juan', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('23456789', '2023-10-10', '987654322', 'Gómez', 'secret123', 'maria.gomez@example.com', 'Activo', 'María', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('34567890', '2023-10-15', '987654323', 'Rodríguez', 'securepass', 'carlos.rodriguez@example.com', 'Inactivo', 'Carlos', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('56789012', '2023-10-25', '987654325', 'Martínez', 'topsecret', 'pedro.martinez@example.com', 'Activo', 'Pedro', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('67890123', '2023-10-30', '987654326', 'Fernández', 'strongpass', 'ana.fernandez@example.com', 'Inactivo', 'Ana', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('78901234', '2023-11-02', '987654327', 'García', 'pass12345', 'oscar.garcia@example.com', 'Activo', 'Oscar', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('89012345', '2023-11-05', '987654328', 'Díaz', 'mypassword', 'lucia.diaz@example.com', 'Activo', 'Lucía', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('90123456', '2023-11-10', '987654329', 'Hernández', 'securepassword', 'andres.hernandez@example.com', 'Inactivo', 'Andrés', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('12340123', '2023-11-15', '987654330', 'Sánchez', 'letmein', 'patricia.sanchez@example.com', 'Activo', 'Patricia', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('23451234', '2023-11-18', '987654331', 'López', 'password123', 'raul.lopez@example.com', 'Inactivo', 'Raúl', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('34562345', '2023-11-21', '987654332', 'Gómez', 'secret123', 'carolina.gomez@example.com', 'Activo', 'Carolina', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('45673456', '2023-11-25', '987654333', 'Rodríguez', 'securepass', 'jose.rodriguez@example.com', 'Activo', 'José', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('56784567', '2023-11-28', '987654334', 'Pérez', 'mysecretpass', 'patricio.perez@example.com', 'Inactivo', 'Patricio', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('67895678', '2023-12-02', '987654335', 'Martínez', 'topsecret', 'silvia.martinez@example.com', 'Activo', 'Silvia', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('78906789', '2023-12-05', '987654336', 'Fernández', 'strongpass', 'diego.fernandez@example.com', 'Activo', 'Diego', 'Cliente');
INSERT INTO usuario (dni, fecha_alta, telefono, apellido, contrasena, email, estado, nombre, tipo) VALUES ('89017890', '2023-12-08', '987654337', 'García', 'pass12345', 'rosa.garcia@example.com', 'Inactivo', 'Rosa', 'Cliente');

