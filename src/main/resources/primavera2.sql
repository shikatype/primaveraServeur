-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mer 27 Mai 2015 à 16:36
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
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `danger_prim`
--

INSERT INTO `danger_prim` (`iddanger`, `niveau_danger`, `nom`) VALUES
(1001, 1, 'très faible'),
(1002, 2, 'faible'),
(1003, 3, 'moyen'),
(1004, 4, 'fort'),
(1005, 5, 'très fort');

-- --------------------------------------------------------

--
-- Structure de la table `description_prim`
--

CREATE TABLE `description_prim` (
`iddescription` int(11) NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `dateCreation` datetime NOT NULL,
  `userCreateurFK` int(11) DEFAULT NULL,
  `ficheFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `description_prim`
--

INSERT INTO `description_prim` (`iddescription`, `description`, `dateCreation`, `userCreateurFK`, `ficheFK`) VALUES
(148, 'j''ai vu un trou énorme au niveau du bâtiment 64 de la résidence 26', '2015-05-24 05:56:55', 1001, 47),
(149, 'j''ai vu une fissure au niveau de la bouche d''égout a l''angle de la rue pierre des trois', '2015-05-24 05:57:50', 1001, 48),
(150, 'troue dans le trottoire saint germain', '2015-05-24 05:58:18', 1001, 49),
(151, 'un dégât des eau a causé la chute d''un arbre', '2015-05-24 05:59:02', 1001, 50),
(152, 'la station de bus carmin a une vitre cassé', '2015-05-24 05:59:48', 1001, 51),
(153, 'la poubelle de l''avenue charle du Apres est cassé', '2015-05-24 06:08:00', 1002, 52),
(154, 'poubelle cassé dans la rue henri', '2015-05-24 06:10:02', 1002, 53),
(155, 'objectif de bas niveau', '2015-05-24 06:11:24', 1002, 48),
(156, 'objectif de bas niveau mais a vérifié ', '2015-05-24 06:11:43', 1002, 50),
(157, 'envoyer assez rapidement un inspecteur', '2015-05-24 06:12:01', 1002, 49),
(158, 'envoyer en urgence un inspecteur ', '2015-05-24 06:12:23', 1002, 47),
(159, 'envoyer un inspecteur tous de suite', '2015-05-24 06:12:51', 1002, 51),
(160, 'si on a le temps', '2015-05-24 06:13:05', 1002, 52),
(161, 'test de creation de fiche via l''admin', '2015-05-24 06:14:51', 1007, 54),
(163, 'la vitre est bien cassé.\r\nil y a des risque de blessure envoyer une equipe retirer le restant de vitre.', '2015-05-24 06:24:56', 1004, 51),
(164, 'le trou est énorme c''est incroyable c''est au niveau du mur le béton est complètement trouer', '2015-05-24 06:25:44', 1004, 47),
(165, 'la poubelle est vraiment cassé faudrait la changé mais aucun risque pour les riverains', '2015-05-24 06:37:00', 1008, 52),
(166, 'confirmation du danger, il faut s''en charger très très vite!!', '2015-05-24 06:40:28', 1003, 47),
(167, 'danger possible pour les riverains il faudrait retirer le verre cassé au moins', '2015-05-24 06:41:04', 1003, 51),
(170, 'couler du ciment dans le trou pour reboucher', '2015-05-24 06:58:43', 1005, 47),
(171, 'deblayer moi tous le verre restant', '2015-05-24 06:59:05', 1005, 51),
(172, 'c''est bon plus de verre en vu', '2015-05-24 07:06:38', 1006, 51),
(173, 'le ciment a étais coulé plus aucune trace et tous va bien mtn', '2015-05-24 07:07:05', 1006, 47),
(174, 'c''est ok', '2015-05-24 07:07:53', 1005, 51),
(175, 'c''est bon', '2015-05-24 07:08:00', 1005, 47),
(176, 'fin de la fiche cloture', '2015-05-24 07:08:36', 1002, 51),
(177, 'fin de l''alerte cloture', '2015-05-24 07:08:55', 1002, 47),
(178, 'zaezae', '2015-05-24 22:51:33', 1007, 55),
(179, 'c''est bon c''est remplie', '2015-05-25 01:13:42', 1004, 55),
(180, 'ok je remplie', '2015-05-25 01:14:30', 1003, 55),
(181, 'azertyuio', '2015-05-25 01:18:12', 1005, 55),
(182, 'azertyuivjbvbnlknbvbn,;:nb\r\n\r\ndsnfknsdkfn', '2015-05-25 01:18:52', 1006, 55),
(183, 'tous a bien étais fait!!!', '2015-05-25 01:20:30', 1002, 55),
(184, 'azety', '2015-05-25 17:32:15', 1007, 56),
(185, 'azertyu', '2015-05-26 20:47:58', 1007, 56),
(186, 'azertyu', '2015-05-26 20:48:22', 1007, 48),
(187, 'xdfghjk', '2015-05-27 00:20:28', 1007, 57),
(188, 'qsdsqd', '2015-05-27 14:52:46', 1007, 58),
(189, 'zeazeaz', '2015-05-27 15:02:35', 1007, 49),
(190, 'azehazehkhzaeih', '2015-05-27 15:02:54', 1007, 53);

-- --------------------------------------------------------

--
-- Structure de la table `etat_prim`
--

CREATE TABLE `etat_prim` (
`idetat` int(11) NOT NULL,
  `etat` varchar(45) COLLATE utf8_bin NOT NULL,
  `groupe` tinyint(1) NOT NULL,
  `remObligatoire` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `etat_prim`
--

INSERT INTO `etat_prim` (`idetat`, `etat`, `groupe`, `remObligatoire`) VALUES
(1001, 'rapport riverains', 0, 0),
(1002, 'objectif chef inspecteur', 0, 1),
(1003, 'objectif inspecteur', 1, 1),
(1004, 'rapport inspecteur', 0, 0),
(1005, 'rapport chef inspecteur', 0, 0),
(1006, 'objectif entreprise', 1, 1),
(1007, 'objectif chef de chantier', 1, 1),
(1008, 'rapport chef de chantier', 1, 0),
(1009, 'rapport entreprise', 1, 1),
(1010, 'cloture', 0, 1);

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
(1005, 1002),
(1009, 1002),
(1002, 1003),
(1004, 1003),
(1003, 1004),
(1006, 1005),
(1008, 1005),
(1007, 1006),
(1001, 1007),
(1002, 1007),
(1003, 1007),
(1004, 1007),
(1005, 1007),
(1006, 1007),
(1007, 1007),
(1008, 1007),
(1009, 1007);

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
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `fiche_prim`
--

INSERT INTO `fiche_prim` (`idfiche`, `titre`, `longitude`, `latitude`, `dateCreation`, `dateFin`, `rempli`, `userCreateurFK`, `userHistoFK`, `dangerFK`, `etatFK`) VALUES
(47, 'Trou énorme', '0.0', '0.0', '2015-05-24 05:56:55', NULL, 0, 1001, NULL, 1005, 1010),
(48, 'fissure', '0.0', '0.0', '2015-05-24 05:57:50', NULL, 0, 1001, NULL, 1001, 1004),
(49, 'troue', '0.0', '0.0', '2015-05-24 05:58:18', NULL, 0, 1001, NULL, 1003, 1004),
(50, 'eau', '0.0', '0.0', '2015-05-24 05:59:02', NULL, 0, 1001, NULL, 1002, 1002),
(51, 'station de bus', '0.0', '0.0', '2015-05-24 05:59:48', NULL, 0, 1001, NULL, 1004, 1010),
(52, 'poubelle cassé', '0.0', '0.0', '2015-05-24 06:08:00', NULL, 0, 1002, NULL, 1001, 1004),
(53, 'poubelle cassé', '0.0', '0.0', '2015-05-24 06:10:02', NULL, 0, 1002, NULL, 1001, 1004),
(54, 'admin test', '0.0', '0.0', '2015-05-24 06:14:51', NULL, 0, 1007, NULL, 1001, 1002),
(55, 'zaezae', '0.0', '0.0', '2015-05-24 22:51:33', NULL, 0, 1007, NULL, 1002, 1010),
(56, 'azerty', '2.3780751', '48.8116823', '2015-05-25 17:32:15', NULL, 0, 1007, NULL, 1003, 1002),
(57, 'dfghjk', '2.3789833', '48.8059175', '2015-05-27 00:20:28', NULL, 0, 1007, NULL, 1003, 1002),
(58, 'qdssqd', '0.0', '0.0', '2015-05-27 14:52:46', NULL, 0, 1007, NULL, 1004, 1001);

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
(48, 20),
(52, 20),
(47, 21),
(51, 21),
(47, 22),
(51, 22),
(55, 23),
(55, 24),
(49, 25),
(53, 25);

-- --------------------------------------------------------

--
-- Structure de la table `groupe_prim`
--

CREATE TABLE `groupe_prim` (
`idgroupe` int(11) NOT NULL,
  `titre` varchar(45) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `dateCreation` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `userCreateurFK` int(11) DEFAULT NULL,
  `etatFK` int(11) DEFAULT NULL,
  `userHistoFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `groupe_prim`
--

INSERT INTO `groupe_prim` (`idgroupe`, `titre`, `description`, `dateCreation`, `dateFin`, `userCreateurFK`, `etatFK`, `userHistoFK`) VALUES
(20, 'a faire en dernier', 'des fiches de niveau bas qui peuvent être fait en dernier\r\nsi on a le temps', '2015-05-24 06:17:30', NULL, 1003, 1004, NULL),
(21, 'prioritaire!!!!!', 'fiche a traiter en priorité le niveau de danger est très haut', '2015-05-24 06:18:29', NULL, 1003, 1004, NULL),
(22, 'travaux a faire en urgence!!', 'tu trouvera deux fiche a faire en urgence.\r\nles risques de danger sont très très grand', '2015-05-24 06:43:24', NULL, 1002, 1010, NULL),
(23, 'test interface', 'faire des tests', '2015-05-25 01:12:44', NULL, 1003, 1004, NULL),
(24, 'azerty', 'azerty', '2015-05-25 01:17:31', NULL, 1002, 1010, NULL),
(25, 'sxcvbnhj', 'fgfhjh', '2015-05-27 00:23:12', NULL, 1007, 1004, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `photo_prim`
--

CREATE TABLE `photo_prim` (
`idphoto` int(11) NOT NULL,
  `lien` varchar(45) COLLATE utf8_bin NOT NULL,
  `ficheFK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `role_prim`
--

CREATE TABLE `role_prim` (
`idrole` int(11) NOT NULL,
  `nom` varchar(45) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `role_prim`
--

INSERT INTO `role_prim` (`idrole`, `nom`) VALUES
(1007, 'admin'),
(1008, 'audit'),
(1006, 'chef de chantier'),
(1005, 'chef entreprise'),
(1003, 'chef inspecteur'),
(1004, 'inspecteur'),
(1002, 'mairie'),
(1001, 'riverains');

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
(1001, 1002),
(1002, 1001),
(1002, 1002),
(1002, 1004),
(1003, 1004),
(1004, 1003),
(1006, 1003),
(1007, 1001),
(1007, 1002),
(1007, 1004),
(1007, 1005),
(1007, 1006),
(1008, 1006);

-- --------------------------------------------------------

--
-- Structure de la table `service_prim`
--

CREATE TABLE `service_prim` (
`idservice` int(11) NOT NULL,
  `nom` varchar(45) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `service_prim`
--

INSERT INTO `service_prim` (`idservice`, `nom`) VALUES
(1001, 'Cloture'),
(1002, 'CreationFiche'),
(1004, 'CreationGroupe'),
(1005, 'CreationUser'),
(1006, 'recupAllFiche'),
(1003, 'recupFicheParUser');

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
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `user_prim`
--

INSERT INTO `user_prim` (`iduser`, `nom`, `mdp`, `prénom`, `addresseMail`, `affiliation`, `roleFK`) VALUES
(1001, 'POTELET', 'riverain', 'Anne', 'potelet@riverain.com', 'battiment 42', 1001),
(1002, 'BRACHET', 'mairie', 'Thierry', 'brachet@mairie.com', 'mairie', 1002),
(1003, 'GARDON', 'ci', 'Gilles', 'gardon@chefinspecteur.com', 'mairie', 1003),
(1004, 'KINTZ', 'inspecteur', 'Coleman', 'kintz@inspecteur.com', 'mairie', 1004),
(1005, 'JUAREZ', 'ce', 'Rite', 'juarez@chefentreprise.com', 'btp', 1005),
(1006, 'MARCADIE', 'cdc', 'Remi', 'marcadie@chefdechantier.com', 'btp', 1006),
(1007, 'DIEMER', 'admin', 'Francine', 'diemer@admin.com', 'KESKOY', 1007),
(1008, 'HAUTON', 'inspecteur', 'JEAN CLAUDE', 'hauton@inspecteur.com', 'mairie', 1004),
(1009, 'MARCHER', 'cdc', 'christophe', 'marche@chefdechantier.com', 'eau', 1006),
(1010, 'CHEVAL', 'audit', 'jack', 'cheval@audit.com', 'mairie', 1008);

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
MODIFY `iddanger` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1006;
--
-- AUTO_INCREMENT pour la table `description_prim`
--
ALTER TABLE `description_prim`
MODIFY `iddescription` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=191;
--
-- AUTO_INCREMENT pour la table `etat_prim`
--
ALTER TABLE `etat_prim`
MODIFY `idetat` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1011;
--
-- AUTO_INCREMENT pour la table `fiche_prim`
--
ALTER TABLE `fiche_prim`
MODIFY `idfiche` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=59;
--
-- AUTO_INCREMENT pour la table `groupe_prim`
--
ALTER TABLE `groupe_prim`
MODIFY `idgroupe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT pour la table `photo_prim`
--
ALTER TABLE `photo_prim`
MODIFY `idphoto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `role_prim`
--
ALTER TABLE `role_prim`
MODIFY `idrole` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1009;
--
-- AUTO_INCREMENT pour la table `service_prim`
--
ALTER TABLE `service_prim`
MODIFY `idservice` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT pour la table `user_prim`
--
ALTER TABLE `user_prim`
MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1011;
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
