-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 19, 2023 alle 10:04
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_provaspring`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `categories_skill`
--

CREATE TABLE `categories_skill` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categories_skill`
--

INSERT INTO `categories_skill` (`id`, `description`, `name`) VALUES
(1, 'desc 1', 'Cat 1'),
(2, 'desc 2', 'Cat 2'),
(3, 'desc 3', 'Cat 3');

-- --------------------------------------------------------

--
-- Struttura della tabella `projects`
--

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `repo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `projects`
--

INSERT INTO `projects` (`id`, `description`, `name`, `repo`) VALUES
(1, 'desc project 1', 'Project 1', 'repo 1'),
(2, 'desc project 2', 'Project 2', 'repo 2'),
(3, 'desc project 3', 'Project 3', 'repo 3');

-- --------------------------------------------------------

--
-- Struttura della tabella `skills`
--

CREATE TABLE `skills` (
  `id` bigint(20) NOT NULL,
  `category` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `skills`
--

INSERT INTO `skills` (`id`, `category`, `description`, `name`) VALUES
(1, 1, 'desc skill 1', 'Skill 1'),
(2, 2, 'desc skill 2', 'Skill 2'),
(3, 3, 'desc skill 3', 'Skill 3');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `categories_skill`
--
ALTER TABLE `categories_skill`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `skills`
--
ALTER TABLE `skills`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK51hdjbib8x445q1j2jrc9nwbs` (`category`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `categories_skill`
--
ALTER TABLE `categories_skill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `projects`
--
ALTER TABLE `projects`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `skills`
--
ALTER TABLE `skills`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `skills`
--
ALTER TABLE `skills`
  ADD CONSTRAINT `FK51hdjbib8x445q1j2jrc9nwbs` FOREIGN KEY (`category`) REFERENCES `categories_skill` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
