-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 22, 2016 at 08:28 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cloudPOS`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `post` varchar(10) DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 DEFAULT 'open',
  `total` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `create_date`, `discount`, `post`, `status`, `total`, `update_date`, `user_id`) VALUES
(1, '2016-06-22 15:32:15', 0, '2', 'open', 0, '2016-06-23 01:20:06', 1),
(2, '2016-06-22 15:33:36', 0, '4', 'open', 0, '2016-06-23 01:19:59', 1),
(3, '2016-06-22 15:35:33', 0, '5', 'open', 0, '2016-06-23 01:20:08', 1),
(4, '2016-06-22 15:39:51', 0, '6', 'open', 0, '2016-06-22 15:39:51', 1),
(5, '2016-06-22 15:41:29', 0, '1', 'open', 0, '2016-06-22 15:41:29', 1),
(7, '2016-06-22 15:41:29', 0, '1', 'open', 0, '2016-06-22 15:58:25', 1),
(8, '2016-06-23 01:19:55', 0, '3', 'open', 0, '2016-06-23 01:20:06', 1),
(9, '2016-06-23 01:20:10', 0, '8', 'open', 0, '2016-06-23 01:20:10', 1);

-- --------------------------------------------------------

--
-- Table structure for table `bill_menu`
--

CREATE TABLE `bill_menu` (
  `id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(500) NOT NULL,
  `price` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  `price_extend` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `name`, `description`, `price`, `update_user`, `update_time`, `price_extend`) VALUES
(1, 'Cafe den xay', 'Cafe den xay nguyen chat 100%', 121, 1, '2016-06-20 00:00:00', 0),
(2, 'Cafe den binh thuong', 'Cafe den binh thuong', 120000, 1, '2016-06-20 14:17:57', 0),
(5, 'Cafe s&#7919;a xay', 'Cafe nguyên ch&#7845;t xây', 20000, 1, '2016-06-20 14:23:48', 0),
(6, 'B&#7841;c x&#7881;u', 'Cafe nhi&#7873;u s&#7919;a', 30000, 1, '2016-06-20 14:25:34', 0),
(7, 'N&#432;&#7899;c chanh', 'N&#432;&#7899;c chanh', 30000, 1, '2016-06-20 14:26:53', 0),
(8, 'Cafe s&#7919;a bình th&#432;&#7901;ng', 'Cafe s&#7919;a bình th&#432;&#7901;ng', 200000, 1, '2016-06-21 11:06:59', 0),
(9, 'Cafe s&#7919;a bình th&#432;&#7901;ng', 'Cafe s&#7919;a bình th&#432;&#7901;ng', 40000, 1, '2016-06-21 11:12:04', 0),
(10, 'C', '', 0, 1, '2016-06-21 18:20:28', 0),
(11, 'Cafe den xay', 'Cafe den xay nguyen chat 100%', 121, 1, '2016-06-22 08:08:20', 0),
(12, 'C', '', 0, 1, '2016-06-22 08:31:29', 0),
(18, 'Cafe den binh thuong', 'sdsd', 1000, 1, '2016-06-22 09:28:44', 0),
(19, 'Cafe den binh thuong', 'sdsd', 1000, 1, '2016-06-22 09:29:50', 0),
(20, 'Cafe den binh thuong', 'sdsd', 1000, 1, '2016-06-22 09:29:56', 0),
(21, 'Cafe den binh thuong', 'sdsd', 1000, 1, '2016-06-22 09:29:57', 0),
(22, 'Cafe den bin ds', 'sdsds', 1000, 1, '2016-06-22 09:32:56', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bill_menu`
--
ALTER TABLE `bill_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `bill_menu`
--
ALTER TABLE `bill_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
