-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-04-2021 a las 00:26:46
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spmn_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cant_compra`
--

CREATE TABLE `cant_compra` (
  `producto` int(6) NOT NULL,
  `recibo` int(6) NOT NULL,
  `cantidad` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cant_venta`
--

CREATE TABLE `cant_venta` (
  `factura_venta` int(10) NOT NULL,
  `producto` int(6) NOT NULL,
  `cantidad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `cedula` int(11) NOT NULL,
  `sueldo_basico` decimal(10,2) NOT NULL,
  `arl` decimal(10,2) NOT NULL,
  `eps` decimal(10,2) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_venta`
--

CREATE TABLE `factura_venta` (
  `id` int(10) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(128) NOT NULL,
  `total_bruto` decimal(10,2) NOT NULL,
  `impuestos` decimal(10,2) NOT NULL,
  `total_pagar` decimal(10,2) NOT NULL,
  `cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuesto`
--

CREATE TABLE `impuesto` (
  `id` int(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `entidad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `producto` int(6) NOT NULL,
  `tienda` int(10) NOT NULL,
  `cantidad` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_impuesto`
--

CREATE TABLE `pago_impuesto` (
  `impuesto` int(10) NOT NULL,
  `tienda` int(10) NOT NULL,
  `costo` decimal(8,2) NOT NULL,
  `fecha_limite` date NOT NULL,
  `fecha_pago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_nomina`
--

CREATE TABLE `pago_nomina` (
  `empleado` int(11) NOT NULL,
  `tienda` int(10) NOT NULL,
  `diasTrab` int(2) NOT NULL,
  `auxTrans` decimal(10,2) NOT NULL,
  `liquidacion` decimal(10,2) NOT NULL,
  `pension` decimal(10,2) NOT NULL,
  `netoPagado` decimal(10,2) NOT NULL,
  `fechaPago` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago_servicio`
--

CREATE TABLE `pago_servicio` (
  `tienda` int(10) NOT NULL,
  `servicio` int(10) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `fechaLimite` date NOT NULL,
  `fechaPago` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(6) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tamano` varchar(45) NOT NULL,
  `presentacion` varchar(45) NOT NULL,
  `unidad_medida` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `costo` decimal(10,2) NOT NULL,
  `precio` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `nit` int(15) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `cel` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo`
--

CREATE TABLE `recibo` (
  `id` int(6) NOT NULL,
  `fecha` date NOT NULL,
  `total_recibo` decimal(10,2) NOT NULL,
  `descripcion` varchar(128) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `fecha_pago` date NOT NULL,
  `proveedor` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `cargo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `cargo`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id` int(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(99) NOT NULL,
  `telefono` int(15) NOT NULL,
  `entidad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE `tienda` (
  `id` int(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` int(15) NOT NULL,
  `caja_menor` decimal(8,2) NOT NULL,
  `deudas` decimal(8,2) NOT NULL,
  `saldo` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `telefono` bigint(15) NOT NULL,
  `tienda` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `username`, `correo`, `contrasena`, `telefono`, `tienda`) VALUES
(101, 'Marlyn', '101', 'marlyn@nemo.com', '101', 312578, NULL),
(102, 'Dory', '102', 'dory@nemo.com', 'password', 3125, NULL),
(103, 'nemo', '103', 'nemo@nemo.com', 'raton', 2515618, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_rol`
--

CREATE TABLE `usuario_rol` (
  `usuario` int(11) NOT NULL,
  `rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario_rol`
--

INSERT INTO `usuario_rol` (`usuario`, `rol`) VALUES
(101, 1),
(102, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cant_compra`
--
ALTER TABLE `cant_compra`
  ADD PRIMARY KEY (`producto`,`recibo`),
  ADD KEY `fk_cant_compra_recibo_idx` (`recibo`),
  ADD KEY `fk_cant_compra_producto_idx` (`producto`);

--
-- Indices de la tabla `cant_venta`
--
ALTER TABLE `cant_venta`
  ADD PRIMARY KEY (`factura_venta`,`producto`),
  ADD KEY `fk_cant_venta_producto_idx` (`producto`),
  ADD KEY `fk_cant_venta_venta_idx` (`factura_venta`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `fk_empleado_usuario_idx` (`cedula`);

--
-- Indices de la tabla `factura_venta`
--
ALTER TABLE `factura_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_factura_usuario_idx` (`cliente`);

--
-- Indices de la tabla `impuesto`
--
ALTER TABLE `impuesto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`producto`,`tienda`),
  ADD KEY `fk_inventario_tienda_idx` (`tienda`),
  ADD KEY `fk_inventario_producto_idx` (`producto`);

--
-- Indices de la tabla `pago_impuesto`
--
ALTER TABLE `pago_impuesto`
  ADD PRIMARY KEY (`impuesto`,`tienda`),
  ADD KEY `fk_pago_impuesto_tienda_idx` (`tienda`),
  ADD KEY `fk_pago_impuesto_impuesto_idx` (`impuesto`);

--
-- Indices de la tabla `pago_nomina`
--
ALTER TABLE `pago_nomina`
  ADD PRIMARY KEY (`empleado`,`tienda`),
  ADD KEY `fk_pago_nomina_tienda_idx` (`tienda`),
  ADD KEY `fk_pago_nomina_empleado_idx` (`empleado`);

--
-- Indices de la tabla `pago_servicio`
--
ALTER TABLE `pago_servicio`
  ADD PRIMARY KEY (`tienda`,`servicio`),
  ADD KEY `fk_pago_servicio_servicio_idx` (`servicio`),
  ADD KEY `fk_pago_servicio_tienda_idx` (`tienda`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`nit`);

--
-- Indices de la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_recibo_proveedor_idx` (`proveedor`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tienda`
--
ALTER TABLE `tienda`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `fk_usuario_tienda_idx` (`tienda`);

--
-- Indices de la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD PRIMARY KEY (`usuario`,`rol`),
  ADD KEY `fk_usuario_rol_rol_idx` (`rol`),
  ADD KEY `fk_usuario_rol_usuario_idx` (`usuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cant_compra`
--
ALTER TABLE `cant_compra`
  ADD CONSTRAINT `fk_cant_compra_prodcuto` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cant_compra_recibo` FOREIGN KEY (`recibo`) REFERENCES `recibo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cant_venta`
--
ALTER TABLE `cant_venta`
  ADD CONSTRAINT `fk_cant_venta_producto` FOREIGN KEY (`factura_venta`) REFERENCES `factura_venta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cant_venta_venta` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_empleado_usuario` FOREIGN KEY (`cedula`) REFERENCES `usuario` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura_venta`
--
ALTER TABLE `factura_venta`
  ADD CONSTRAINT `fk_factura_usuario` FOREIGN KEY (`cliente`) REFERENCES `usuario` (`cedula`);

--
-- Filtros para la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `fk_inventario_producto` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inventario_tienda` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago_impuesto`
--
ALTER TABLE `pago_impuesto`
  ADD CONSTRAINT `fk_pago_impuesto_impuesto` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pago_impuesto_tienda` FOREIGN KEY (`impuesto`) REFERENCES `impuesto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago_nomina`
--
ALTER TABLE `pago_nomina`
  ADD CONSTRAINT `fk_pago_nomina_empleado` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pago_nomina_tienda` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago_servicio`
--
ALTER TABLE `pago_servicio`
  ADD CONSTRAINT `fk_pago_servicio_servicio` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pago_servicio_tienda` FOREIGN KEY (`servicio`) REFERENCES `servicio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recibo`
--
ALTER TABLE `recibo`
  ADD CONSTRAINT `fk_recibo_proveedor` FOREIGN KEY (`proveedor`) REFERENCES `proveedor` (`nit`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tienda` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`);

--
-- Filtros para la tabla `usuario_rol`
--
ALTER TABLE `usuario_rol`
  ADD CONSTRAINT `fk_usuario_rol_rol` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_rol_usuario` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
