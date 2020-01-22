CREATE DATABASE IF NOT EXISTS Employees_Management;
USE Employees_Management;

DROP TABLE IF EXISTS nazioni;
CREATE TABLE nazioni (
  iso char(2) primary key,
  descrizione varchar(30) not null
);
INSERT INTO nazioni VALUES ('IT', 'Italia');
INSERT INTO nazioni VALUES ('FR', 'Francia');
INSERT INTO nazioni VALUES ('SP', 'Spagna');

DROP TABLE IF EXISTS regioni;
CREATE TABLE regioni (
  id integer primary key auto_increment,
  descrizione varchar(30),
  iso_nazione char(2),
  FOREIGN KEY (iso_nazione) REFERENCES nazioni(iso)
);
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Lombardia', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Veneto', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Sardegna', 'IT');

DROP TABLE IF EXISTS province;
CREATE TABLE province (
  id char(2) primary key,
  descrizione varchar(30),
  id_regione integer,
  FOREIGN KEY (id_regione) REFERENCES regioni(id)
);
INSERT INTO province VALUES ('PD', 'Padova', '2');
INSERT INTO province VALUES ('VI', 'Vicenza', '2');
INSERT INTO province VALUES ('VR', 'Verona', '2');

DROP TABLE IF EXISTS citta;
CREATE TABLE citta (
  id integer primary key auto_increment,
  descrizione varchar(40),
  id_provincia char(2),
  FOREIGN KEY (id_provincia) REFERENCES province(id)
);
INSERT INTO citta (descrizione, id_provincia) VALUES ('Padova', '1');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Camposampiero', '1');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Cittadella', '1');


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
INSERT INTO citta (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Gigi','Rossi', 'GRSCFKDJEI293ODJ', 'via delle rose, 80', 'M', 'gigi.rossi@gmail.com', '+39 3304859286', 'IT', '2', 'PD', '1');
INSERT INTO citta (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Mario','Verdi', 'GRSCFKDJEI293ODJ', 'via delle fontane, 50', 'M', 'mario.verdi@gmail.com', '+39 3659874521', 'IT', '2', 'PD', '3');
INSERT INTO citta (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Maria','Bianchi', 'GRSCFKDJEI293ODJ', 'via roma, 5', 'F', 'maria.bianchi@gmail.com', '+39 9631548654', 'IT', '2', 'PD', '2');
