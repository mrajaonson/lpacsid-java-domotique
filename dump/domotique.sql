-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : mysql:3306
-- Généré le : lun. 06 mars 2023 à 00:39
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `domotique`
--
CREATE DATABASE IF NOT EXISTS `domotique` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `domotique`;

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

DROP TABLE IF EXISTS `equipement`;
CREATE TABLE `equipement` (
  `id` int NOT NULL,
  `utilisateur` varchar(20) NOT NULL,
  `piece` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `valeur` int NOT NULL,
  `estConnecte` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `equipement`
--

INSERT INTO `equipement` (`id`, `utilisateur`, `piece`, `nom`, `type`, `valeur`, `estConnecte`) VALUES
(4, 'admin', 'Chambre 1', 'Lampe de chevet 1', 'lumiere', 1, 1),
(17, 'admin', 'Chambre 1', 'Lampe de chevet 2', 'lumiere', 0, 1),
(21, 'admin', 'Chambre 1', 'Lumière', 'lumiere', 1, 1),
(9, 'admin', 'Chambre 1', 'Radiateur 1', 'radiateur', 19, 1),
(19, 'admin', 'Chambre 1', 'Volet', 'volet', 0, 1),
(22, 'admin', 'Chambre 2', 'Lumière', 'lumiere', 1, 1),
(23, 'admin', 'Chambre 2', 'Radiateur', 'radiateur', 19, 1),
(20, 'admin', 'Chambre 2', 'Volet', 'volet', 0, 1),
(18, 'admin', 'Cuisine', 'Radiateur', 'radiateur', 18, 1),
(16, 'admin', 'Garage', 'Porte', 'porte-garage', 0, 1),
(8, 'admin', 'Salon', 'Baie vitrée', 'volet', 0, 1),
(6, 'admin', 'Salon', 'Lustre 2', 'lumiere', 0, 1),
(10, 'admin', 'Salon', 'Radiateur 1', 'radiateur', 21, 1);

-- --------------------------------------------------------

--
-- Structure de la table `meteodaily`
--

DROP TABLE IF EXISTS `meteodaily`;
CREATE TABLE `meteodaily` (
  `timezone` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `temperaturemax` double NOT NULL,
  `temperaturemin` double NOT NULL,
  `sunrise` varchar(20) NOT NULL,
  `sunset` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `meteodaily`
--

INSERT INTO `meteodaily` (`timezone`, `time`, `temperaturemax`, `temperaturemin`, `sunrise`, `sunset`) VALUES
('Europe/Paris', '2023-02-23', 10.8, 6, '07:42', '18:25'),
('Europe/Paris', '2023-02-24', 10, 5.4, '07:40', '18:26'),
('Europe/Paris', '2023-02-25', 7.3, 1.8, '07:38', '18:28'),
('Europe/Paris', '2023-02-26', 5.2, 0.2, '07:36', '18:30'),
('Europe/Paris', '2023-02-27', 6.7, 0.1, '07:35', '18:31'),
('Europe/Paris', '2023-02-28', 5.6, -0.7, '07:33', '18:33'),
('Europe/Paris', '2023-03-01', 7.2, -0.6, '07:31', '18:34'),
('Europe/Paris', '2023-03-02', 9.2, -0.2, '07:29', '18:36'),
('Europe/Paris', '2023-03-03', 8.5, 1.3, '07:27', '18:37'),
('Europe/Paris', '2023-03-04', 9.4, 0.8, '07:25', '18:39'),
('Europe/Paris', '2023-03-05', 8.5, 4.3, '07:23', '18:41'),
('Europe/Paris', '2023-03-06', 8.7, 1.5, '07:21', '18:42'),
('Europe/Paris', '2023-03-07', 8.4, 1.7, '07:19', '18:44'),
('Europe/Paris', '2023-03-08', 12.9, 2.9, '07:17', '18:45'),
('Europe/Paris', '2023-03-09', 8.1, 2.4, '07:15', '18:47');

-- --------------------------------------------------------

--
-- Structure de la table `meteohourly`
--

DROP TABLE IF EXISTS `meteohourly`;
CREATE TABLE `meteohourly` (
  `timezone` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `temperature` double NOT NULL,
  `precipitation` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `meteohourly`
--

INSERT INTO `meteohourly` (`timezone`, `time`, `temperature`, `precipitation`) VALUES
('Europe/Paris', '2023-02-23T00:00', 8.7, 0),
('Europe/Paris', '2023-02-23T01:00', 8.4, 0),
('Europe/Paris', '2023-02-23T02:00', 8.1, 0),
('Europe/Paris', '2023-02-23T03:00', 7.9, 0),
('Europe/Paris', '2023-02-23T04:00', 7.2, 0),
('Europe/Paris', '2023-02-23T05:00', 6.6, 0),
('Europe/Paris', '2023-02-23T06:00', 6, 0),
('Europe/Paris', '2023-02-23T07:00', 6.3, 0),
('Europe/Paris', '2023-02-23T08:00', 6.9, 0),
('Europe/Paris', '2023-02-23T09:00', 7.2, 0),
('Europe/Paris', '2023-02-23T10:00', 7.5, 0),
('Europe/Paris', '2023-02-23T11:00', 7.4, 0),
('Europe/Paris', '2023-02-23T12:00', 7.7, 0),
('Europe/Paris', '2023-02-23T13:00', 9.3, 0),
('Europe/Paris', '2023-02-23T14:00', 9.6, 0),
('Europe/Paris', '2023-02-23T15:00', 10.4, 0),
('Europe/Paris', '2023-02-23T16:00', 10.4, 0),
('Europe/Paris', '2023-02-23T17:00', 10.8, 0),
('Europe/Paris', '2023-02-23T18:00', 10.6, 0),
('Europe/Paris', '2023-02-23T19:00', 10.6, 0),
('Europe/Paris', '2023-02-23T20:00', 10.1, 0),
('Europe/Paris', '2023-02-23T21:00', 9.5, 0),
('Europe/Paris', '2023-02-23T22:00', 8.9, 0),
('Europe/Paris', '2023-02-23T23:00', 8.1, 0),
('Europe/Paris', '2023-02-24T00:00', 7.4, 0),
('Europe/Paris', '2023-02-24T01:00', 6.7, 0),
('Europe/Paris', '2023-02-24T02:00', 6.4, 0),
('Europe/Paris', '2023-02-24T03:00', 6.5, 0),
('Europe/Paris', '2023-02-24T04:00', 6.4, 0),
('Europe/Paris', '2023-02-24T05:00', 6.6, 0),
('Europe/Paris', '2023-02-24T06:00', 6.3, 0),
('Europe/Paris', '2023-02-24T07:00', 5.6, 0),
('Europe/Paris', '2023-02-24T08:00', 5.6, 0),
('Europe/Paris', '2023-02-24T09:00', 5.4, 0),
('Europe/Paris', '2023-02-24T10:00', 5.5, 0),
('Europe/Paris', '2023-02-24T11:00', 5.9, 0),
('Europe/Paris', '2023-02-24T12:00', 6.2, 0),
('Europe/Paris', '2023-02-24T13:00', 7.2, 0),
('Europe/Paris', '2023-02-24T14:00', 8.2, 0),
('Europe/Paris', '2023-02-24T15:00', 8.9, 0),
('Europe/Paris', '2023-02-24T16:00', 9.9, 0),
('Europe/Paris', '2023-02-24T17:00', 10, 0),
('Europe/Paris', '2023-02-24T18:00', 9.6, 0),
('Europe/Paris', '2023-02-24T19:00', 8.8, 0),
('Europe/Paris', '2023-02-24T20:00', 8.3, 0),
('Europe/Paris', '2023-02-24T21:00', 8.3, 0),
('Europe/Paris', '2023-02-24T22:00', 7.5, 0),
('Europe/Paris', '2023-02-24T23:00', 6.8, 0),
('Europe/Paris', '2023-02-25T00:00', 6.2, 0),
('Europe/Paris', '2023-02-25T01:00', 5.7, 0),
('Europe/Paris', '2023-02-25T02:00', 5.5, 0),
('Europe/Paris', '2023-02-25T03:00', 5.1, 0),
('Europe/Paris', '2023-02-25T04:00', 4.7, 0),
('Europe/Paris', '2023-02-25T05:00', 4.3, 0),
('Europe/Paris', '2023-02-25T06:00', 3.7, 0),
('Europe/Paris', '2023-02-25T07:00', 3.4, 0),
('Europe/Paris', '2023-02-25T08:00', 2, 0),
('Europe/Paris', '2023-02-25T09:00', 1.8, 0),
('Europe/Paris', '2023-02-25T10:00', 2.3, 0),
('Europe/Paris', '2023-02-25T11:00', 3.9, 0),
('Europe/Paris', '2023-02-25T12:00', 6.5, 0),
('Europe/Paris', '2023-02-25T13:00', 6.9, 0),
('Europe/Paris', '2023-02-25T14:00', 7.3, 0),
('Europe/Paris', '2023-02-25T15:00', 7.3, 0),
('Europe/Paris', '2023-02-25T16:00', 7.1, 0),
('Europe/Paris', '2023-02-25T17:00', 6.9, 0),
('Europe/Paris', '2023-02-25T18:00', 6.2, 0),
('Europe/Paris', '2023-02-25T19:00', 5.1, 0),
('Europe/Paris', '2023-02-25T20:00', 4.9, 0),
('Europe/Paris', '2023-02-25T21:00', 4.2, 0),
('Europe/Paris', '2023-02-25T22:00', 3.5, 0),
('Europe/Paris', '2023-02-25T23:00', 2.8, 0),
('Europe/Paris', '2023-02-26T00:00', 3.8, 0),
('Europe/Paris', '2023-02-26T01:00', 3.4, 0),
('Europe/Paris', '2023-02-26T02:00', 2.7, 0),
('Europe/Paris', '2023-02-26T03:00', 1.9, 0),
('Europe/Paris', '2023-02-26T04:00', 1.7, 0),
('Europe/Paris', '2023-02-26T05:00', 1.4, 0),
('Europe/Paris', '2023-02-26T06:00', 1.1, 0),
('Europe/Paris', '2023-02-26T07:00', 0.4, 0),
('Europe/Paris', '2023-02-26T08:00', 0.2, 0),
('Europe/Paris', '2023-02-26T09:00', 0.9, 0),
('Europe/Paris', '2023-02-26T10:00', 2.1, 0),
('Europe/Paris', '2023-02-26T11:00', 3.1, 0),
('Europe/Paris', '2023-02-26T12:00', 3.6, 0),
('Europe/Paris', '2023-02-26T13:00', 4.8, 0),
('Europe/Paris', '2023-02-26T14:00', 4.8, 0),
('Europe/Paris', '2023-02-26T15:00', 5.2, 0),
('Europe/Paris', '2023-02-26T16:00', 4.9, 0),
('Europe/Paris', '2023-02-26T17:00', 4.6, 0),
('Europe/Paris', '2023-02-26T18:00', 3.8, 0),
('Europe/Paris', '2023-02-26T19:00', 3.2, 0),
('Europe/Paris', '2023-02-26T20:00', 2.5, 0),
('Europe/Paris', '2023-02-26T21:00', 2.2, 0),
('Europe/Paris', '2023-02-26T22:00', 1.9, 0),
('Europe/Paris', '2023-02-26T23:00', 1.7, 0),
('Europe/Paris', '2023-02-27T00:00', 1.5, 0),
('Europe/Paris', '2023-02-27T01:00', 1.4, 0),
('Europe/Paris', '2023-02-27T02:00', 1.2, 0),
('Europe/Paris', '2023-02-27T03:00', 1, 0),
('Europe/Paris', '2023-02-27T04:00', 0.7, 0),
('Europe/Paris', '2023-02-27T05:00', 0.5, 0),
('Europe/Paris', '2023-02-27T06:00', 0.3, 0),
('Europe/Paris', '2023-02-27T07:00', 0.1, 0),
('Europe/Paris', '2023-02-27T08:00', 0.2, 0),
('Europe/Paris', '2023-02-27T09:00', 0.6, 0),
('Europe/Paris', '2023-02-27T10:00', 1.4, 0),
('Europe/Paris', '2023-02-27T11:00', 2.6, 0),
('Europe/Paris', '2023-02-27T12:00', 3.9, 0),
('Europe/Paris', '2023-02-27T13:00', 5.1, 0),
('Europe/Paris', '2023-02-27T14:00', 5.9, 0),
('Europe/Paris', '2023-02-27T15:00', 6.5, 0),
('Europe/Paris', '2023-02-27T16:00', 6.7, 0),
('Europe/Paris', '2023-02-27T17:00', 6.5, 0),
('Europe/Paris', '2023-02-27T18:00', 5.9, 0),
('Europe/Paris', '2023-02-27T19:00', 5.1, 0),
('Europe/Paris', '2023-02-27T20:00', 4, 0),
('Europe/Paris', '2023-02-27T21:00', 3.3, 0),
('Europe/Paris', '2023-02-27T22:00', 2.7, 0),
('Europe/Paris', '2023-02-27T23:00', 2.1, 0),
('Europe/Paris', '2023-02-28T00:00', 2.2, 0),
('Europe/Paris', '2023-02-28T01:00', 1.7, 0),
('Europe/Paris', '2023-02-28T02:00', 1.1, 0),
('Europe/Paris', '2023-02-28T03:00', 0.6, 0),
('Europe/Paris', '2023-02-28T04:00', 0.3, 0),
('Europe/Paris', '2023-02-28T05:00', 0, 0),
('Europe/Paris', '2023-02-28T06:00', -0.3, 0),
('Europe/Paris', '2023-02-28T07:00', -0.6, 0),
('Europe/Paris', '2023-02-28T08:00', -0.7, 0),
('Europe/Paris', '2023-02-28T09:00', -0.3, 0),
('Europe/Paris', '2023-02-28T10:00', 1, 0),
('Europe/Paris', '2023-02-28T11:00', 2.8, 0),
('Europe/Paris', '2023-02-28T12:00', 3.7, 0),
('Europe/Paris', '2023-02-28T13:00', 4.8, 0),
('Europe/Paris', '2023-02-28T14:00', 5.1, 0),
('Europe/Paris', '2023-02-28T15:00', 5.5, 0),
('Europe/Paris', '2023-02-28T16:00', 5.6, 0),
('Europe/Paris', '2023-02-28T17:00', 5.5, 0),
('Europe/Paris', '2023-02-28T18:00', 5.1, 0),
('Europe/Paris', '2023-02-28T19:00', 4.5, 0),
('Europe/Paris', '2023-02-28T20:00', 4.1, 0),
('Europe/Paris', '2023-02-28T21:00', 3.2, 0),
('Europe/Paris', '2023-02-28T22:00', 2.2, 0),
('Europe/Paris', '2023-02-28T23:00', 1.7, 0),
('Europe/Paris', '2023-03-01T00:00', 1.5, 0),
('Europe/Paris', '2023-03-01T01:00', 0.9, 0),
('Europe/Paris', '2023-03-01T02:00', 0.8, 0),
('Europe/Paris', '2023-03-01T03:00', 0.6, 0),
('Europe/Paris', '2023-03-01T04:00', 0.3, 0),
('Europe/Paris', '2023-03-01T05:00', 0.1, 0),
('Europe/Paris', '2023-03-01T06:00', -0.2, 0),
('Europe/Paris', '2023-03-01T07:00', -0.6, 0),
('Europe/Paris', '2023-03-01T08:00', -0.4, 0),
('Europe/Paris', '2023-03-01T09:00', 0.2, 0),
('Europe/Paris', '2023-03-01T10:00', 1.4, 0),
('Europe/Paris', '2023-03-01T11:00', 3, 0),
('Europe/Paris', '2023-03-01T12:00', 4.3, 0),
('Europe/Paris', '2023-03-01T13:00', 5.4, 0),
('Europe/Paris', '2023-03-01T14:00', 6.4, 0),
('Europe/Paris', '2023-03-01T15:00', 7, 0),
('Europe/Paris', '2023-03-01T16:00', 7.2, 0),
('Europe/Paris', '2023-03-01T17:00', 6.9, 0),
('Europe/Paris', '2023-03-01T18:00', 6.2, 0),
('Europe/Paris', '2023-03-01T19:00', 5.3, 0),
('Europe/Paris', '2023-03-01T20:00', 4.1, 0),
('Europe/Paris', '2023-03-01T21:00', 3.3, 0),
('Europe/Paris', '2023-03-01T22:00', 2.7, 0),
('Europe/Paris', '2023-03-01T23:00', 2.2, 0),
('Europe/Paris', '2023-03-02T00:00', 2.2, 0),
('Europe/Paris', '2023-03-02T01:00', 2, 0),
('Europe/Paris', '2023-03-02T02:00', 1.4, 0),
('Europe/Paris', '2023-03-02T03:00', 0.9, 0),
('Europe/Paris', '2023-03-02T04:00', 0.4, 0),
('Europe/Paris', '2023-03-02T05:00', 0.2, 0),
('Europe/Paris', '2023-03-02T06:00', -0.1, 0),
('Europe/Paris', '2023-03-02T07:00', -0.2, 0),
('Europe/Paris', '2023-03-02T08:00', 0.1, 0),
('Europe/Paris', '2023-03-02T09:00', 0.6, 0),
('Europe/Paris', '2023-03-02T10:00', 1.6, 0),
('Europe/Paris', '2023-03-02T11:00', 3.2, 0),
('Europe/Paris', '2023-03-02T12:00', 5, 0),
('Europe/Paris', '2023-03-02T13:00', 6.7, 0),
('Europe/Paris', '2023-03-02T14:00', 7.8, 0),
('Europe/Paris', '2023-03-02T15:00', 8.9, 0),
('Europe/Paris', '2023-03-02T16:00', 9.2, 0),
('Europe/Paris', '2023-03-02T17:00', 9.1, 0),
('Europe/Paris', '2023-03-02T18:00', 8.5, 0),
('Europe/Paris', '2023-03-02T19:00', 7.8, 0),
('Europe/Paris', '2023-03-02T20:00', 6.7, 0),
('Europe/Paris', '2023-03-02T21:00', 5.8, 0),
('Europe/Paris', '2023-03-02T22:00', 5, 0),
('Europe/Paris', '2023-03-02T23:00', 4.3, 0),
('Europe/Paris', '2023-03-03T00:00', 4.3, 0),
('Europe/Paris', '2023-03-03T01:00', 3.7, 0),
('Europe/Paris', '2023-03-03T02:00', 3.2, 0),
('Europe/Paris', '2023-03-03T03:00', 2.7, 0),
('Europe/Paris', '2023-03-03T04:00', 2.2, 0),
('Europe/Paris', '2023-03-03T05:00', 1.8, 0),
('Europe/Paris', '2023-03-03T06:00', 1.5, 0),
('Europe/Paris', '2023-03-03T07:00', 1.3, 0),
('Europe/Paris', '2023-03-03T08:00', 1.5, 0),
('Europe/Paris', '2023-03-03T09:00', 1.7, 0),
('Europe/Paris', '2023-03-03T10:00', 1.9, 0),
('Europe/Paris', '2023-03-03T11:00', 3.3, 0),
('Europe/Paris', '2023-03-03T12:00', 5.1, 0),
('Europe/Paris', '2023-03-03T13:00', 6.6, 0),
('Europe/Paris', '2023-03-03T14:00', 7.7, 0),
('Europe/Paris', '2023-03-03T15:00', 8.4, 0),
('Europe/Paris', '2023-03-03T16:00', 8.5, 0),
('Europe/Paris', '2023-03-03T17:00', 8.1, 0),
('Europe/Paris', '2023-03-03T18:00', 7.3, 0),
('Europe/Paris', '2023-03-03T19:00', 6.3, 0),
('Europe/Paris', '2023-03-03T20:00', 5.3, 0),
('Europe/Paris', '2023-03-03T21:00', 4.6, 0),
('Europe/Paris', '2023-03-03T22:00', 4, 0),
('Europe/Paris', '2023-03-03T23:00', 3.4, 0),
('Europe/Paris', '2023-03-04T00:00', 2.8, 0),
('Europe/Paris', '2023-03-04T01:00', 2.6, 0),
('Europe/Paris', '2023-03-04T02:00', 2.2, 0),
('Europe/Paris', '2023-03-04T03:00', 1.8, 0),
('Europe/Paris', '2023-03-04T04:00', 1.4, 0),
('Europe/Paris', '2023-03-04T05:00', 1.1, 0),
('Europe/Paris', '2023-03-04T06:00', 1.2, 0),
('Europe/Paris', '2023-03-04T07:00', 0.8, 0),
('Europe/Paris', '2023-03-04T08:00', 1.3, 0),
('Europe/Paris', '2023-03-04T09:00', 2.2, 0),
('Europe/Paris', '2023-03-04T10:00', 3.8, 0),
('Europe/Paris', '2023-03-04T11:00', 6, 0),
('Europe/Paris', '2023-03-04T12:00', 7.4, 0),
('Europe/Paris', '2023-03-04T13:00', 8.2, 0),
('Europe/Paris', '2023-03-04T14:00', 8.9, 0),
('Europe/Paris', '2023-03-04T15:00', 9.4, 0),
('Europe/Paris', '2023-03-04T16:00', 9.3, 0),
('Europe/Paris', '2023-03-04T17:00', 9, 0),
('Europe/Paris', '2023-03-04T18:00', 8.4, 0),
('Europe/Paris', '2023-03-04T19:00', 7.6, 0),
('Europe/Paris', '2023-03-04T20:00', 6.8, 0),
('Europe/Paris', '2023-03-04T21:00', 6.4, 0),
('Europe/Paris', '2023-03-04T22:00', 6, 0),
('Europe/Paris', '2023-03-04T23:00', 5.8, 0),
('Europe/Paris', '2023-03-05T00:00', 4.3, 0),
('Europe/Paris', '2023-03-05T01:00', 6.3, 0),
('Europe/Paris', '2023-03-05T02:00', 5.9, 0),
('Europe/Paris', '2023-03-05T03:00', 6, 0),
('Europe/Paris', '2023-03-05T04:00', 6.1, 0),
('Europe/Paris', '2023-03-05T05:00', 5.8, 0),
('Europe/Paris', '2023-03-05T06:00', 5.4, 0),
('Europe/Paris', '2023-03-05T07:00', 6.3, 0),
('Europe/Paris', '2023-03-05T08:00', 6.9, 0),
('Europe/Paris', '2023-03-05T09:00', 7.2, 0),
('Europe/Paris', '2023-03-05T10:00', 7.9, 0),
('Europe/Paris', '2023-03-05T11:00', 7.9, 0),
('Europe/Paris', '2023-03-05T12:00', 8.5, 0),
('Europe/Paris', '2023-03-05T13:00', 6.5, 0),
('Europe/Paris', '2023-03-05T14:00', 7.2, 0),
('Europe/Paris', '2023-03-05T15:00', 7.9, 0),
('Europe/Paris', '2023-03-05T16:00', 8.3, 0),
('Europe/Paris', '2023-03-05T17:00', 8.1, 0),
('Europe/Paris', '2023-03-05T18:00', 7.8, 0),
('Europe/Paris', '2023-03-05T19:00', 7.3, 0),
('Europe/Paris', '2023-03-05T20:00', 6.5, 0),
('Europe/Paris', '2023-03-05T21:00', 6.2, 0),
('Europe/Paris', '2023-03-05T22:00', 5.7, 0),
('Europe/Paris', '2023-03-05T23:00', 4.7, 0),
('Europe/Paris', '2023-03-06T00:00', 4.8, 0),
('Europe/Paris', '2023-03-06T01:00', 3.9, 0),
('Europe/Paris', '2023-03-06T02:00', 3.3, 0),
('Europe/Paris', '2023-03-06T03:00', 2.8, 0),
('Europe/Paris', '2023-03-06T04:00', 2.7, 0),
('Europe/Paris', '2023-03-06T05:00', 2.3, 0),
('Europe/Paris', '2023-03-06T06:00', 1.9, 0),
('Europe/Paris', '2023-03-06T07:00', 1.5, 0),
('Europe/Paris', '2023-03-06T08:00', 2.3, 0),
('Europe/Paris', '2023-03-06T09:00', 3.1, 0),
('Europe/Paris', '2023-03-06T10:00', 4.5, 0),
('Europe/Paris', '2023-03-06T11:00', 5.8, 0),
('Europe/Paris', '2023-03-06T12:00', 6.8, 0),
('Europe/Paris', '2023-03-06T13:00', 7.4, 0),
('Europe/Paris', '2023-03-06T14:00', 8, 0),
('Europe/Paris', '2023-03-06T15:00', 8.4, 0),
('Europe/Paris', '2023-03-06T16:00', 8.6, 0),
('Europe/Paris', '2023-03-06T17:00', 8.7, 0),
('Europe/Paris', '2023-03-06T18:00', 8.5, 0),
('Europe/Paris', '2023-03-06T19:00', 8, 0),
('Europe/Paris', '2023-03-06T20:00', 7.2, 0),
('Europe/Paris', '2023-03-06T21:00', 7, 0),
('Europe/Paris', '2023-03-06T22:00', 6.2, 0),
('Europe/Paris', '2023-03-06T23:00', 5.6, 0),
('Europe/Paris', '2023-03-07T00:00', 5.3, 0),
('Europe/Paris', '2023-03-07T01:00', 5, 0),
('Europe/Paris', '2023-03-07T02:00', 4.5, 0),
('Europe/Paris', '2023-03-07T03:00', 4.1, 0),
('Europe/Paris', '2023-03-07T04:00', 3.5, 0),
('Europe/Paris', '2023-03-07T05:00', 3, 0),
('Europe/Paris', '2023-03-07T06:00', 2.6, 0),
('Europe/Paris', '2023-03-07T07:00', 1.9, 0),
('Europe/Paris', '2023-03-07T08:00', 1.7, 0),
('Europe/Paris', '2023-03-07T09:00', 2.4, 0),
('Europe/Paris', '2023-03-07T10:00', 3.7, 0),
('Europe/Paris', '2023-03-07T11:00', 5, 0),
('Europe/Paris', '2023-03-07T12:00', 5.8, 0),
('Europe/Paris', '2023-03-07T13:00', 7, 0),
('Europe/Paris', '2023-03-07T14:00', 7.9, 0),
('Europe/Paris', '2023-03-07T15:00', 8.4, 0),
('Europe/Paris', '2023-03-07T16:00', 8, 0.1),
('Europe/Paris', '2023-03-07T17:00', 7.5, 0),
('Europe/Paris', '2023-03-07T18:00', 7, 0),
('Europe/Paris', '2023-03-07T19:00', 6.2, 0),
('Europe/Paris', '2023-03-07T20:00', 5.6, 0.1),
('Europe/Paris', '2023-03-07T21:00', 4.3, 1.1),
('Europe/Paris', '2023-03-07T22:00', 3.3, 0.3),
('Europe/Paris', '2023-03-07T23:00', 3, 0.1),
('Europe/Paris', '2023-03-08T00:00', 2.9, 0),
('Europe/Paris', '2023-03-08T01:00', 2.9, 0.2),
('Europe/Paris', '2023-03-08T02:00', 2.9, 0.3),
('Europe/Paris', '2023-03-08T03:00', 3.1, 0.3),
('Europe/Paris', '2023-03-08T04:00', 3.6, 0.5),
('Europe/Paris', '2023-03-08T05:00', 3.5, 0.6),
('Europe/Paris', '2023-03-08T06:00', 3.2, 1.4),
('Europe/Paris', '2023-03-08T07:00', 3.2, 1.2),
('Europe/Paris', '2023-03-08T08:00', 3.7, 3),
('Europe/Paris', '2023-03-08T09:00', 4.1, 0.5),
('Europe/Paris', '2023-03-08T10:00', 6, 0.2),
('Europe/Paris', '2023-03-08T11:00', 8.5, 0),
('Europe/Paris', '2023-03-08T12:00', 10.4, 0),
('Europe/Paris', '2023-03-08T13:00', 12.6, 0),
('Europe/Paris', '2023-03-08T14:00', 12.9, 0),
('Europe/Paris', '2023-03-08T15:00', 12.8, 0),
('Europe/Paris', '2023-03-08T16:00', 11.8, 0.8),
('Europe/Paris', '2023-03-08T17:00', 9.7, 2.9),
('Europe/Paris', '2023-03-08T18:00', 6.9, 1.5),
('Europe/Paris', '2023-03-08T19:00', 5, 0.6),
('Europe/Paris', '2023-03-08T20:00', 4.1, 1.5),
('Europe/Paris', '2023-03-08T21:00', 3.6, 1.9),
('Europe/Paris', '2023-03-08T22:00', 3.6, 1.4),
('Europe/Paris', '2023-03-08T23:00', 3.5, 0.3),
('Europe/Paris', '2023-03-09T00:00', 3.4, 0.3),
('Europe/Paris', '2023-03-09T01:00', 3.2, 0.3),
('Europe/Paris', '2023-03-09T02:00', 2.9, 0.5),
('Europe/Paris', '2023-03-09T03:00', 2.7, 0.5),
('Europe/Paris', '2023-03-09T04:00', 2.5, 0.3),
('Europe/Paris', '2023-03-09T05:00', 2.4, 0.1),
('Europe/Paris', '2023-03-09T06:00', 2.4, 0.1),
('Europe/Paris', '2023-03-09T07:00', 2.4, 0),
('Europe/Paris', '2023-03-09T08:00', 3.4, 0.3),
('Europe/Paris', '2023-03-09T09:00', 3.3, 0.1),
('Europe/Paris', '2023-03-09T10:00', 3.6, 0),
('Europe/Paris', '2023-03-09T11:00', 4.2, 0),
('Europe/Paris', '2023-03-09T12:00', 5.1, 0),
('Europe/Paris', '2023-03-09T13:00', 5.9, 0),
('Europe/Paris', '2023-03-09T14:00', 6.4, 0),
('Europe/Paris', '2023-03-09T15:00', 6.8, 0.1),
('Europe/Paris', '2023-03-09T16:00', 7.1, 0.1),
('Europe/Paris', '2023-03-09T17:00', 7.5, 0.1),
('Europe/Paris', '2023-03-09T18:00', 7.9, 0.1),
('Europe/Paris', '2023-03-09T19:00', 8.1, 0),
('Europe/Paris', '2023-03-09T20:00', 8.1, 0),
('Europe/Paris', '2023-03-09T21:00', 8.1, 0),
('Europe/Paris', '2023-03-09T22:00', 0, 0),
('Europe/Paris', '2023-03-09T23:00', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

DROP TABLE IF EXISTS `piece`;
CREATE TABLE `piece` (
  `id` int NOT NULL,
  `utilisateur` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `piece`
--

INSERT INTO `piece` (`id`, `utilisateur`, `nom`) VALUES
(3, 'admin', 'Chambre 1'),
(6, 'admin', 'Salon'),
(7, 'admin', 'Cuisine'),
(8, 'admin', 'Salle de bain'),
(9, 'admin', 'Chambre 2'),
(10, 'admin', 'Chambre 3'),
(11, 'admin', 'Garage');

-- --------------------------------------------------------

--
-- Structure de la table `typeequipement`
--

DROP TABLE IF EXISTS `typeequipement`;
CREATE TABLE `typeequipement` (
  `type` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `typeequipement`
--

INSERT INTO `typeequipement` (`type`) VALUES
('capteur-fenetre'),
('capteur-porte'),
('detecteur-fumee'),
('lumiere'),
('porte-garage'),
('radiateur'),
('volet');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `password`) VALUES
('admin', 'admin123');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `equipement`
--
ALTER TABLE `equipement`
  ADD PRIMARY KEY (`utilisateur`,`piece`,`nom`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `fk_type_equipement` (`type`);

--
-- Index pour la table `meteodaily`
--
ALTER TABLE `meteodaily`
  ADD PRIMARY KEY (`timezone`,`time`) USING BTREE;

--
-- Index pour la table `meteohourly`
--
ALTER TABLE `meteohourly`
  ADD PRIMARY KEY (`timezone`,`time`);

--
-- Index pour la table `piece`
--
ALTER TABLE `piece`
  ADD PRIMARY KEY (`utilisateur`,`nom`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Index pour la table `typeequipement`
--
ALTER TABLE `typeequipement`
  ADD PRIMARY KEY (`type`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `equipement`
--
ALTER TABLE `equipement`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `piece`
--
ALTER TABLE `piece`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `equipement`
--
ALTER TABLE `equipement`
  ADD CONSTRAINT `fk_piece` FOREIGN KEY (`utilisateur`,`piece`) REFERENCES `piece` (`utilisateur`, `nom`),
  ADD CONSTRAINT `fk_type_equipement` FOREIGN KEY (`type`) REFERENCES `typeequipement` (`type`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
