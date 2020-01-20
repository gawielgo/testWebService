CREATE DATABASE IF NOT EXISTS employees_management;
USE employees_management;

DROP TABLE IF EXISTS nazioni;
CREATE TABLE nazioni (
  iso char(2) primary key,
  descrizione varchar(30) not null
);

DROP TABLE IF EXISTS regioni;
CREATE TABLE regioni (
  id integer primary key auto_increment,
  descrizione varchar(30),
  iso_nazione char(2),
  FOREIGN KEY (iso_nazione) REFERENCES nazioni(iso)
);

DROP TABLE IF EXISTS province;
CREATE TABLE province (
  id char(2) primary key,
  descrizione varchar(30),
  id_regione integer,
  FOREIGN KEY (id_regione) REFERENCES regioni(id)
);

DROP TABLE IF EXISTS citta;
CREATE TABLE citta (
  id integer primary key auto_increment,
  descrizione varchar(40),
  id_provincia char(2),
  FOREIGN KEY (id_provincia) REFERENCES province(id)
);


DROP TABLE IF EXISTS dipendenti;
CREATE TABLE dipendenti(
  nome varchar(20) not null,
  cognome varchar(20) not null,
  taxCode char(16) not null,
  indirizzo varchar(40),
  sesso char(1),
  email varchar(20),
  telefono varchar(20),
  id integer primary key auto_increment,
  iso_nazione char(2),
  id_regione integer,
  id_provincia char(2),
  id_citta integer,
  FOREIGN KEY (iso_nazione) REFERENCES nazioni(iso),
  FOREIGN KEY (id_regione) REFERENCES regioni(id),
  FOREIGN KEY (id_provincia) REFERENCES province(id),
  FOREIGN KEY (id_citta) REFERENCES citta(id)

);