-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2019-05-19 11:26:02
-- 服务器版本： 10.1.38-MariaDB
-- PHP 版本： 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `brewday`
--

-- --------------------------------------------------------

--
-- 表的结构 `equipment`
--

CREATE TABLE `equipment` (
  `Eid` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Capacity` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `equipment`
--

INSERT INTO `equipment` (`Eid`, `Name`, `Capacity`) VALUES
(1, 'Eq1', 10),
(2, 'Eq2', 5),
(3, 'Eq', 100),
(4, 'Eq4', 50),
(5, 'Eq5', 200);

-- --------------------------------------------------------

--
-- 表的结构 `history`
--

CREATE TABLE `history` (
  `Hid` int(11) NOT NULL,
  `Date` datetime NOT NULL,
  `Volume` double(16,4) NOT NULL,
  `WaterQuantity` double(16,4) NOT NULL,
  `MaltQuantity` double(16,4) DEFAULT NULL,
  `HopQuantity` double(16,4) NOT NULL,
  `YeastQuantity` double(16,4) NOT NULL,
  `SugarQuantity` double(16,4) NOT NULL,
  `AdditiveQuantity` double(16,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `note`
--

CREATE TABLE `note` (
  `Nid` int(11) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Content` varchar(255) NOT NULL,
  `Date` datetime NOT NULL,
  `Rid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `recipe`
--

CREATE TABLE `recipe` (
  `Rid` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `WaterQuantity` double(16,4) NOT NULL,
  `MaltQuantity` double(16,4) DEFAULT NULL,
  `HopQuantity` double(16,4) NOT NULL,
  `YeastQuantity` double(16,4) NOT NULL,
  `SugarQuantity` double(16,4) NOT NULL,
  `AdditiveQuantity` double(16,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `recipe`
--

INSERT INTO `recipe` (`Rid`, `Name`, `WaterQuantity`, `MaltQuantity`, `HopQuantity`, `YeastQuantity`, `SugarQuantity`, `AdditiveQuantity`) VALUES
(32, 'sa', 1.0000, 1.0000, 1.0000, 1.0000, 11.0000, 1.0000),
(36, 'as', 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000),
(39, 'qwe', 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
(40, 'qweqwe', 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
(41, 'qwe', 0.0833, 0.0833, 0.0833, 0.0833, 0.0833, 0.0833),
(43, 'ada', 0.0833, 0.0833, 0.0833, 0.0833, 0.0833, 0.0833),
(44, 'as', 0.0833, 0.0833, 0.0833, 0.0833, 0.0833, 0.0833),
(45, 'as', 0.0833, 0.0833, 0.0000, 0.0833, 0.0833, 0.0833);

-- --------------------------------------------------------

--
-- 表的结构 `storageingredient`
--

CREATE TABLE `storageingredient` (
  `Sid` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Amount` double(16,4) NOT NULL,
  `Unit` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `storageingredient`
--

INSERT INTO `storageingredient` (`Sid`, `Name`, `Amount`, `Unit`) VALUES
(1, 'Water', 0.0000, 'Kg'),
(2, 'Malts', 0.0000, 'Kg'),
(3, 'Hops', 0.0000, 'Kg'),
(4, 'Yeasts', 0.0000, 'Kg'),
(5, 'Sugars', 0.0000, 'Kg'),
(6, 'Additives', 0.0000, 'Kg');

--
-- 转储表的索引
--

--
-- 表的索引 `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`Eid`);

--
-- 表的索引 `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`Hid`);

--
-- 表的索引 `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`Nid`);

--
-- 表的索引 `recipe`
--
ALTER TABLE `recipe`
  ADD PRIMARY KEY (`Rid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `equipment`
--
ALTER TABLE `equipment`
  MODIFY `Eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `history`
--
ALTER TABLE `history`
  MODIFY `Hid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `note`
--
ALTER TABLE `note`
  MODIFY `Nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- 使用表AUTO_INCREMENT `recipe`
--
ALTER TABLE `recipe`
  MODIFY `Rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
