-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 17 яну 2021 в 21:40
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
-- Структура на таблица `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `categoryID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `length` double NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  `price` double NOT NULL,
  `numberInStock` int(11) NOT NULL,
  `location` varchar(100) NOT NULL,
  `numberShipped` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Схема на данните от таблица `product`
--

INSERT INTO `product` (`productID`, `categoryID`, `name`, `length`, `height`, `weight`, `price`, `numberInStock`, `location`, `numberShipped`) VALUES
(1, 1, 'MSI Computer mk1', 55, 45, 6, 1223, 699, 'Alley: 1, section: 1', 81),
(2, 1, 'MSI Computer mk2', 65, 54, 7, 2050, 99, 'Alley: 1, section: 2', 112),
(3, 1, 'MSI Computer mk3', 12, 23, 12, 456, 180, 'Alley: 35, section: 35', 49),
(4, 1, 'MSI Computer mk4', 12, 12, 12, 234, 124, 'Alley: 1, section: 2', 0),
(5, 1, 'MSI Computer mk5', 12, 34, 12, 56, 71, 'Alley: 7, section: 8', 6),
(6, 1, 'ASUS Computer model 345', 123, 60, 5, 234, 44, 'Alley: 7, section: 9', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `categoryID` (`categoryID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
