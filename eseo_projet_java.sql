
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


DROP TABLE IF EXISTS `note`;
DROP TABLE IF EXISTS `ue`;
DROP TABLE IF EXISTS `matiere`;
DROP TABLE IF EXISTS `semestre`;
DROP TABLE IF EXISTS `personne`;
DROP TABLE IF EXISTS `adresse`;

CREATE TABLE IF NOT EXISTS `note` (
  `id` int(11) unsigned NOT NULL,
  `nom` varchar(60) DEFAULT NULL,
  `valeur` float(4,2) DEFAULT NULL,
  `coefficient` float(4,2) DEFAULT NULL,
  `id_matiere` int(11) unsigned NOT NULL,
  `id_personne` int(11) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


TRUNCATE TABLE `note`;

CREATE TABLE IF NOT EXISTS `ue` (
  `id` int(11) NOT NULL,
  `nom` varchar(60) NOT NULL,
  `coefficient` float(4,2) DEFAULT NULL,
  `id_matiere` int(11) unsigned DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


TRUNCATE TABLE `ue`;

CREATE TABLE IF NOT EXISTS `matiere` (
  `id` int(11) unsigned NOT NULL,
  `nom` varchar(60) NOT NULL,
  `coefficient` float(4,2) NOT NULL,
  `moyenne` float(4,2) DEFAULT NULL,
  `id_responsable` int(11) unsigned DEFAULT NULL,
  `id_semestre` int(11) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


TRUNCATE TABLE `matiere`;

CREATE TABLE IF NOT EXISTS `semestre` (
  `id` int(11) unsigned NOT NULL,
  `nom` varchar(60) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `validation` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



TRUNCATE TABLE `semestre`;

CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) unsigned NOT NULL,
  `numero` int(3) NOT NULL,
  `rue` varchar(60) NOT NULL,
  `code_postal` int(5) NOT NULL,
  `ville` varchar(60) NOT NULL,
  `pays` varchar(60) NOT NULL,
  `nom_adresse` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


TRUNCATE TABLE `adresse`;


CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) unsigned NOT NULL,
  `nom` varchar(60) NOT NULL,
  `prenom` varchar(60) NOT NULL,
  `date_de_naissance` date NOT NULL,
  `email_professionel` varchar(60) NOT NULL,
  `email_personnel` varchar(60) DEFAULT NULL,
  `telephone_fixe` int(10) DEFAULT NULL,
  `telephone_mobile` int(10) DEFAULT NULL,
  `identifiant` varchar(60) NOT NULL,
  `annee_arrivee` year(4) NOT NULL,
  `promotion` varchar(60) DEFAULT NULL,
  `redoublant` tinyint(1) NOT NULL DEFAULT '0',
  `adresse` int(11) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



TRUNCATE TABLE `personne`;


ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_responsable` (`id_responsable`),
  ADD KEY `id_semestre` (`id_semestre`);


ALTER TABLE `note`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_matiere` (`id_matiere`),
  ADD KEY `id_personne` (`id_personne`);


ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `adresse` (`adresse`);


ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `ue`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_matiere` (`id_matiere`) USING BTREE,
  ADD KEY `id_matiere_2` (`id_matiere`);



ALTER TABLE `adresse`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;

ALTER TABLE `matiere`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;

ALTER TABLE `note`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;

ALTER TABLE `personne`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;

ALTER TABLE `semestre`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT;
ALTER TABLE `ue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;



ALTER TABLE `matiere`
  ADD CONSTRAINT `matiere_ibfk_1` FOREIGN KEY (`id_semestre`) REFERENCES `semestre` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `matiere_ibfk_2` FOREIGN KEY (`id_responsable`) REFERENCES `personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `personne`
  ADD CONSTRAINT `personne_ibfk_1` FOREIGN KEY (`adresse`) REFERENCES `adresse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `ue`
  ADD CONSTRAINT `ue_ibfk_1` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE  `personne` CHANGE  `adresse`  `adresse` INT( 11 ) UNSIGNED NULL;

INSERT INTO `eseo_projet_java`.`personne` (`id`, `nom`, `prenom`, `date_de_naissance`, `email_professionel`, `email_personnel`, `telephone_fixe`, `telephone_mobile`, `identifiant`, `annee_arrivee`, `promotion`, `redoublant`, `adresse`) VALUES (NULL, 'Administrateur', 'Administrateur', '1970-01-01', 'administrateur@eseo.fr', NULL, NULL, NULL, 'admin', '1970', 'Administrateur', '0', NULL);