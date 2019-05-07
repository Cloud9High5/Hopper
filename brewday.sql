-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2019-05-06 05:21:24
-- 服务器版本： 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brewday`
--

-- --------------------------------------------------------

--
-- 表的结构 `equipment`
--

CREATE TABLE `equipment` (
  `Eid` int(11) AUTO_INCREMENT PRIMARY KEY,
  `Name` varchar(100) DEFAULT NULL,
  `Capacity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `ingredient`
--

CREATE TABLE `ingredient` (
  `Iid` int(11) AUTO_INCREMENT PRIMARY KEY,
  `Name` varchar(100) DEFAULT NULL,
  `Amount` double DEFAULT NULL,
  `Unit` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `note`
--

CREATE TABLE `note` (
  `Nid` int(11) AUTO_INCREMENT PRIMARY KEY,
  `Name` varchar(10) NOT NULL,
  `Content` varchar(255) NOT NULL,
  `Date` date NOT NULL,
  `Rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `recipe`
--

CREATE TABLE `recipe` (
  `Rid` int(11) AUTO_INCREMENT PRIMARY KEY,
  `Name` varchar(100) DEFAULT NULL,
  `Amount` double NOT NULL,
  `Unit` varchar(100) NOT NULL,
  `Ingredient1ID` int(11) DEFAULT NULL,
  `Ingredient2ID` int(11) DEFAULT NULL,
  `Ingredient3ID` int(11) DEFAULT NULL,
  `Ingredient4ID` int(11) DEFAULT NULL,
  `Ingredient5ID` int(11) DEFAULT NULL,
  `Ingredient6ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

