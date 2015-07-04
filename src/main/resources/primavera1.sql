-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mer 27 Mai 2015 à 17:05
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
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `danger_prim`
--

INSERT INTO `danger_prim` (`iddanger`, `niveau_danger`, `nom`) VALUES
(1001, 1, 'faible'),
(1002, 2, 'moyen'),
(1003, 3, 'fort');

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
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `etat_prim`
--

CREATE TABLE `etat_prim` (
`idetat` int(11) NOT NULL,
  `etat` varchar(45) COLLATE utf8_bin NOT NULL,
  `groupe` tinyint(1) NOT NULL,
  `remObligatoire` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `etat_prim`
--

INSERT INTO `etat_prim` (`idetat`, `etat`, `groupe`, `remObligatoire`) VALUES
(1001, 'rapport riverain', 0, 0),
(1002, 'objectif inspecteur', 0, 1),
(1003, 'rapport inspecteur', 0, 0),
(1004, 'objectifs chef de chantier', 1, 1),
(1005, 'rapport chef de chantier', 1, 1),
(1006, 'cloturer', 0, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_fiche_prim`
--

CREATE TABLE `groupe_fiche_prim` (
  `ficheFK` int(11) NOT NULL,
  `groupeFK` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `photo_prim`
--

CREATE TABLE `photo_prim` (
`idphoto` int(11) NOT NULL,
  `lien` varchar(45) COLLATE utf8_bin NOT NULL,
  `ficheFK` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
(1003, 1002),
(1003, 1003),
(1004, 1003),
(1005, 1001),
(1005, 1002),
(1005, 1004),
(1005, 1005),
(1005, 1006);

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
) ENGINE=InnoDB AUTO_INCREMENT=1007 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `user_prim`
--

INSERT INTO `user_prim` (`iduser`, `nom`, `mdp`, `prénom`, `addresseMail`, `affiliation`, `roleFK`) VALUES
(1001, 'POTELET', 'riverain', 'marie', 'potelet@riverain.com', 'battiment', 1001),
(1002, 'CHEVAL', 'mairie', 'claire', 'cheval@mairie.com', 'mairie', 1002),
(1003, 'CHARLOT', 'inspecteur', 'patrick', 'charlot@inspecteur.com', 'mairie', 1003),
(1004, 'dupond', 'cdc', 'jean', 'dupond@chefdechantier.com', 'mairie', 1004),
(1005, 'MARCHER', 'admin', 'benjamin', 'marcher@admin.com', 'mairie', 1005),
(1006, 'SIMON', 'inspecteur', 'pauline', 'simon@inspecteur.com', 'mairie', 1003);

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
MODIFY `iddanger` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1004;
--
-- AUTO_INCREMENT pour la table `description_prim`
--
ALTER TABLE `description_prim`
MODIFY `iddescription` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=148;
--
-- AUTO_INCREMENT pour la table `etat_prim`
--
ALTER TABLE `etat_prim`
MODIFY `idetat` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT pour la table `fiche_prim`
--
ALTER TABLE `fiche_prim`
MODIFY `idfiche` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT pour la table `groupe_prim`
--
ALTER TABLE `groupe_prim`
MODIFY `idgroupe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
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
MODIFY `idservice` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1007;
--
-- AUTO_INCREMENT pour la table `user_prim`
--
ALTER TABLE `user_prim`
MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1007;
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
