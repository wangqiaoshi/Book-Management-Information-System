-- phpMyAdmin SQL Dump
-- version 2.11.9.2
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1:3306
-- 生成日期: 2012 年 10 月 07 日 07:59
-- 服务器版本: 5.1.28
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- 数据库: `booksystem`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `num` text NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 导出表中的数据 `admin`
--

INSERT INTO `admin` (`num`, `name`, `password`) VALUES
('0', 'root', 'hehe'),
('1', 'elilien', 'test'),
('2', 'test', 'test');

-- --------------------------------------------------------

--
-- 表的结构 `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `number` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `bookname` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `publish` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `author` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `isbn` int(30) NOT NULL,
  `price` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `lend` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'No'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 导出表中的数据 `books`
--

INSERT INTO `books` (`number`, `bookname`, `publish`, `author`, `isbn`, `price`, `lend`) VALUES
(0x31, 0x4c6561726e696e6720436f636f612077697468204f626a6563746976652d43, 0x4f275245494c4c59, 0x4a616d65732044756e63616e204461766964736f6e2026204170706c6520436f6d70757465722c20496e632e, 2147483647, 0x3339, 'Yes'),
(0x32, 0x5374657665204a6f6273, 0x53494d4f4e2026205343485553544552, 0x57616c746572204973616163736f6e, 2147483647, 0x323130, 'No'),
(0x33, 0xe8bdafe4bbb6e5b7a5e7a88b, 0xe6b885e58d8ee5a4a7e5ada6e587bae78988e7a4be, 0xe992b1e4b990e7a78b, 2147483647, 0x33342e35, 'No');

-- --------------------------------------------------------

--
-- 表的结构 `lend`
--

CREATE TABLE IF NOT EXISTS `lend` (
  `bnumber` text NOT NULL,
  `unumber` text NOT NULL,
  `lendtime` text NOT NULL,
  `returntime1` text NOT NULL,
  `returntime2` text NOT NULL,
  `breturn` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 导出表中的数据 `lend`
--

INSERT INTO `lend` (`bnumber`, `unumber`, `lendtime`, `returntime1`, `returntime2`, `breturn`) VALUES
('1', '1', '10/05/2012', '12/05/2012', 'N/A', 'No'),
('1', '2', '07/08/2012', '09/08/2012', '08/30/2012', 'Yes');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `number` text NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL,
  `college` text NOT NULL,
  `subject` text NOT NULL,
  `grade` text NOT NULL,
  `booknumber` int(11) NOT NULL DEFAULT '6'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- 导出表中的数据 `users`
--

INSERT INTO `users` (`number`, `name`, `password`, `college`, `subject`, `grade`, `booknumber`) VALUES
('0', 'root', 'hehe', 'City Institute, DUT', 'Software Engineering', '2010', 9),
('1', 'elilien', 'test', 'City Institute, DUT', 'Software Engineering', '2010', 9),
('2', 'guest', 'test', 'City Institute, DUT', 'Software Engineering', '2012', 6);
