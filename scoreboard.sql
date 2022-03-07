-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2021 a las 22:35:39
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `superbreakem`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `scoreboard`
--

CREATE TABLE `scoreboard` (
  `Id_Score` int(11) NOT NULL,
  `Score` bigint(20) NOT NULL DEFAULT 0,
  `Name` varchar(4) NOT NULL DEFAULT 'ANON'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `scoreboard`
--

INSERT INTO `scoreboard` (`Id_Score`, `Score`, `Name`) VALUES
(1, 1, 'ANON'),
(2, 2, 'ANON'),
(3, 3, 'ANON'),
(4, 4, 'ANON'),
(5, 5, 'ANON'),
(6, 6, 'ANON'),
(7, 7, 'ANON'),
(8, 8, 'ANON'),
(9, 9, 'ANON'),
(10, 10, 'ANON'),
(11, 11, 'ANON'),
(12, 12, 'ANON'),
(13, 13, 'ANON'),
(14, 0, 'ANON'),
(15, 0, 'ANON'),
(16, 0, 'ANON'),
(17, 0, 'ANON'),
(18, 0, 'ANON'),
(19, 0, 'ANON'),
(20, 0, 'ANON'),
(21, 45, 'mau');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `scoreboard`
--
ALTER TABLE `scoreboard`
  ADD PRIMARY KEY (`Id_Score`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `scoreboard`
--
ALTER TABLE `scoreboard`
  MODIFY `Id_Score` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
