-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2019-05-08 17:54:43
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
(4, 'eq2', 12),
(5, 'aa', 12),
(7, 'sb', 222);

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
(3, 'note2', 'nolan is sb', '2019-05-08 09:57:56', 3),
(4, 'xxx', 'note for 3', '2019-05-08 17:07:42', 3),
(6, 'qweq', 'note for 4', '2019-05-08 17:07:42', 4),
(7, 'ass22', 'qqqqqqqqqqqqqqqqqqqqqqqq', '2019-05-08 22:45:26', 23),
(8, 'ass23', '    1231213', '2019-05-08 22:46:49', 23);

-- --------------------------------------------------------

--
-- 表的结构 `recipe`
--

CREATE TABLE `recipe` (
  `Rid` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `WaterQuantity` int(2) NOT NULL,
  `MaltQuantity` int(2) DEFAULT NULL,
  `HopQuantity` int(2) NOT NULL,
  `YeastQuantity` int(2) NOT NULL,
  `SugarQuantity` int(2) NOT NULL,
  `AdditiveQuantity` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `recipe`
--

INSERT INTO `recipe` (`Rid`, `Name`, `WaterQuantity`, `MaltQuantity`, `HopQuantity`, `YeastQuantity`, `SugarQuantity`, `AdditiveQuantity`) VALUES
(3, 'qw', 1, 1, 1, 1, 1, 1),
(4, 'xxx', 1, 1, 1, 1, 1, 1),
(7, 'er', 12, 12, 3, 211, 12, 12),
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
(23, 'ass', 1, 1, 2, 1, 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `storageingredient`
--

CREATE TABLE `storageingredient` (
  `Sid` int(11) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Amount` double NOT NULL,
  `Unit` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `storageingredient`
--

INSERT INTO `storageingredient` (`Sid`, `Name`, `Amount`, `Unit`) VALUES
(1, 'Water', 13, 'Kg'),
(2, 'Malts', 10, 'Kg'),
(3, 'Hops', 10, 'Kg'),
(4, 'Yeasts', 10, 'Kg'),
(5, 'Sugars', 10, 'Kg'),
(6, 'Additives', 10, 'Kg');

--
-- 转储表的索引
--

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

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `equipment`
--
ALTER TABLE `equipment`
  MODIFY `Eid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- 使用表AUTO_INCREMENT `note`
--
ALTER TABLE `note`
  MODIFY `Nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `recipe`
--
ALTER TABLE `recipe`
  MODIFY `Rid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
