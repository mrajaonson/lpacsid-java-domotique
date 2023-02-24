-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : mysql:3306
-- Généré le : ven. 24 fév. 2023 à 15:38
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

INSERT INTO `equipement` (`utilisateur`, `piece`, `nom`, `type`, `valeur`, `estConnecte`) VALUES
('admin', 'salon', 'Lumière 1', 'lumiere', 0, 1);

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
('Europe/Paris', '2023-02-26', 5.8, -0.2, '07:36', '18:30');

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
('Europe/Paris', '2023-02-26T00:00', 2.2, 0),
('Europe/Paris', '2023-02-26T01:00', 1.7, 0),
('Europe/Paris', '2023-02-26T02:00', 1.4, 0),
('Europe/Paris', '2023-02-26T03:00', 1.1, 0),
('Europe/Paris', '2023-02-26T04:00', 0.9, 0),
('Europe/Paris', '2023-02-26T05:00', 0.7, 0),
('Europe/Paris', '2023-02-26T06:00', 0.4, 0),
('Europe/Paris', '2023-02-26T07:00', 0.1, 0),
('Europe/Paris', '2023-02-26T08:00', -0.2, 0),
('Europe/Paris', '2023-02-26T09:00', 0.1, 0),
('Europe/Paris', '2023-02-26T10:00', 1.2, 0),
('Europe/Paris', '2023-02-26T11:00', 2.5, 0),
('Europe/Paris', '2023-02-26T12:00', 3.6, 0),
('Europe/Paris', '2023-02-26T13:00', 4.6, 0),
('Europe/Paris', '2023-02-26T14:00', 5.4, 0),
('Europe/Paris', '2023-02-26T15:00', 5.8, 0),
('Europe/Paris', '2023-02-26T16:00', 5.6, 0),
('Europe/Paris', '2023-02-26T17:00', 5.1, 0),
('Europe/Paris', '2023-02-26T18:00', 4.2, 0),
('Europe/Paris', '2023-02-26T19:00', 3.2, 0),
('Europe/Paris', '2023-02-26T20:00', 2.4, 0),
('Europe/Paris', '2023-02-26T21:00', 1.8, 0),
('Europe/Paris', '2023-02-26T22:00', 1.4, 0),
('Europe/Paris', '2023-02-26T23:00', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

DROP TABLE IF EXISTS `piece`;
CREATE TABLE `piece` (
  `utilisateur` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `piece`
--

INSERT INTO `piece` (`utilisateur`, `nom`) VALUES
('admin', 'Cuisine'),
('admin', 'salon');

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
  ADD PRIMARY KEY (`utilisateur`,`nom`);

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
