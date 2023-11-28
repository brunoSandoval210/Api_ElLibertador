-- Inserciones en la tabla 'servicio'
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-10-18', 'Wifi');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-10-20', 'Desayuno buffet');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (50, 'Activo', '2023-10-22', 'Mayordomo personal 24h');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (20, 'Activo', '2023-10-25', 'Desayuno gourmet en la habitación');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-10-30', 'Habitación Bar privado de licores premium');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (10, 'Activo', '2023-11-02', 'Acceso a Salas de Épocas');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (30, 'Activo', '2023-11-05', 'Atención personalizada de botones');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-11-10', 'Minibar surtido con vinos y champagne');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (20, 'Activo', '2023-11-15', 'Late check-out sujeto a disponibilidad');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (100, 'Activo', '2023-11-18', 'Cena para 2 en Restaurante Retro');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-11-21', 'Radio reloj vintage');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (5, 'Activo', '2023-11-25', 'Centro de Entretenimiento Antiguo');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-11-28', 'Descuento del 10% en Spa Vintage');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-12-02', 'Máquina de café express');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-12-05', 'Ambientación steampunk');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (12, 'Activo', '2023-12-08', 'Desayuno continental en la habitación');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-12-15', 'Balcón con vista panorámica');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-12-18', 'Acceso a terraza exterior privada');
INSERT INTO servicio (costo, estado, fecha_alta, nombre) VALUES (0, 'Activo', '2023-12-21', 'Conferencias');

-- Inserciones en la tabla 'usuario'
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(87654321, '2023-10-01', 987654320, 'Pérez', 'pass123', 'laura.perez@example.com', 'Activo', 'usuario1.jpg', 'Laura', 'Cliente');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(76543212, '2023-10-02', 987654321, 'Sánchez', 'securepass', 'roberto.sanchez@example.com', 'Activo', 'usuario2.jpg', 'Roberto', 'Cliente');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(65432123, '2023-10-03', 987654322, 'García', 'strongpass', 'maría.garcia@example.com', 'Activo', 'usuario3.jpg', 'María', 'Cliente');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(60871996, '2023-10-03', 987654322, 'Sandoval', 'admin', 'bruno.sandoval210@gmail.com', 'Activo', 'usuario3.jpg', 'Bruno', 'Administrador');
INSERT INTO `usuario` (`dni`, `fecha_alta`, `telefono`, `apellido`, `contrasena`, `email`, `estado`, `foto`, `nombre`, `tipo`) VALUES(47185293, '2023-10-03', 951478236, 'Fernandez', 'admin', 'afernandez@gmail.com', 'Activo', 'usuario3.jpg', 'Alvaro', 'Administrador');



INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(300, 2, '2023-11-22', NULL, 'Activo', 'suite-imperial-1.png', 'Suite Imperial', 'Suite de lujo caracterizada por decoración palaciega, mayordomo personal, jacuzzi privado y acceso a la Sala de Épocas.', 'Nuestra habitación de mayor clase, cuenta con un amplio dormitorio de suma elegancia y un salón con cortinados de terciopelo, rica tapicería, boiserie y molduras. Incluye un mayordomo de servicio permanente, jacuzzi privado con sales y un desayuno gourmet. También permite el acceso a la Sala de Épocas con música en vivo y shows de aires victorianos.');
INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(250, 2, '2023-11-22', NULL, 'Activo', 'suite-clasica-1.png', 'Suite Clásica', 'Hermosa suite decorada en estilo clásico, atención personalizada, mini bar de lujo y beneficios gastronómicos.', 'Su decoración clásica con mobiliario Luis XV, cuadros de época y arañas de cristal le dan un ambiente del más alto estilo. Cuenta con un minibar exclusivo con vinos importados y champagne, late check-out según disponibilidad y una cena para dos en nuestro Restaurante Retro con selección de menú.');
INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(180, 2, '2023-11-22', NULL, 'Activo', 'habitacion-retro-1.png', 'Habitación Retro', 'Habitación temática vintage, con radio reloj antiguo, acceso a entretenimiento vintage y descuentos en tratamientos spa.', 'Nuestras Habitaciones Retro poseen una deliciosa decoración vintage que evoca décadas pasadas. Mobiliario de mediados de siglo, radio reloj de época, papel tapiz floral y lámparas art déco componen su encanto old school. Los huéspedes obtienen un 10% de descuento en todos los tratamientos de nuestro Spa Vintage.');
INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(200, 1, '2023-11-22', NULL, 'Activo', 'loft-relojero-1.png', 'Loft Relojero', 'Moderno loft con temática steampunk y relojes de época, café express, desayuno continental a la habitación.', 'El Loft Relojero ofrece una estadía contemporánea con un toque steam. Sus paredes de ladrillo y vigas de acero con terminaciones oxidadas se combinan con antiguos relojes de pie y engranajes decorativos. El mobiliario moderno y una máquina de café express le dan un toque industrial. Los huéspedes pueden tener su desayuno continental servido en la intimacy de la suite.');
INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(220, 2, '2023-11-22', NULL, 'Activo', 'vista-al-ayer-1.png', 'Vista al Ayer', 'Habitación nostálgica con balcón y buena vista panorámica, decoración vintage.', 'Las habitaciones Vista al Ayer ubicadas en los pisos superiores son una invitación a mirar hacia atrás en el tiempo. Sus balcones y ventanales ofrecen hermosas vistas panorámicas mientras que en el interior nos rodea una cálida decoración de antaño con céfiro en las cortinas, un reloj de péndulo y mobiliario francés pintado a mano que le dará la bienvenida.');
INSERT INTO `categoria` (`precio_categoria`, `cant_personas`, `fecha_alta`, `fecha_baja`, `estado`, `foto`, `nombre`, `descripcion_breve`, `descripcion_larga`) VALUES(350, 2, '2023-11-22', NULL, 'Activo', 'atico-1.png', 'El Ático', 'Exclusivo ático de estilo señorial en el último piso, con mayordomo privado.', 'Situado en el último piso del edificio histórico, El Ático es la joya arquitectónica del Libertador. Un mayordomo personal estará al servicio permanente en esta suite señorial de corte inglés, con biblioteca privada, chimenea, fina cristalería y piezas de decoración que evocan la realeza europea. El acceso a la terraza superior le permitirá disfrutar de la ciudad desde las alturas mientras saborea una copa de nuestro mejor coñac.');

INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 3);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 4);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 5);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (1, 6);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 7);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 8);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 9);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (2, 10);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 11);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 12);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (3, 13);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 14);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 15);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (4, 16);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (5, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (5, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (5, 17);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 1);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 2);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 18);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 14);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 4);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 3);
INSERT INTO servicio_categoria (id_categoria, id_servicio)values (6, 19);


INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(150, '2023-10-16', NULL, 2, 101, 1, 'Disponible', 'Activo', 'habitacion1.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 102, 1, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(120, '2023-10-18', NULL, 2, 201, 2, 'Reservada', 'Activo', 'habitacion3.jpg', 'Juan López');
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(120, '2023-10-18', NULL, 2, 202, 2, 'Reservada', 'Activo', 'habitacion3.jpg', 'Juan López');
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 301, 3, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 302, 3, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 401, 4, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 402, 4, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 501, 5, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 502, 5, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 601, 6, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);
INSERT INTO `habitacion` (`costohabitacion`, `fecha_alta`, `fecha_baja`, `max_personas`, `num_habitacion`, `id_categoria_habitacion`, `disponibilidad`, `estado`, `foto`, `ocupante`) VALUES(100, '2023-10-17', NULL, 4, 602, 6, 'Disponible', 'Activo', 'habitacion2.jpg', NULL);

INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-05', 1);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-07', 2);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-10', 3);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);
INSERT INTO `reserva` (`fecha_reserva`, `id_usuario`) VALUES('2023-11-27', 5);

INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-02', '2023-12-01', 1, 1);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-04', '2023-12-03', 2, 2);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-06', '2023-12-05', 3, 3);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-08', '2023-12-07', 4, 4);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-10', '2023-12-09', 5, 5);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-12', '2023-12-11', 6, 6);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-14', '2023-12-13', 7, 7);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-16', '2023-12-15', 8, 8);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-18', '2023-12-17', 9, 9);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-20', '2023-12-19', 10, 10);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-22', '2023-12-21', 11, 11);
INSERT INTO `detalle_reserva` ( `chack_out`, `check_in`, `id_habitacion`, `reserva_id`) VALUES( '2023-12-24', '2023-12-23', 12, 12);
