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
-- Структура на таблица `restockhistory`
--

CREATE TABLE `restockhistory` (
  `entryID` int(11) NOT NULL,
  `employeeID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `restockDate` datetime DEFAULT current_timestamp(),
  `amountRestocked` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `restockhistory`
--

INSERT INTO `restockhistory` (`entryID`, `employeeID`, `productID`, `restockDate`, `amountRestocked`) VALUES
(1, 1, 1, '2020-11-23 16:36:51', 23),
(2, 1, 2, '2020-11-26 01:51:29', 23),
(3, 1, 1, '2020-11-26 01:53:07', 23),
(4, 1, 1, '2020-11-26 01:53:11', 23),
(5, 1, 1, '2020-11-26 01:53:13', 23),
(6, 1, 1, '2020-11-27 13:51:26', 23),
(7, 1, 1, '2020-11-27 13:51:28', 23),
(8, 1, 1, '2020-11-27 15:07:28', 4),
(9, 1, 1, '2020-11-30 09:11:33', 23),
(10, 1, 1, '2020-11-30 11:10:31', 23),
(11, 1, 1, '2020-12-03 17:35:35', 23),
(12, 1, 2, '2020-12-03 17:35:42', 23),
(13, 1, 2, '2020-12-03 17:35:44', 23),
(14, 1, 1, '2020-12-03 17:35:57', 23),
(15, 1, 1, '2020-12-03 17:35:59', 23),
(16, 1, 1, '2020-12-11 11:47:11', 12),
(17, 1, 1, '2020-12-11 11:47:19', 8),
(18, 1, 1, '2020-12-11 14:49:55', 12),
(19, 1, 1, '2020-12-11 14:50:02', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `restockhistory`
--
ALTER TABLE `restockhistory`
  ADD PRIMARY KEY (`entryID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `restockhistory`
--
ALTER TABLE `restockhistory`
  MODIFY `entryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
