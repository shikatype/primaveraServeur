-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Jeu 21 Mai 2015 à 18:59
-- Version du serveur :  5.5.38
-- Version de PHP :  5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `primavera`
--

-- --------------------------------------------------------

--
-- Structure de la table `danger_prim`
--

CREATE TABLE `danger_prim` (
`iddanger` int(11) NOT NULL,
  `niveau_danger` int(11) NOT NULL,
  `nom` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `danger_prim`
--

INSERT INTO `danger_prim` (`iddanger`, `niveau_danger`, `nom`) VALUES
(1, 5001, 'TestDanger1'),
(5, 2, 'TestDanger2'),
(6, 3, 'TestDanger3');

-- --------------------------------------------------------

--
-- Structure de la table `description_prim`
--

CREATE TABLE `description_prim` (
`iddescription` int(11) NOT NULL,
  `description` varchar(45) COLLATE utf8_bin NOT NULL,
  `dateCreation` datetime NOT NULL,
  `userCreateurFK` int(11) DEFAULT NULL,
  `ficheFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `description_prim`
--

INSERT INTO `description_prim` (`iddescription`, `description`, `dateCreation`, `userCreateurFK`, `ficheFK`) VALUES
(1, 'Description Test8', '2015-04-26 03:04:47', 4, 1),
(2, 'Description Test7', '2015-04-26 03:04:47', 4, 1),
(3, 'Description Test5tt', '2015-04-26 03:04:47', 4, 1),
(4, 'Description Test6', '2015-04-26 03:04:47', 4, 1),
(17, 'Description Test8', '2015-04-26 03:05:59', 4, 5),
(18, 'Description Test7', '2015-04-26 03:05:59', 4, 5),
(19, 'Description Test5tt', '2015-04-26 03:05:59', 4, 5),
(20, 'Description Test6', '2015-04-26 03:05:59', 4, 5),
(21, 'Description Test8', '2015-04-26 03:06:17', 4, 6),
(22, 'Description Test7', '2015-04-26 03:06:17', 4, 6),
(23, 'Description Test5tt', '2015-04-26 03:06:17', 4, 6),
(24, 'Description Test6', '2015-04-26 03:06:17', 4, 6),
(25, 'Description Test8', '2015-04-26 03:06:54', 4, 7),
(26, 'Description Test5tt', '2015-04-26 03:06:54', 4, 7),
(27, 'Description Test6', '2015-04-26 03:06:54', 4, 7),
(28, 'Description Test7', '2015-04-26 03:06:54', 4, 7),
(33, 'Description Test7', '2015-04-26 03:08:27', 4, 9),
(34, 'Description Test6', '2015-04-26 03:08:27', 4, 9),
(35, 'Description Test8', '2015-04-26 03:08:27', 4, 9),
(36, 'Description Test5tt', '2015-04-26 03:08:27', 4, 9),
(37, 'Description Test6', '2015-04-26 03:09:47', 4, 10),
(38, 'Description Test5tt', '2015-04-26 03:09:47', 4, 10),
(39, 'Description Test7', '2015-04-26 03:09:47', 4, 10),
(40, 'Description Test8', '2015-04-26 03:09:47', 4, 10),
(57, 'txtDescriptionServiceTest', '2015-04-26 03:35:17', 4, 15),
(58, 'txtDescriptionServiceTest', '2015-04-26 03:39:28', 4, 16),
(59, 'txtDescriptionServiceTest', '2015-04-26 06:45:34', 4, 17),
(60, '', '2015-05-17 06:40:41', 1005, 18),
(61, 'je teste l''interface', '2015-05-17 06:42:10', 1005, 19),
(62, 'teste interface marie', '2015-05-17 06:52:31', 1002, 20),
(63, 'teste d''envoie de fiche via interface', '2015-05-17 11:37:13', 1005, 20),
(64, 'test2 envoie de fiche via interface', '2015-05-17 11:52:00', 1005, 20),
(65, 'envoie via un interface a un chef de chantier', '2015-05-17 11:53:23', 1005, 20),
(66, 'blablabla', '2015-05-17 12:00:09', 1005, 19),
(67, 'fghjklmù', '2015-05-17 12:01:40', 1005, 18),
(68, 'sqdklmsqdlùmqsmd', '2015-05-17 12:03:47', 1005, 19),
(69, 'sefklmdslmfklmdskf', '2015-05-17 12:04:06', 1005, 19),
(70, 'sqkdjksqjdklsqkjljlksqjdlk', '2015-05-17 12:05:37', 1005, 18),
(71, 'lksdkmlskdmsqkdklqs', '2015-05-17 12:05:52', 1005, 18),
(72, 'teste riverains via interface', '2015-05-17 18:38:15', 1005, 21),
(73, 'teste mairie via interface', '2015-05-17 18:38:46', 1005, 21),
(74, 'teste inspecteur via interface', '2015-05-17 18:39:16', 1005, 21),
(75, 'dqqsdsqdsdsd', '2015-05-17 19:39:07', 1005, 22),
(76, 'test interface admin', '2015-05-19 19:22:51', 1005, 23),
(77, 'test interface admin', '2015-05-19 19:23:21', 1005, 23),
(82, 'Description Test7', '2015-05-19 22:15:08', 4, 25),
(83, 'Description Test5tt', '2015-05-19 22:15:08', 4, 25),
(84, 'Description Test6', '2015-05-19 22:15:08', 4, 25),
(85, 'Description Test8', '2015-05-19 22:15:08', 4, 25),
(86, 'teste remplissage message groupe', '2015-05-19 23:49:16', 1005, 7),
(87, 'azertyuiop', '2015-05-19 23:49:42', 1005, 6),
(88, 'azertyuiop', '2015-05-19 23:49:59', 1005, 9),
(89, 'sdsfdsfdsfds', '2015-05-20 00:08:12', 1005, 5),
(90, '', '2015-05-20 00:35:32', 1005, 9),
(91, 'azuhjdkzapldâzd^pazpdpezakdea', '2015-05-20 23:58:44', 1005, 26),
(92, 'azm;meazme;mzad;maz;dm;azm;d;mza;dmza;mza sqd', '2015-05-20 23:59:13', 1005, 28),
(93, 'azdpza^kldp^zadpzaldzap^dlpazldplazd^paz', '2015-05-20 23:59:30', 1005, 29),
(94, 'qs;dm;sqm;dmùsq;dqsmùdmùsq;md;mqls,dlsq', '2015-05-21 00:00:23', 1005, 33),
(95, 'zaeoza,ezaknejazneazneoaizeozaekkaze', '2015-05-21 00:01:15', 1005, 34),
(96, 'qdopqskdksqdkpqdsopopqsdo', '2015-05-21 00:01:26', 1005, 35),
(97, 'dsoqsd,qspod,qs,d', '2015-05-21 00:01:35', 1005, 36),
(98, 'azldpazlepâpz^le^plz', '2015-05-21 00:01:59', 1005, 37),
(99, 'zadklkazpdp,azpd,opaz,dp,zadopazdpo,zadop', '2015-05-21 00:02:08', 1005, 38),
(100, 'dzakdkazpkdkazdopazkdozakdkd', '2015-05-21 00:02:17', 1005, 39),
(101, 'azldkzadpoaz,d,zad,az,dopza,dopaz', '2015-05-21 00:02:27', 1005, 40),
(102, '', '2015-05-21 00:02:56', 1005, 22),
(103, '', '2015-05-21 00:02:58', 1005, 29),
(104, '', '2015-05-21 00:03:01', 1005, 26),
(105, '', '2015-05-21 00:03:03', 1005, 28),
(106, '', '2015-05-21 00:03:05', 1005, 33),
(107, '', '2015-05-21 00:03:07', 1005, 34),
(108, '', '2015-05-21 00:03:10', 1005, 35),
(109, '', '2015-05-21 00:03:13', 1005, 36),
(110, '', '2015-05-21 00:03:15', 1005, 37),
(111, '', '2015-05-21 00:03:18', 1005, 38),
(112, '', '2015-05-21 00:03:22', 1005, 39),
(113, '', '2015-05-21 00:03:24', 1005, 40),
(114, '', '2015-05-21 00:03:36', 1005, 22),
(115, '', '2015-05-21 00:03:38', 1005, 23),
(116, '', '2015-05-21 00:03:42', 1005, 29),
(117, '', '2015-05-21 00:03:44', 1005, 26),
(118, '', '2015-05-21 00:03:46', 1005, 28),
(119, '', '2015-05-21 00:03:49', 1005, 33),
(120, '', '2015-05-21 00:03:50', 1005, 34),
(121, '', '2015-05-21 00:03:52', 1005, 35),
(122, '', '2015-05-21 00:03:54', 1005, 36),
(123, '', '2015-05-21 00:03:57', 1005, 37),
(124, '', '2015-05-21 00:04:07', 1005, 38),
(125, '', '2015-05-21 00:04:10', 1005, 39),
(126, '', '2015-05-21 00:04:12', 1005, 40),
(127, '', '2015-05-21 01:20:48', 1005, 6),
(128, '', '2015-05-21 01:20:57', 1005, 7);

-- --------------------------------------------------------

--
-- Structure de la table `etat_prim`
--

CREATE TABLE `etat_prim` (
`idetat` int(11) NOT NULL,
  `etat` varchar(45) COLLATE utf8_bin NOT NULL,
  `groupe` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `etat_prim`
--

INSERT INTO `etat_prim` (`idetat`, `etat`, `groupe`) VALUES
(1, 'EtatTest1', 0),
(2, 'EtatTest2', 0),
(3, 'EtatTest3', 0),
(5, 'EtatTest4', 0),
(1001, 'rapport riverain', 0),
(1002, 'objectif inspecteur', 0),
(1003, 'rapport inspecteur', 0),
(1004, 'objectifs chef de chantier', 1),
(1005, 'rapport chef de chantier', 1),
(1006, 'cloturer', 1);

-- --------------------------------------------------------

--
-- Structure de la table `etat_role_prim`
--

CREATE TABLE `etat_role_prim` (
  `etatFK` int(11) NOT NULL,
  `roleFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `etat_role_prim`
--

INSERT INTO `etat_role_prim` (`etatFK`, `roleFK`) VALUES
(1001, 1002),
(1003, 1002),
(1005, 1002),
(1002, 1003),
(1004, 1004),
(1001, 1005),
(1002, 1005),
(1003, 1005),
(1004, 1005),
(1005, 1005);

-- --------------------------------------------------------

--
-- Structure de la table `fiche_prim`
--

CREATE TABLE `fiche_prim` (
`idfiche` int(11) NOT NULL,
  `titre` varchar(45) COLLATE utf8_bin NOT NULL,
  `longitude` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `latitude` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `dateCreation` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `rempli` tinyint(4) DEFAULT '0',
  `userCreateurFK` int(11) DEFAULT NULL,
  `userHistoFK` int(11) DEFAULT NULL,
  `dangerFK` int(11) DEFAULT NULL,
  `etatFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `fiche_prim`
--

INSERT INTO `fiche_prim` (`idfiche`, `titre`, `longitude`, `latitude`, `dateCreation`, `dateFin`, `rempli`, `userCreateurFK`, `userHistoFK`, `dangerFK`, `etatFK`) VALUES
(1, 'titre Test2', '0.0', '0.0', '2015-04-26 03:04:47', NULL, 0, 4, 5, 1, 2),
(5, 'titre Test2', '0.0', '0.0', '2015-04-26 03:05:59', NULL, 0, 4, 6, 1, 1006),
(6, 'titre Test2', '2.2652212', '48.8316194', '2015-04-26 03:06:17', NULL, 0, 4, 5, 1, 1006),
(7, 'titre Test2', '0.0', '0.0', '2015-04-26 03:06:54', NULL, 0, 4, NULL, 1, 1006),
(9, 'titre Test2', '0.0', '0.0', '2015-04-26 03:08:27', NULL, 0, 6, 4, 1, 1006),
(10, 'titre Test2', '0.0', '0.0', '2015-04-26 03:09:47', NULL, 0, 4, NULL, 1, 2),
(15, 'titreServiceTest', '0.0', '0.0', '2015-04-26 03:35:17', NULL, 0, 4, 5, 1, 2),
(16, 'titreServiceTest', '0.0', '0.0', '2015-04-26 03:39:28', NULL, 0, 4, 5, 1, 2),
(17, 'titreServiceTest', '0.0', '0.0', '2015-04-26 06:45:34', NULL, 0, 4, 5, 1, 2),
(18, '', '0.0', '0.0', '2015-05-17 06:40:41', NULL, 0, 1005, 1004, 1, 1004),
(19, 'test interface', '0.0', '0.0', '2015-05-17 06:42:10', NULL, 0, 1005, NULL, 5, 1004),
(20, 'teste interface mairie', '0.0', '0.0', '2015-05-17 06:52:31', NULL, 0, 1002, NULL, 1, 1004),
(21, 'test riverains', '0.0', '0.0', '2015-05-17 18:38:15', NULL, 0, 1005, NULL, 5, 1004),
(22, 'titre test', '0.0', '0.0', '2015-05-17 19:39:07', NULL, 0, 1005, NULL, 1, 1003),
(23, 'test interface admin', '0.0', '0.0', '2015-05-19 19:22:51', NULL, 0, 1005, NULL, 5, 1003),
(25, 'titre Test2boolean', 'longitude Test2', 'latitude Test2', '2015-05-19 22:15:08', NULL, 1, 4, NULL, 1, 2),
(26, 'zerthhbvghjk', '0.0', '0.0', '2015-05-20 23:58:44', NULL, 0, 1005, NULL, 5, 1003),
(28, 'azedlmaze;az;em;azm;dmazme;', '0.0', '0.0', '2015-05-20 23:59:13', NULL, 0, 1005, NULL, 6, 1003),
(29, 'azdazkdokoazkdokapzkdpkazpd', '0.0', '0.0', '2015-05-20 23:59:30', NULL, 0, 1005, NULL, 1, 1003),
(33, 'sd,lqsldm;qsm;dsmqù;d', '0.0', '0.0', '2015-05-21 00:00:23', NULL, 0, 1005, NULL, 1, 1003),
(34, 'zae,zaek,za', '0.0', '0.0', '2015-05-21 00:01:15', NULL, 0, 1005, NULL, 1, 1004),
(35, 'skdoqksdq,s,sqk,dkqsk', '0.0', '0.0', '2015-05-21 00:01:26', NULL, 0, 1005, NULL, 1, 1003),
(36, 'zaekppzae,po,z,dpaz', '0.0', '0.0', '2015-05-21 00:01:35', NULL, 0, 1005, NULL, 1, 1003),
(37, 'zakezapkep^kza', '0.0', '0.0', '2015-05-21 00:01:59', NULL, 0, 1005, NULL, 1, 1003),
(38, 'akzpdkazkda', '0.0', '0.0', '2015-05-21 00:02:08', NULL, 0, 1005, NULL, 1, 1003),
(39, 'azkdkza^dpoazdpo,pzao', '0.0', '0.0', '2015-05-21 00:02:17', NULL, 0, 1005, NULL, 1, 1003),
(40, 'azkoazeozaope', '0.0', '0.0', '2015-05-21 00:02:27', NULL, 0, 1005, NULL, 1, 1003);

-- --------------------------------------------------------

--
-- Structure de la table `groupe_fiche_prim`
--

CREATE TABLE `groupe_fiche_prim` (
  `ficheFK` int(11) NOT NULL,
  `groupeFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `groupe_fiche_prim`
--

INSERT INTO `groupe_fiche_prim` (`ficheFK`, `groupeFK`) VALUES
(5, 2),
(6, 2),
(7, 2),
(9, 2),
(5, 3),
(6, 3),
(7, 3),
(9, 3),
(5, 4),
(6, 4),
(7, 4),
(9, 4),
(5, 5),
(6, 5),
(7, 5),
(9, 5),
(5, 6),
(6, 6),
(7, 6),
(9, 6),
(5, 7),
(6, 7),
(7, 7),
(9, 7),
(5, 8),
(6, 8),
(7, 8),
(9, 8),
(5, 9),
(6, 9),
(7, 9),
(9, 9),
(5, 10),
(6, 10),
(7, 10),
(5, 11),
(6, 11),
(7, 11),
(5, 12),
(6, 12),
(7, 12),
(5, 13),
(6, 13),
(7, 13),
(9, 13),
(33, 14),
(34, 14),
(21, 15),
(22, 15),
(34, 15),
(21, 16),
(34, 16);

-- --------------------------------------------------------

--
-- Structure de la table `groupe_prim`
--

CREATE TABLE `groupe_prim` (
`idgroupe` int(11) NOT NULL,
  `titre` varchar(45) COLLATE utf8_bin NOT NULL,
  `description` varchar(45) COLLATE utf8_bin NOT NULL,
  `dateCreation` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `userCreateurFK` int(11) DEFAULT NULL,
  `etatFK` int(11) DEFAULT NULL,
  `userHistoFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `groupe_prim`
--

INSERT INTO `groupe_prim` (`idgroupe`, `titre`, `description`, `dateCreation`, `dateFin`, `userCreateurFK`, `etatFK`, `userHistoFK`) VALUES
(2, 'TitreTest', 'descriptionTest', '2015-04-26 03:11:23', NULL, 6, 1, NULL),
(3, 'TitreTest', 'descriptionTest', '2015-04-26 03:11:29', NULL, 4, 1, 6),
(4, 'TitreTest', 'descriptionTest', '2015-04-26 03:11:37', NULL, 4, 1, 6),
(5, 'TitreTest', 'descriptionTest', '2015-04-26 03:12:35', NULL, 6, 1, NULL),
(6, 'TitreTest', 'descriptionTest', '2015-04-26 03:13:03', NULL, 6, 1, NULL),
(7, 'TitreTest', 'descriptionTest', '2015-04-26 03:15:52', NULL, 6, 1006, NULL),
(8, 'TitreTest', 'descriptionTest', '2015-04-26 03:17:37', NULL, 6, 1, NULL),
(9, 'TitreTest', 'descriptionTest', '2015-04-26 03:21:45', NULL, 6, 1, NULL),
(10, 'titre', 'description', '2015-04-26 03:38:42', NULL, 4, 2, 5),
(11, 'titre', 'description', '2015-04-26 03:39:45', NULL, 4, 2, 5),
(12, 'titre', 'description', '2015-04-26 06:46:00', NULL, 4, 2, 5),
(13, 'TitreTest', 'descriptionTest', '2015-05-17 19:14:00', NULL, 6, 1, NULL),
(14, 'test creation de groupe via interface', 'test creation de groupe via interface', '2015-05-21 01:23:11', NULL, 1005, 1003, NULL),
(15, 'azertyui', 'azertyui', '2015-05-21 01:27:06', NULL, 1005, 1004, NULL),
(16, 'zerty', 'azertyu', '2015-05-21 01:29:50', NULL, 1005, 1004, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `photo_prim`
--

CREATE TABLE `photo_prim` (
`idphoto` int(11) NOT NULL,
  `lien` varchar(45) COLLATE utf8_bin NOT NULL,
  `ficheFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `photo_prim`
--

INSERT INTO `photo_prim` (`idphoto`, `lien`, `ficheFK`) VALUES
(1, 'LienPhoto Test4', 1),
(2, 'LienPhoto Test3', 1),
(3, 'LienPhoto Test5', 1),
(9, 'LienPhoto Test2', 5),
(10, 'LienPhoto Test1', 5),
(11, 'LienPhoto Test', 5),
(12, 'LienPhoto Test8', 6),
(13, 'LienPhoto Test7', 6),
(14, 'LienPhoto Test9', 6),
(15, 'LienPhoto Test12', 7),
(16, 'LienPhoto Test10', 7),
(17, 'LienPhoto Test11', 7),
(19, 'LienPhoto Test14', 9),
(20, 'LienPhoto Test15', 9),
(21, 'LienPhoto Test13', 9),
(22, 'LienPhoto Test17', 10),
(23, 'LienPhoto Test16', 10),
(24, 'LienPhoto Test18', 10),
(26, 'LienPhoto Test21', 25),
(27, 'LienPhoto Test22', 25),
(28, 'LienPhoto Test23', 25);

-- --------------------------------------------------------

--
-- Structure de la table `role_prim`
--

CREATE TABLE `role_prim` (
`idrole` int(11) NOT NULL,
  `nom` varchar(45) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `role_prim`
--

INSERT INTO `role_prim` (`idrole`, `nom`) VALUES
(1005, 'admin'),
(1004, 'chef de chantier'),
(1003, 'inspecteur'),
(1002, 'mairie'),
(1001, 'riverains'),
(19, 'role test1'),
(34, 'role test10'),
(20, 'role test2'),
(16, 'role test3'),
(17, 'role test4'),
(9, 'role test5');

-- --------------------------------------------------------

--
-- Structure de la table `role_service_prim`
--

CREATE TABLE `role_service_prim` (
  `roleFK` int(11) NOT NULL,
  `serviceFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `role_service_prim`
--

INSERT INTO `role_service_prim` (`roleFK`, `serviceFK`) VALUES
(16, 6),
(16, 7),
(17, 6),
(17, 7),
(19, 6),
(19, 7),
(20, 6),
(20, 7),
(34, 6),
(34, 7),
(1001, 1002),
(1002, 1001),
(1002, 1002),
(1002, 1004),
(1003, 1002),
(1003, 1003),
(1004, 1003),
(1005, 1001),
(1005, 1002),
(1005, 1004);

-- --------------------------------------------------------

--
-- Structure de la table `service_prim`
--

CREATE TABLE `service_prim` (
`idservice` int(11) NOT NULL,
  `nom` varchar(45) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `service_prim`
--

INSERT INTO `service_prim` (`idservice`, `nom`) VALUES
(1001, 'Cloture'),
(1002, 'CreationFiche'),
(1004, 'CreationGroupe'),
(1003, 'recupFicheParUser'),
(6, 'Service Test1'),
(7, 'Service Test2'),
(4, 'Service Test3'),
(9, 'Service Test4');

-- --------------------------------------------------------

--
-- Structure de la table `user_prim`
--

CREATE TABLE `user_prim` (
`iduser` int(11) NOT NULL,
  `nom` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mdp` varchar(45) COLLATE utf8_bin NOT NULL,
  `prénom` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `addresseMail` varchar(45) COLLATE utf8_bin NOT NULL,
  `affiliation` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `roleFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `user_prim`
--

INSERT INTO `user_prim` (`iduser`, `nom`, `mdp`, `prénom`, `addresseMail`, `affiliation`, `roleFK`) VALUES
(4, NULL, 'motDePasse2', NULL, 'addresseMail2', NULL, 20),
(5, NULL, 'motDePasse3', NULL, 'addresseMail3', NULL, 20),
(6, NULL, 'motDePasse4', NULL, 'addresseMail4', NULL, 20),
(1001, 'Riverains', 'riverains', NULL, 'riverains@test.com', NULL, 1001),
(1002, 'Marie', 'mairie', NULL, 'marie@test.com', NULL, 1002),
(1003, 'Inspecteur', 'inspecteur', NULL, 'inspecteur@test.com', NULL, 1003),
(1004, 'Chef de chantier', 'cdc', NULL, 'chefdechantier@test.com', NULL, 1004),
(1005, 'Admin', 'admin', NULL, 'admin@test.com', NULL, 1005);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `danger_prim`
--
ALTER TABLE `danger_prim`
 ADD PRIMARY KEY (`iddanger`), ADD UNIQUE KEY `niveau_danger_UNIQUE` (`niveau_danger`), ADD UNIQUE KEY `nom` (`nom`);

--
-- Index pour la table `description_prim`
--
ALTER TABLE `description_prim`
 ADD PRIMARY KEY (`iddescription`), ADD KEY `fk_description_prim_user_prim1_idx` (`userCreateurFK`), ADD KEY `fk_description_prim_fiche_prim1_idx` (`ficheFK`);

--
-- Index pour la table `etat_prim`
--
ALTER TABLE `etat_prim`
 ADD PRIMARY KEY (`idetat`), ADD UNIQUE KEY `etat_UNIQUE` (`etat`);

--
-- Index pour la table `etat_role_prim`
--
ALTER TABLE `etat_role_prim`
 ADD PRIMARY KEY (`etatFK`,`roleFK`), ADD KEY `fk_etat_prim_has_role_prim_role_prim1_idx` (`roleFK`), ADD KEY `fk_etat_prim_has_role_prim_etat_prim1_idx` (`etatFK`);

--
-- Index pour la table `fiche_prim`
--
ALTER TABLE `fiche_prim`
 ADD PRIMARY KEY (`idfiche`), ADD KEY `fk_fiche_prim_user_prim1_idx` (`userCreateurFK`), ADD KEY `fk_fiche_prim_danger_prim1_idx` (`dangerFK`), ADD KEY `fk_fiche_prim_etat_prim1_idx` (`etatFK`), ADD KEY `fk_fiche_prim_user_prim2_idx` (`userHistoFK`);

--
-- Index pour la table `groupe_fiche_prim`
--
ALTER TABLE `groupe_fiche_prim`
 ADD PRIMARY KEY (`ficheFK`,`groupeFK`), ADD KEY `fk_fiche_prim_has_groupe_prim_groupe_prim1_idx` (`groupeFK`), ADD KEY `fk_fiche_prim_has_groupe_prim_fiche_prim1_idx` (`ficheFK`);

--
-- Index pour la table `groupe_prim`
--
ALTER TABLE `groupe_prim`
 ADD PRIMARY KEY (`idgroupe`), ADD KEY `fk_groupe_prim_user_prim1_idx` (`userCreateurFK`), ADD KEY `fk_groupe_prim_etat_prim1_idx` (`etatFK`), ADD KEY `fk_groupe_prim_user_prim2_idx` (`userHistoFK`);

--
-- Index pour la table `photo_prim`
--
ALTER TABLE `photo_prim`
 ADD PRIMARY KEY (`idphoto`), ADD UNIQUE KEY `lien_UNIQUE` (`lien`), ADD KEY `fk_photo_prim_fiche_prim1_idx` (`ficheFK`);

--
-- Index pour la table `role_prim`
--
ALTER TABLE `role_prim`
 ADD PRIMARY KEY (`idrole`), ADD UNIQUE KEY `nom_UNIQUE` (`nom`);

--
-- Index pour la table `role_service_prim`
--
ALTER TABLE `role_service_prim`
 ADD PRIMARY KEY (`roleFK`,`serviceFK`), ADD KEY `fk_role_prim_has_service_prim_role_prim_idx` (`roleFK`), ADD KEY `fk_role_prim_has_service_prim_service_prim1_idx` (`serviceFK`);

--
-- Index pour la table `service_prim`
--
ALTER TABLE `service_prim`
 ADD PRIMARY KEY (`idservice`), ADD UNIQUE KEY `nom_UNIQUE` (`nom`);

--
-- Index pour la table `user_prim`
--
ALTER TABLE `user_prim`
 ADD PRIMARY KEY (`iduser`), ADD UNIQUE KEY `addresseMail_UNIQUE` (`addresseMail`), ADD KEY `fk_user_prim_role_prim1_idx` (`roleFK`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `danger_prim`
--
ALTER TABLE `danger_prim`
MODIFY `iddanger` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `description_prim`
--
ALTER TABLE `description_prim`
MODIFY `iddescription` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=129;
--
-- AUTO_INCREMENT pour la table `etat_prim`
--
ALTER TABLE `etat_prim`
MODIFY `idetat` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT pour la table `fiche_prim`
--
ALTER TABLE `fiche_prim`
MODIFY `idfiche` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT pour la table `groupe_prim`
--
ALTER TABLE `groupe_prim`
MODIFY `idgroupe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT pour la table `photo_prim`
--
ALTER TABLE `photo_prim`
MODIFY `idphoto` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT pour la table `role_prim`
--
ALTER TABLE `role_prim`
MODIFY `idrole` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1006;
--
-- AUTO_INCREMENT pour la table `service_prim`
--
ALTER TABLE `service_prim`
MODIFY `idservice` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1005;
--
-- AUTO_INCREMENT pour la table `user_prim`
--
ALTER TABLE `user_prim`
MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1006;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `description_prim`
--
ALTER TABLE `description_prim`
ADD CONSTRAINT `fk_description_prim_fiche_prim1` FOREIGN KEY (`ficheFK`) REFERENCES `fiche_prim` (`idfiche`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_description_prim_user_prim1` FOREIGN KEY (`userCreateurFK`) REFERENCES `user_prim` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `etat_role_prim`
--
ALTER TABLE `etat_role_prim`
ADD CONSTRAINT `fk_etat_prim_has_role_prim_etat_prim1` FOREIGN KEY (`etatFK`) REFERENCES `etat_prim` (`idetat`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `fk_etat_prim_has_role_prim_role_prim1` FOREIGN KEY (`roleFK`) REFERENCES `role_prim` (`idrole`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `fiche_prim`
--
ALTER TABLE `fiche_prim`
ADD CONSTRAINT `fk_fiche_prim_danger_prim1` FOREIGN KEY (`dangerFK`) REFERENCES `danger_prim` (`iddanger`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_fiche_prim_etat_prim1` FOREIGN KEY (`etatFK`) REFERENCES `etat_prim` (`idetat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_fiche_prim_user_prim1` FOREIGN KEY (`userCreateurFK`) REFERENCES `user_prim` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_fiche_prim_user_prim2` FOREIGN KEY (`userHistoFK`) REFERENCES `user_prim` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `groupe_fiche_prim`
--
ALTER TABLE `groupe_fiche_prim`
ADD CONSTRAINT `fk_fiche_prim_has_groupe_prim_fiche_prim1` FOREIGN KEY (`ficheFK`) REFERENCES `fiche_prim` (`idfiche`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_fiche_prim_has_groupe_prim_groupe_prim1` FOREIGN KEY (`groupeFK`) REFERENCES `groupe_prim` (`idgroupe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `groupe_prim`
--
ALTER TABLE `groupe_prim`
ADD CONSTRAINT `fk_groupe_prim_etat_prim1` FOREIGN KEY (`etatFK`) REFERENCES `etat_prim` (`idetat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_groupe_prim_user_prim1` FOREIGN KEY (`userCreateurFK`) REFERENCES `user_prim` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_groupe_prim_user_prim2` FOREIGN KEY (`userHistoFK`) REFERENCES `user_prim` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `photo_prim`
--
ALTER TABLE `photo_prim`
ADD CONSTRAINT `fk_photo_prim_fiche_prim1` FOREIGN KEY (`ficheFK`) REFERENCES `fiche_prim` (`idfiche`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `role_service_prim`
--
ALTER TABLE `role_service_prim`
ADD CONSTRAINT `fk_role_prim_has_service_prim_role_prim` FOREIGN KEY (`roleFK`) REFERENCES `role_prim` (`idrole`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `fk_role_prim_has_service_prim_service_prim1` FOREIGN KEY (`serviceFK`) REFERENCES `service_prim` (`idservice`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `user_prim`
--
ALTER TABLE `user_prim`
ADD CONSTRAINT `fk_user_prim_role_prim1` FOREIGN KEY (`roleFK`) REFERENCES `role_prim` (`idrole`) ON DELETE NO ACTION ON UPDATE NO ACTION;
