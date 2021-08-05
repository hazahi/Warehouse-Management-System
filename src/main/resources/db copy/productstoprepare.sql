-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14 яну 2021 в 14:59
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
-- Структура на таблица `productstoprepare`
--

CREATE TABLE `productstoprepare` (
  `entryID` int(11) NOT NULL,
  `taskID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Схема на данните от таблица `productstoprepare`
--

INSERT INTO `productstoprepare` (`entryID`, `taskID`, `productID`, `amount`) VALUES
(1, 1, 1, 23),
(2, 1, 2, 34);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `productstoprepare`
--
ALTER TABLE `productstoprepare`
  ADD PRIMARY KEY (`entryID`),
  ADD KEY `FKtnnedmdw6by926rtxhc2yde21` (`productID`),
  ADD KEY `FKh58hu9hdrt3lp0xrasap2w3v6` (`taskID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `productstoprepare`
--
ALTER TABLE `productstoprepare`
  MODIFY `entryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Ограничения за дъмпнати таблици
--

--
-- Ограничения за таблица `productstoprepare`
--
ALTER TABLE `productstoprepare`
  ADD CONSTRAINT `FKh58hu9hdrt3lp0xrasap2w3v6` FOREIGN KEY (`taskID`) REFERENCES `preptask` (`taskID`),
  ADD CONSTRAINT `FKtnnedmdw6by926rtxhc2yde21` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
