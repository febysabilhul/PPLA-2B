-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2018 at 03:33 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pplb_mrkopi`
--

-- --------------------------------------------------------

--
-- Table structure for table `aset`
--

CREATE TABLE `aset` (
  `id_aset` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `koin` int(11) NOT NULL,
  `bibit` int(11) NOT NULL,
  `pupuk` int(11) NOT NULL,
  `obat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aset`
--

INSERT INTO `aset` (`id_aset`, `id_user`, `koin`, `bibit`, `pupuk`, `obat`) VALUES
(1, 1, 1000, 2, 2, 2),
(2, 2, 1000, 2, 2, 2),
(3, 3, 1000, 2, 2, 2),
(4, 4, 1000, 2, 2, 2),
(5, 5, 1000, 2, 2, 2),
(6, 6, 1000, 1, 2, 2),
(7, 7, 1000, 1, 2, 2),
(8, 8, 1000, 1, 2, 2),
(9, 9, 1000, 0, 2, 2),
(10, 10, 1000, 2, 2, 2),
(11, 11, 1000, 2, 2, 2),
(12, 12, 2, 2, 2, 2),
(13, 13, 1000, 0, 2, 2),
(14, 14, 900, 3, 2, 2),
(15, 15, 1000, 0, 2, 2),
(16, 16, 1000, 0, 2, 2),
(17, 17, 620, 2, 4, 2),
(18, 18, 200, 4, 2, 2),
(19, 19, 1000, 1, 2, 2),
(20, 20, 600, 4, 2, 2),
(21, 21, 700, 3, 2, 2),
(22, 22, 1000, 0, 2, 2),
(23, 23, 800, 2, 2, 2),
(24, 24, 700, 3, 2, 2),
(25, 25, -1, 0, 2, 2),
(26, 26, 510, 2, 3, 2),
(27, 27, 1000, 2, 2, 2),
(28, 28, 520, 2, 4, 2),
(29, 29, 1000, 2, 2, 2),
(30, 30, -1, 2, 2, 2),
(31, 31, -1, 2, 2, 2),
(32, 32, -1, 2, 2, 2),
(33, 33, -1, 1, 2, 2),
(34, 34, -1, 0, 2, 2),
(35, 35, -1, 0, 2, 2),
(36, 36, -1, 0, 2, 2),
(37, 37, -1, 0, 2, 2),
(38, 38, 1000, 0, 2, 2),
(39, 39, 1000, 0, 2, 2),
(40, 40, 1000, 0, 2, 2),
(41, 41, 1000, 0, 2, 2),
(42, 42, 1000, 0, 2, 2),
(43, 43, 1000, 0, 2, 2),
(44, 44, 1000, 0, 2, 2),
(45, 45, 1000, 0, 2, 2),
(46, 46, 1000, 0, 2, 2),
(47, 47, 1000, 0, 2, 2),
(48, 48, 1000, 0, 2, 2),
(49, 49, 1000, 0, 2, 2),
(50, 50, 1000, 0, 2, 2),
(51, 51, 1000, 0, 2, 2),
(52, 52, 1000, 0, 2, 2),
(53, 53, 1000, 0, 2, 2),
(54, 54, 800, 0, 2, 2),
(55, 55, 1000, 0, 2, 2),
(56, 56, 1000, 0, 2, 2),
(57, 57, 1000, 0, 2, 2),
(58, 58, 1000, 0, 2, 2),
(59, 59, 1000, 2, 2, 2),
(60, 60, 1000, 0, 2, 2),
(61, 61, 1000, 0, 2, 2),
(62, 62, 1000, 0, 2, 2),
(63, 63, 1000, 0, 2, 2),
(64, 64, 1000, 0, 2, 2),
(65, 65, 1000, 0, 2, 2),
(66, 66, 1000, 0, 2, 2),
(67, 67, 1000, 0, 2, 2),
(68, 68, 1000, 0, 2, 2),
(69, 69, 800, 0, 2, 2),
(70, 70, 1000, 0, 2, 2),
(71, 71, 1000, 0, 2, 2),
(72, 72, 1000, 0, 2, 2),
(73, 73, 600, 0, 2, 2),
(74, 74, 823, 0, 2, 2),
(75, 75, 639, 0, 2, 2),
(76, 76, 1633, 0, 2, 2),
(77, 77, 1697503369, 0, 2, 2),
(78, 78, 1006, 0, 2, 2),
(79, 79, 1000, 0, 2, 2),
(80, 80, 1000, 0, 2, 2),
(81, 81, 812, 0, 2, 2),
(82, 82, 707, 0, 2, 2),
(83, 83, 1150, 0, 2, 2),
(84, 84, 1000, 0, 2, 2),
(85, 85, 1000, 0, 2, 2),
(86, 86, 1000, 0, 2, 2),
(87, 87, 1000, 0, 2, 2),
(88, 88, 1000, 0, 2, 2),
(89, 89, 1000, 0, 2, 2),
(90, 90, 1000, 0, 2, 2),
(91, 91, 1000, 0, 2, 2),
(92, 92, 1000, 0, 2, 2),
(93, 93, 600, 0, 2, 2),
(94, 94, 1000, 0, 2, 2),
(95, 95, 1000, 0, 2, 2),
(96, 96, 1000, 2, 2, 2),
(97, 97, 1000, 0, 2, 2),
(98, 98, 1000, 0, 2, 2),
(99, 99, 1000, 0, 2, 2),
(100, 100, 1000, 0, 2, 2),
(101, 101, 800, 0, 2, 2),
(102, 102, 1000, 0, 2, 2),
(103, 103, 1000, 0, 2, 2),
(104, 104, 1000, 0, 2, 2),
(105, 105, 1000, 0, 2, 2),
(106, 106, 1000, 2, 2, 2),
(107, 107, 1000, 2, 2, 2),
(108, 108, 1000, 2, 2, 2),
(109, 109, 1000, 2, 2, 2),
(110, 110, 1000, 0, 2, 2),
(111, 111, 1000, 0, 2, 2),
(112, 112, 1000, 0, 2, 2),
(113, 113, 1000, 0, 2, 2),
(114, 114, 1000, 0, 2, 2),
(115, 115, 1000, 1, 2, 2),
(116, 116, 1000, 0, 2, 2),
(117, 117, 1000, 2, 2, 2),
(118, 118, 1000, 2, 2, 2),
(119, 119, 1000, 0, 2, 2),
(120, 120, 1000, 0, 2, 2),
(121, 121, 1000, 0, 2, 2),
(122, 122, 1000, 0, 2, 2),
(123, 123, 1000, 0, 2, 2),
(124, 124, 1000, 2, 2, 2),
(125, 125, 1000, 0, 2, 2),
(126, 126, 1000, 2, 2, 2),
(127, 127, 1000, 2, 2, 2),
(128, 128, 1000, 0, 2, 2),
(129, 129, 1000, 0, 2, 2),
(130, 130, 1000, 0, 2, 2),
(131, 131, 1000, 0, 2, 2),
(132, 132, 1000, 0, 2, 2),
(133, 133, 1000, 0, 2, 2),
(134, 134, 1000, 2, 2, 2),
(135, 135, 1000, 0, 2, 2),
(136, 136, 1000, 0, 2, 2),
(137, 137, 1000, 0, 2, 2),
(138, 138, 1000, 0, 2, 2),
(139, 139, 1300, 0, 2, 2),
(140, 140, 800, 0, 2, 2),
(141, 141, 1000, 2, 2, 2),
(142, 142, 1000, 0, 2, 2),
(143, 143, 1000, 0, 2, 2),
(144, 144, 1000, 0, 2, 2),
(145, 145, 1000, 0, 2, 2),
(146, 146, 1000, 0, 2, 2),
(147, 147, 1000, 0, 2, 2),
(148, 148, 1000, 0, 2, 2),
(149, 149, 1000, 0, 2, 2),
(150, 150, 1000, 0, 2, 2),
(151, 151, 1000, 0, 2, 2),
(152, 152, 1000, 0, 2, 2),
(153, 153, 1300, 0, 2, 2),
(154, 154, 1000, 0, 2, 2),
(155, 155, 600, 0, 2, 2),
(156, 156, 1000, 0, 2, 2),
(157, 157, 1000, 0, 2, 2),
(158, 158, 1000, 0, 2, 2),
(159, 159, 1000, 2, 2, 2),
(160, 160, 1000, 2, 2, 2),
(161, 161, 1000, 2, 2, 2),
(162, 162, 1000, 2, 2, 2),
(163, 163, 1000, 0, 2, 2),
(164, 164, 1000, 0, 2, 2),
(165, 165, 1000, 0, 2, 2),
(166, 166, 1000, 0, 2, 2),
(167, 167, 1000, 2, 2, 2),
(168, 168, 1000, 2, 2, 2),
(169, 169, 1000, 0, 2, 2),
(170, 170, 1000, 0, 2, 2),
(171, 171, 1000, 0, 2, 2),
(172, 172, 1000, 0, 2, 2),
(173, 173, 1000, 0, 2, 2),
(174, 174, 1000, 0, 2, 2),
(175, 175, 1000, 2, 2, 2),
(176, 176, 1000, 0, 2, 2),
(177, 177, 1000, 0, 2, 2),
(178, 178, 1000, 0, 2, 2),
(179, 179, 1000, 0, 0, 2),
(180, 180, 1000, 0, 2, 2),
(181, 181, 1000, 0, 3, 2),
(182, 182, 1000, 0, 4, 2),
(183, 183, 1000, 1, 4, 2),
(184, 184, 1150, 1, 3, 2),
(185, 185, 1000, 1, 4, 2),
(186, 186, 1000, 1, 4, 2),
(187, 187, 1000, 2, 4, 2),
(188, 188, 1000, 0, 4, 2),
(189, 189, 1000, 0, 4, 2),
(190, 190, 1000, 0, 4, 2),
(191, 191, 1150, 0, 3, 2),
(192, 192, 1000, 0, 4, 2),
(193, 193, 1000, 0, 4, 2),
(194, 194, 1000, 0, 2, 2),
(195, 195, 1000, 0, 3, 1),
(196, 196, 1000, 0, 4, 2),
(197, 197, 1000, 0, 4, 2),
(198, 198, 1000, 0, 4, 2),
(199, 199, 1000, 2, 4, 2),
(200, 200, 1000, 0, 4, 2),
(201, 201, 1000, 0, 4, 2),
(202, 202, 1000, 0, 4, 2),
(203, 203, 1000, 0, 4, 2),
(204, 204, 1200, 1, 3, 1),
(205, 205, 1000, 2, 4, 2),
(206, 206, 1000, 2, 4, 2),
(207, 207, 1000, 2, 4, 2),
(208, 208, 1000, 2, 4, 2),
(209, 209, 1000, 2, 4, 2),
(210, 210, 1000, 2, 4, 2),
(211, 211, 1000, 2, 4, 2),
(212, 212, 1000, 2, 4, 2),
(213, 213, 1000, 2, 4, 2),
(214, 214, 1000, 2, 4, 2),
(215, 215, 1000, 2, 4, 2),
(216, 216, 1000, 2, 4, 2),
(217, 217, 1000, 2, 4, 2),
(218, 218, 1000, 2, 4, 2),
(219, 219, 1000, 1, 3, 2),
(220, 220, 1000, 2, 4, 2),
(221, 221, 1000, 2, 4, 2),
(222, 222, 1000, 2, 4, 2),
(223, 223, 1000, 0, 0, 2),
(224, 224, 1000, 2, 4, 2),
(225, 225, 1000, 2, 4, 2),
(226, 226, 1000, 2, 4, 2),
(227, 227, 1000, 2, 4, 2),
(228, 228, 1000, 2, 4, 2),
(229, 229, 1000, 2, 4, 2),
(230, 230, 1000, 2, 4, 2),
(231, 231, 1000, 2, 4, 2),
(232, 232, 1000, 2, 4, 2),
(233, 233, 1000, 2, 4, 2),
(234, 234, 1000, 2, 4, 2),
(235, 235, 1000, 2, 4, 2),
(236, 236, 1000, 0, 4, 2),
(237, 237, 1000, 2, 4, 2),
(238, 238, 1000, 2, 4, 2),
(239, 239, 1000, 1, 2, 2),
(240, 240, 1000, 2, 2, 2),
(241, 241, 1000, 0, 4, 2),
(242, 242, 1000, 0, 4, 2),
(243, 243, 1000, 0, 4, 2),
(244, 244, 1000, 1, 4, 2),
(245, 245, 1000, 1, 3, 2),
(246, 246, 1000, 1, 4, 2),
(247, 247, 1000, 2, 4, 2),
(248, 248, 1000, 2, 4, 2),
(249, 249, 1000, 1, 4, 2),
(250, 250, 700, 2, 4, 2),
(251, 251, 1000, 2, 4, 2),
(252, 252, 1000, 1, 4, 2),
(253, 253, 1000, 1, 4, 2),
(254, 254, 1000, 1, 4, 2),
(255, 255, 1000, 1, 4, 2),
(256, 256, 1000, 1, 4, 2),
(257, 257, 1000, 1, 4, 2),
(258, 258, 1000, 1, 4, 2),
(259, 259, 1000, 1, 4, 2),
(260, 260, 1000, 1, 4, 2),
(261, 261, 1000, 1, 4, 2),
(262, 262, 1000, 1, 4, 2),
(263, 263, 1000, 1, 4, 2),
(264, 264, 1000, 1, 4, 2),
(265, 265, 1000, 1, 4, 2),
(266, 266, 1000, 1, 4, 2),
(267, 267, 1000, 2, 4, 2),
(268, 268, 1000, 2, 4, 2),
(269, 269, 1000, 1, 4, 2),
(270, 270, 1000, 2, 4, 2),
(271, 271, 1000, 1, 4, 2),
(272, 272, 1000, 1, 4, 2),
(273, 273, 1000, 1, 4, 2),
(274, 274, 1000, 1, 4, 2),
(275, 275, 1000, 2, 4, 2),
(276, 276, 1000, 0, 2, 2),
(277, 277, 1000, 1, 3, 2),
(278, 278, 1000, 1, 3, 2),
(279, 279, 1000, 1, 4, 2),
(280, 280, 1000, 1, 4, 2),
(281, 281, 1000, 0, 4, 2),
(282, 282, 1000, 0, 1, 2),
(283, 283, 1000, 0, 4, 2),
(284, 284, 1000, 0, 4, 2),
(285, 285, 1000, 0, 4, 2),
(286, 286, 1000, 2, 4, 2),
(287, 287, 1000, 2, 4, 2),
(288, 288, 1000, 2, 4, 2),
(289, 289, 1000, 2, 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`) VALUES
(1, 'topo'),
(2, 'data'),
(3, 'tes'),
(4, 'tes1'),
(5, 'isol'),
(6, 'cek'),
(7, 'hurin'),
(8, 'koli'),
(9, 'toto'),
(10, 'dummy'),
(11, 'domi'),
(12, 'dori'),
(13, 'dona'),
(14, 'wedus'),
(15, 'ronin'),
(16, 'dolin'),
(17, 'ros'),
(18, 'broto'),
(19, 'nita'),
(20, 'tono'),
(21, 'dodo'),
(22, 'da'),
(23, 'soni'),
(24, 'io'),
(25, 'roniw'),
(26, 'tota'),
(27, 'doni'),
(28, 'ageng'),
(29, 'tono'),
(30, 'broto'),
(31, 'broto'),
(32, 'oi'),
(33, 'aaaaaa'),
(34, 'dowas'),
(35, 'kamprt'),
(36, 'adasa'),
(37, 'poloj'),
(38, 'koi'),
(39, 'klmo'),
(40, 'dasxz'),
(41, 'zcxzc'),
(42, 'kadl'),
(43, 'dmko'),
(44, 'dodok'),
(45, 'kroco'),
(46, 'bna'),
(47, 'danaw'),
(48, 'km'),
(49, 'yuuy'),
(50, 'uy'),
(51, 'daka'),
(52, 'kik'),
(53, 'asd'),
(54, 'ada'),
(55, 'daok'),
(56, 'yj'),
(57, 'dwada'),
(58, 'bro'),
(59, 'dwada'),
(60, 'ade'),
(61, 'hih'),
(62, 'danw'),
(63, 'fasol'),
(64, 'daws'),
(65, 'asw'),
(66, 'dadws'),
(67, 'sete'),
(68, 'tfg'),
(69, 'sd'),
(70, 'zs'),
(71, 'knt'),
(72, 'oil'),
(73, 'wh'),
(74, 'wewe'),
(75, 'sdx'),
(76, 'aswe'),
(77, 'wes'),
(78, 'slk'),
(79, 'wepo'),
(80, 'aswzx'),
(81, 'lop'),
(82, 'kokl'),
(83, 'sadw'),
(84, 'hurn'),
(85, 'horni'),
(86, 'wahib'),
(87, 'wakwa'),
(88, 'asda'),
(89, 'wws'),
(90, 'wsa'),
(91, 'boas'),
(92, 'zx'),
(93, 'sa'),
(94, 'daas'),
(95, 'asdz'),
(96, 'sa'),
(97, 'k,k'),
(98, 'szv'),
(99, ' vc'),
(100, 'dsz'),
(101, 'az'),
(102, 'as'),
(103, 'sadz'),
(104, 'asf'),
(105, 'soton'),
(106, 'tolo'),
(107, 'sahj'),
(108, 'swz'),
(109, 'zxcw'),
(110, 'wesaz'),
(111, 'jono'),
(112, 'zxr'),
(113, 'zcz'),
(114, 'zcs'),
(115, 'xz'),
(116, 'saddw'),
(117, 'az'),
(118, 'sd'),
(119, 'drt'),
(120, 'sad'),
(121, 'asdae'),
(122, 'kolol'),
(123, 'po'),
(124, 'asd'),
(125, 'xa'),
(126, 'sadw'),
(127, 'nita'),
(128, 'bonidw'),
(129, 'bonpc'),
(130, 'bonba'),
(131, 'doans'),
(132, 'rano'),
(133, 'daw'),
(134, 'sa'),
(135, 'rad'),
(136, 'aswsx'),
(137, 'adasd'),
(138, 'yon'),
(139, 'af'),
(140, 'df'),
(141, 'df'),
(142, 'ddd'),
(143, 'er'),
(144, 'rt'),
(145, 'kj'),
(146, 'tr'),
(147, 'sds'),
(148, 'gfhfg'),
(149, 'dfsdf'),
(150, 'dssa'),
(151, 'cbvdv'),
(152, 'dfsd'),
(153, 'trd'),
(154, 'dasdf'),
(155, 'dadas'),
(156, 'sdff'),
(157, '454'),
(158, 'sakw'),
(159, '21'),
(160, 'bonw'),
(161, '34'),
(162, 'da98'),
(163, 'ds4'),
(164, 'd4'),
(165, 'trtr5'),
(166, 'sf5'),
(167, 'ran'),
(168, '953'),
(169, 'dwd'),
(170, 'akas3'),
(171, 'fdso'),
(172, 'rea'),
(173, 'hiy'),
(174, 'sadu6'),
(175, 'raw0'),
(176, 'fa3'),
(177, 'rwo'),
(178, 'ds'),
(179, 'o'),
(180, 'dw'),
(181, 'ranow'),
(182, 'bdo'),
(183, 'dasp'),
(184, 'op'),
(185, 'dasd'),
(186, 're'),
(187, 'da'),
(188, 'bgsd'),
(189, 'swe'),
(190, 'wakwas'),
(191, 'opit'),
(192, 'donip'),
(193, 'pob'),
(194, 'oip'),
(195, 'capi'),
(196, 'hj'),
(197, 'l'),
(198, 'k'),
(199, 'dwez'),
(200, 'ops'),
(201, 'pw'),
(202, 'oiw'),
(203, 'aox'),
(204, 'bonb'),
(205, 'dasd'),
(206, 'dwcr'),
(207, 'spos'),
(208, 'wepos'),
(209, 're'),
(210, 'astaga'),
(211, 'wan'),
(212, 'waow'),
(213, 'wawas'),
(214, 'popn'),
(215, 'kjk'),
(216, 'o'),
(217, 'p'),
(218, 'm'),
(219, 'wea'),
(220, 'was'),
(221, 'pop'),
(222, 'wawa'),
(223, 'pol'),
(224, 'asd'),
(225, 'iot'),
(226, 'fara'),
(227, 'wed'),
(228, 'vb'),
(229, 'pw'),
(230, 'pow'),
(231, 'sawe'),
(232, 'sp'),
(233, 'awscf'),
(234, 'uo'),
(235, 'iopn'),
(236, 'ewdf'),
(237, 'pol'),
(238, 'wsr'),
(239, 'poli'),
(240, 'weas'),
(241, 'poa'),
(242, 'oia'),
(243, 'oplv'),
(244, 'wer'),
(245, 'bn'),
(246, 'sdaw'),
(247, 'ada'),
(248, 'ada'),
(249, 'kolio'),
(250, 'folio'),
(251, 'folio'),
(252, 'uib'),
(253, 'sadasd'),
(254, 'n'),
(255, 'iu'),
(256, 'yu'),
(257, 'wax'),
(258, '98'),
(259, 'aljk'),
(260, 'tfyhd'),
(261, 'sdadsa'),
(262, 'jgjy'),
(263, 'jhjh'),
(264, 'jhfjf'),
(265, 'yt'),
(266, 'u'),
(267, 'folio'),
(268, 'wf'),
(269, 'owr'),
(270, 'rwe'),
(271, 'fe'),
(272, 'r3'),
(273, 'wdz'),
(274, 'roin'),
(275, 'wea'),
(276, 'popoy'),
(277, 'oiv'),
(278, 'owp'),
(279, 'owe'),
(280, 'wort'),
(281, 'ony'),
(282, 'vn'),
(283, 'perx'),
(284, 'ljd'),
(285, 'oje'),
(286, 'polr'),
(287, 'pwoe'),
(288, 'mew'),
(289, 'owes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aset`
--
ALTER TABLE `aset`
  ADD PRIMARY KEY (`id_aset`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aset`
--
ALTER TABLE `aset`
  MODIFY `id_aset` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=290;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=290;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aset`
--
ALTER TABLE `aset`
  ADD CONSTRAINT `aset_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
