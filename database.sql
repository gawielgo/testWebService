CREATE DATABASE IF NOT EXISTS Employees_Management;
USE Employees_Management;

DROP TABLE IF EXISTS nazioni;
CREATE TABLE nazioni (
  iso varchar(2) NOT NULL PRIMARY KEY,
  descrizione varchar(30) NOT NULL
);

DROP TABLE IF EXISTS dipendenti;
CREATE TABLE dipendenti (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  nome varchar(20) NOT NULL,
  cognome varchar(30) NOT NULL,
  telefonO int(12) NOT NULL,
  codiceFiscale varchar(16) NOT NULL,
  sesso char(1) NOT NULL,
  email varchar(60) DEFAULT NULL,
FOREIGN KEY (iso) REFERENCES nazioni (iso));


DROP TABLE IF EXISTS regioni;
CREATE TABLE regioni (
  descrizione_reg varchar(30) NOT NULL PRIMARY KEY,
FOREIGN KEY (iso) REFERENCES nazioni (iso));

DROP TABLE IF EXISTS province;
CREATE TABLE province (
  id_prov varchar(2) NOT NULL PRIMARY KEY,
  descrizione_prov varchar(30) NOT NULL,
FOREIGN KEY (descrizione_reg) REFERENCES regioni (descrizione_reg));

DROP TABLE IF EXISTS citta;
CREATE TABLE citta (
  id_citta int(20) NOT NULL  PRIMARY KEY,
  descrizione_citta varchar(50) NOT NULL,
 FOREIGN KEY (descrizione_prov) REFERENCES province (descrizione_prov));