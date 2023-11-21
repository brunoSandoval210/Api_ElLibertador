-- Inserciones en la tabla 'servicio'
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (10, 'Activo', '2023-10-18', 'Desayuno');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (15, 'Activo', '2023-10-20', 'Almuerzo');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (12, 'Activo', '2023-10-22', 'Cena');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (8, 'Activo', '2023-10-25', 'Merienda');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (18, 'Activo', '2023-10-30', 'Habitación Limpia');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (7, 'Activo', '2023-11-02', 'Servicio de Lavandería');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (20, 'Activo', '2023-11-05', 'Wi-Fi');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (9, 'Activo', '2023-11-10', 'Estacionamiento');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (14, 'Activo', '2023-11-15', 'Spa');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (11, 'Activo', '2023-11-18', 'Piscina');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (16, 'Activo', '2023-11-21', 'Gimnasio');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (13, 'Activo', '2023-11-25', 'Recepción 24/7');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (19, 'Activo', '2023-11-28', 'Servicio de Habitaciones');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (21, 'Activo', '2023-12-02', 'Seguridad');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (22, 'Activo', '2023-12-05', 'Excursiones Organizadas');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (17, 'Activo', '2023-12-08', 'Transporte al Aeropuerto');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (23, 'Activo', '2023-12-12', 'Alquiler de Bicicletas');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (24, 'Activo', '2023-12-15', 'Limpieza de Piscina');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (25, 'Activo', '2023-12-18', 'Entretenimiento en Vivo');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (30, 'Activo', '2023-12-21', 'Conferencias');

-- Inserciones en la tabla 'usuario'
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(87654321, '2023-10-01', 987654320, 'Pérez', 'pass123', 'laura.perez@example.com', 'Activo', 'usuario1.jpg', 'Laura', 'Cliente');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(76543212, '2023-10-02', 987654321, 'Sánchez', 'securepass', 'roberto.sanchez@example.com', 'Activo', 'usuario2.jpg', 'Roberto', 'Cliente');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(65432123, '2023-10-03', 987654322, 'García', 'strongpass', 'maría.garcia@example.com', 'Activo', 'usuario3.jpg', 'María', 'Cliente');


INSERT INTO `categoria` (`cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`) VALUES(2, '2023-10-15', NULL, 'Activo', 'categoria1.jpg', 'Suite de Lujo');
INSERT INTO `categoria` (`cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`) VALUES(3, '2023-10-16', NULL, 'Activo', 'categoria2.jpg', 'Habitación Familiar');
INSERT INTO `categoria` (`cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`) VALUES(2, '2023-10-17', NULL, 'Activo', 'categoria3.jpg', 'Habitación Doble');
INSERT INTO `categoria` (`cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`) VALUES(1, '2023-10-18', NULL, 'Inactivo', 'categoria4.jpg', 'Habitación Individual');


INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1,10);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1,11);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 2); 
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 3); 
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 4); 

INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(150, '2023-10-16', NULL, 2, 101, 1, 'Disponible', 'Activo', 'habitacion1.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 201, 2, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(120, '2023-10-18', NULL, 2, 301, 3, 'Reservada', 'Activo', 'habitacion3.jpg', 'Juan López');

INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-05', 1);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-07', 2);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-10', 3);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-11-07', '2023-11-12', 2, 2);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-11-05', '2023-11-10', 1, 1);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-11-10', '2023-11-15', 3, 3);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-11-16', '2023-11-20', 1, 3);
