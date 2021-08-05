-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15 яну 2021 в 15:00
-- Версия на сървъра: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Структура на таблица `preptask`
--

CREATE TABLE `preptask` (
  `taskID` int(11) NOT NULL,
  `taskAuthorID` int(11) NOT NULL,
  `taskFinisherID` int(11) NOT NULL DEFAULT 0,
  `description` longtext NOT NULL,
  `isComplete` tinyint(1) NOT NULL DEFAULT 0,
  `completionDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `preptask`
--

INSERT INTO `preptask` (`taskID`, `taskAuthorID`, `taskFinisherID`, `description`, `isComplete`, `completionDate`) VALUES
(1, 2, 1, 'Testing', 1, '2020-12-03 20:05:38'),
(2, 1, 2, 'testing 2', 1, '2020-12-03 17:52:39'),
(3, 2, 1, 'testing 3', 1, '2020-12-03 20:08:38'),
(4, 1, 2, 'Testing4', 1, '2020-12-04 15:08:45'),
(5, 1, 2, 'Testing4', 1, '2020-12-04 15:18:44'),
(6, 1, 1, 'Testing4', 1, '2020-12-04 17:48:29'),
(7, 1, 0, 'Testing4', 0, NULL),
(8, 1, 0, 'Testing5', 0, NULL),
(9, 1, 0, 'Testing7', 0, NULL),
(12, 1, 0, 'Testing9', 0, NULL),
(13, 1, 0, 'Testing10', 0, NULL),
(17, 1, 0, 'Testing120', 0, NULL),
(18, 1, 0, 'fqfqfqf', 0, NULL),
(19, 1, 0, 'TestingTesting', 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `preptask`
--
ALTER TABLE `preptask`
  ADD PRIMARY KEY (`taskID`),
  ADD KEY `FK5q8vwvtn1myxeqya6r6att4s7` (`taskAuthorID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `preptask`
--
ALTER TABLE `preptask`
  MODIFY `taskID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Ограничения за дъмпнати таблици
--

--
-- Ограничения за таблица `preptask`
--
ALTER TABLE `preptask`
  ADD CONSTRAINT `FK5q8vwvtn1myxeqya6r6att4s7` FOREIGN KEY (`taskAuthorID`) REFERENCES `employee` (`employeeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
