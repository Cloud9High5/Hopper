-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2019-05-18 10:23:46
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
(13, 'ee', 12),
(14, '2', 12.3),
(15, 'ew', 44.1),
(16, 'e', 1),
(17, 'weew', 100);

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

--
-- 转存表中的数据 `note`
--

INSERT INTO `note` (`Nid`, `Name`, `Content`, `Date`, `Rid`) VALUES
(3, 'dsf', '2342rtf34f345gy4456yh', '2019-05-16 21:22:05', 3),
(15, '3bangz', 'asdasdasdasdasdasdadaasdas', '2019-05-16 21:34:27', 3),
(16, 'sad', '12313', '2019-05-18 11:48:23', 30),
(17, '', '', '2019-05-18 11:52:34', 31),
(18, '', '', '2019-05-18 12:02:18', 33),
(19, 'dsf', 'sdeggverve', '2019-05-18 15:16:30', 36),
(20, 'qwe', 'qwe', '2019-05-18 16:03:24', 39),
(21, '12', 'qwe', '2019-05-18 16:05:20', 40),
(22, 'hjk', 'hjk', '2019-05-18 16:14:21', 41),
(23, 'werw', 'werwerwe', '2019-05-18 16:22:41', 43);

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
(3, 'dsf', 2, 2, 2, 2, 1, 23),
(4, 'xxx', 1, 1, 1, 1, 1, 1),
(7, 'asd', 12, 12, 12, 23, 12, 23),
(8, 're', 1, 1, 3, 2, 12, 1),
(9, 're', 1, 1, 23, 12, 12, 1),
(10, 'ewr', 12, 12, 2, 12, 23, 12),
(11, 'asd', 12, 12, 34, 4, 56, 12),
(12, 'as', 12, 12, 23, 2, 23, 12),
(13, 'er', 12, 12, 23, 21, 23, 12),
(14, 'gwer', 12, 12, 23, 43, 1, 12),
(15, 'er', 12, 12, 2, 2, 1, 12),
(16, 'asd', 1, 1, 1, 1, 1, 1),
(17, '32', 23, 23, 12, 23, 12, 23),
(18, '2', 1, 1, 2, 2, 1, 1),
(19, 'recipe2', 21, 21, 12, 2, 12, 21),
(20, 'recipesb', 1, 1, 1, 1, 1, 1),
(21, 'ass', 1, 1, 1, 11, 1, 1),
(22, 'ass', 1, 1, 1, 1, 1, 1),
(23, 'ass', 1, 1, 2, 1, 1, 1),
(24, 'cc', 2, 2, 2, 2, 2, 2),
(25, 'q', 1, 1, 1, 1, 1, 1),
(26, '12', 12, 12, 1, 1, 1, 1),
(27, 'qw', 1, 1, 2, 2, 2, 2),
(28, 'xxxx', 1, 1, 1, 11, 1, 1),
(29, 'as', 1, 1, -2, 1, 1, 1),
(30, 'sa', 1, 1, 1, 1, 1, 1),
(31, 'sa', -1, -1, -1, -1, -1, -1),
(32, 'sa', 1, 1, 1, 1, 11, 1),
(33, 'as', 1, 1, 1, 1, 1, -1),
(34, 'as', 1, 1, 1, 11, 1, -1),
(35, 'as', 1, 1, 1, 1, 1, -1),
(36, 'as', 1, 1, 1, 1, 1, 1),
(37, 'as', 1, 1, 1, 1, 1, -1),
(38, 'as', 1, 1, 1, 11, 1, -12),
(39, 'qwe', 0, 0, 0, 0, 0, 0),
(40, 'qweqwe', 0, 0, 0, 0, 0, 0),
(41, 'qwe', 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333),
(42, 'ada', 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, -0.08333333333333333),
(43, 'ada', 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333, 0.08333333333333333);

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
(1, 'Water', 16.6600, 'Kg'),
(2, 'Malts', 3.9800, 'Kg'),
(3, 'Hops', 6.3100, 'Kg'),
(4, 'Yeasts', 4.3700, 'Kg'),
(5, 'Sugars', 1.1200, 'Kg'),
(6, 'Additives', 3.9800, 'Kg');


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

--
-- 表的索引 `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`Eid`);

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


ALTER TABLE `history`
  ADD PRIMARY KEY (`Hid`);
--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `equipment`
--
ALTER TABLE `equipment`
  MODIFY `Eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- 使用表AUTO_INCREMENT `note`
--
ALTER TABLE `note`
  MODIFY `Nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- 使用表AUTO_INCREMENT `recipe`
--
ALTER TABLE `recipe`
  MODIFY `Rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
