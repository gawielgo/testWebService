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
  FOREIGN KEY (id_citta) REFERENCES citta(id));
  
INSERT INTO nazioni VALUES ('IT', 'Italia');
INSERT INTO nazioni VALUES ('FR', 'Francia');
INSERT INTO nazioni VALUES ('SP', 'Spagna');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Piemonte', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Veneto', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Campania', 'IT');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Lizza', 'FR');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Parigi', 'FR');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Nizza', 'FR');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Ibiza', 'SP');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Barcellona', 'SP');
INSERT INTO regioni (descrizione, iso_nazione) VALUES ('Madrid', 'SP');
INSERT INTO province VALUES ('PD', 'Padova', '2');
INSERT INTO province VALUES ('MI', 'Milano', '1');
INSERT INTO province VALUES ('VR', 'Verona', '2');
INSERT INTO province VALUES ('BC', 'Barcellona', '8');
INSERT INTO province VALUES ('BC', 'Girona', '8');
INSERT INTO province VALUES ('BC', 'Tarragona', '8');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Padova', 'PD');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Due Carrare', 'PD');
INSERT INTO citta (descrizione, id_provincia) VALUES ('Este', 'PD');
INSERT INTO dipendenti (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Stefano','Zogno', 'ZGNSFNO00VOLEVI', 'via del rosetto, 180', 'M', 'stefagno@gmail.com', '+39 3491111111', 'IT', '2', 'PD', '1');
INSERT INTO dipendenti (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Mario','Verdura', 'MRRVRD00ADIJD', 'via delle seggiole, 99', 'M', 'mariodura@gmail.com', '+39 84891919', 'IT', '2', 'PD', '1');
INSERT INTO dipendenti (nome, cognome, taxCode, indirizzo, sesso, email, telefono, iso_nazione, id_regione, id_provincia, id_citta) 
VALUES ('Maria','Venier', 'MRRVNR00DDAHI', 'via brogei, 5', 'F', 'marienier@gmail.com', '+39 394199819', 'IT', '2', 'PD', '1');
);
