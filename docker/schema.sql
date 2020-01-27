CREATE DATABASE  IF NOT EXISTS `employees_management`;
USE `employees_management`;

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
	taxCode char(16) not null unique,
	indirizzo varchar(40),
	sesso char(1),
	email varchar(20) unique,
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




insert into nazioni values('it', 'Italia');
insert into regioni(descrizione, iso_nazione) VALUES('Veneto', 'it');
insert into province VALUES(1, 'PD', 1);
insert into citta(descrizione, id_provincia) VALUES('Padova', 1);

INSERT INTO `nazioni` VALUES ('AF', 'Afghanistan');
INSERT INTO `nazioni` VALUES ('AL', 'Albania');
INSERT INTO `nazioni` VALUES ('DZ', 'Algeria');
INSERT INTO `nazioni` VALUES ('DS', 'American Samoa');
INSERT INTO `nazioni` VALUES ('AD', 'Andorra');
INSERT INTO `nazioni` VALUES ('AO', 'Angola');
INSERT INTO `nazioni` VALUES ('AI', 'Anguilla');
INSERT INTO `nazioni` VALUES ('AQ', 'Antarctica');
INSERT INTO `nazioni` VALUES ('AG', 'Antigua and Barbuda');
INSERT INTO `nazioni` VALUES ('AR', 'Argentina');
INSERT INTO `nazioni` VALUES ('AM', 'Armenia');
INSERT INTO `nazioni` VALUES ('AW', 'Aruba');
INSERT INTO `nazioni` VALUES ('AU', 'Australia');
INSERT INTO `nazioni` VALUES ('AT', 'Austria');
INSERT INTO `nazioni` VALUES ('AZ', 'Azerbaijan');
INSERT INTO `nazioni` VALUES ('BS', 'Bahamas');
INSERT INTO `nazioni` VALUES ('BH', 'Bahrain');
INSERT INTO `nazioni` VALUES ('BD', 'Bangladesh');
INSERT INTO `nazioni` VALUES ('BB', 'Barbados');
INSERT INTO `nazioni` VALUES ('BY', 'Belarus');
INSERT INTO `nazioni` VALUES ('BE', 'Belgium');
INSERT INTO `nazioni` VALUES ('BZ', 'Belize');
INSERT INTO `nazioni` VALUES ('BJ', 'Benin');
INSERT INTO `nazioni` VALUES ('BM', 'Bermuda');
INSERT INTO `nazioni` VALUES ('BT', 'Bhutan');
INSERT INTO `nazioni` VALUES ('BO', 'Bolivia');
INSERT INTO `nazioni` VALUES ('BA', 'Bosnia and Herzegovina');
INSERT INTO `nazioni` VALUES ('BW', 'Botswana');
INSERT INTO `nazioni` VALUES ('BV', 'Bouvet Island');
INSERT INTO `nazioni` VALUES ('BR', 'Brazil');
INSERT INTO `nazioni` VALUES ('IO', 'British Indian Ocean Territory');
INSERT INTO `nazioni` VALUES ('BN', 'Brunei Darussalam');
INSERT INTO `nazioni` VALUES ('BG', 'Bulgaria');
INSERT INTO `nazioni` VALUES ('BF', 'Burkina Faso');
INSERT INTO `nazioni` VALUES ('BI', 'Burundi');
INSERT INTO `nazioni` VALUES ('KH', 'Cambodia');
INSERT INTO `nazioni` VALUES ('CM', 'Cameroon');
INSERT INTO `nazioni` VALUES ('CA', 'Canada');
INSERT INTO `nazioni` VALUES ('CV', 'Cape Verde');
INSERT INTO `nazioni` VALUES ('KY', 'Cayman Islands');
INSERT INTO `nazioni` VALUES ('CF', 'Central African Republic');
INSERT INTO `nazioni` VALUES ('TD', 'Chad');

insert into regioni values(null, 'Veneto', 'it');
insert into regioni values(null, 'Lombardia', 'it');
insert into regioni values(null, 'Puglia', 'it');
insert into regioni values(null, 'Tirolo', 'AT');
insert into regioni values(null, 'Voralberg', 'AT');
insert into regioni values(null, 'Ontario', 'CA');
insert into regioni values(null, 'Alberta', 'CA');
insert into regioni values(null, 'Québec', 'CA');
insert into regioni values(null, 'Labrador', 'CA');

insert into province values('PD', 'Padova', 1);
insert into province values('RO', 'Rovigo', 1);
insert into province values('TV', 'Treviso', 1);
insert into province values('MI', 'Milano', 2);
insert into province values('BS', 'Brescia', 2);
insert into province values('PV', 'Pavia', 2);

insert into citta values(null,'Padova' , 'PD');
insert into citta values(null,'Noventa padovana' , 'PD');
insert into citta values(null, 'Milano', 'MI');
insert into citta values(null, 'Sesto S. Giovanni', 'MI');

insert into dipendenti values('Mario', 'Rossi', 'fdsfds', 'rwerewrwe', 'M', 'ciao@maria.db', '42432', null, 'it', 1, 'PD', 1);
insert into dipendenti values('Luigi','verdi','vrdlgi99g12g224d','via dal' ,'M', 'luigi.verdi@cane.com', '3401234567', null, 'it', 1, 'PD', 1);