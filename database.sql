CREATE DATABASE `Employees_Management`;
USE `Employees_Management`;

CREATE TABLE `nazioni` (
  `iso` varchar(2) NOT NULL,
  `descrizione` varchar(30) NOT NULL,
  PRIMARY KEY (`iso`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8; ;

CREATE TABLE `dipendenti` (
  `id` int NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `telefono` int(12) NOT NULL,
  `codiceFiscale` varchar(16) NOT NULL,
  `sesso` char(1) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `NAZIONE_FK_DIPENDENTI` (`iso`),
FOREIGN KEY (`iso`) REFERENCES `nazioni` (`iso`))ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `regioni` (
  `descrizione_reg` varchar(30) NOT NULL,
  PRIMARY KEY (`descrizione_reg`),
FOREIGN KEY (`iso`) REFERENCES `nazioni` (`iso`))ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `province` (
  `id_prov` varchar(2) NOT NULL,
  `descrizione_prov` varchar(30) NOT NULL,
  PRIMARY KEY (`id_prov`),
FOREIGN KEY (`descrizione_reg`) REFERENCES `regioni` (`descrizione_reg`))ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `citta` (
  `id_citta` int(20) NOT NULL,
  `descrizione_citta` varchar(50) NOT NULL,
  PRIMARY KEY (`id_citta`),
 FOREIGN KEY (`descrizione_prov`) REFERENCES `province` (`descrizione_prov`))ENGINE=InnoDB DEFAULT CHARSET=utf8;