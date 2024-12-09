-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2024 at 05:45 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tour_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `User_name` varchar(100) NOT NULL,
  `P_ID` int(11) NOT NULL,
  `H_ID` int(11) NOT NULL,
  `Total_Price` decimal(10,2) NOT NULL,
  `Mobile_Number` varchar(15) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Country` varchar(50) NOT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Total_Person` int(11) NOT NULL,
  `Location` varchar(100) NOT NULL,
  `Arrival_Date` date NOT NULL,
  `Leaving_Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`User_name`, `P_ID`, `H_ID`, `Total_Price`, `Mobile_Number`, `Email`, `Country`, `Address`, `Total_Person`, `Location`, `Arrival_Date`, `Leaving_Date`) VALUES
('FI Pranto', 1, 1, 124000.00, '01878', 'fipranto9001@gmail.com', 'Bangladesh', 'Savar', 2, 'Dubai', '2012-11-24', '2015-11-24'),
('Pranto', 2, 2, 500000.00, '0186666666', 'Pro@gmail.com', 'Bangladesh', 'Mirpur2', 5, 'Paris', '2024-11-28', '2024-11-30');

-- --------------------------------------------------------

--
-- Table structure for table `hotels`
--

CREATE TABLE `hotels` (
  `H_ID` int(11) NOT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `H_Name` varchar(255) DEFAULT NULL,
  `H_Price` decimal(10,2) DEFAULT NULL,
  `Rating` decimal(3,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hotels`
--

INSERT INTO `hotels` (`H_ID`, `Location`, `H_Name`, `H_Price`, `Rating`) VALUES
(1, 'Dubai', 'Hotel Dubai', 12000.00, 4.50),
(2, 'Paris', 'Iris Hotel', 20000.00, 4.60);

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

CREATE TABLE `packages` (
  `P_ID` int(11) NOT NULL,
  `Location` varchar(255) DEFAULT NULL,
  `P_Price` decimal(10,2) DEFAULT NULL,
  `P_Name` varchar(255) DEFAULT NULL,
  `Description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`P_ID`, `Location`, `P_Price`, `P_Name`, `Description`) VALUES
(1, 'Dubai', 50000.00, 'Silver Package', 'Tour to the one of the world richest country'),
(2, 'Paris', 80000.00, 'Gold Package', '2 Days 3 Night in Paris');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `country` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` enum('Male','Female') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `phone`, `country`, `address`, `email`, `password`, `gender`) VALUES
(1, 'Admin', '123456', 'BD', 'mirpur', 'admin@gmail.com', 'fipro', 'Male'),
(2, 'FI Pranto', '01878', 'Bangladesh', 'Savar', 'fipranto9001@gmail.com', 'pranto054', 'Male'),
(3, 'Pranto', '0186666666', 'Bangladesh', 'Mirpur2', 'Pro@gmail.com', '12345', 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`P_ID`,`H_ID`),
  ADD KEY `H_ID` (`H_ID`);

--
-- Indexes for table `hotels`
--
ALTER TABLE `hotels`
  ADD PRIMARY KEY (`H_ID`);

--
-- Indexes for table `packages`
--
ALTER TABLE `packages`
  ADD PRIMARY KEY (`P_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hotels`
--
ALTER TABLE `hotels`
  MODIFY `H_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `packages`
--
ALTER TABLE `packages`
  MODIFY `P_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_details`
--
ALTER TABLE `book_details`
  ADD CONSTRAINT `book_details_ibfk_1` FOREIGN KEY (`P_ID`) REFERENCES `packages` (`P_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `book_details_ibfk_2` FOREIGN KEY (`H_ID`) REFERENCES `hotels` (`H_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
