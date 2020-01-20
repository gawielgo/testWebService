create database if not exists employees_management;

create table if not exists Nazioni(
	iso varchar(3) not null,
	description varchar(20) not null,
	primary key (iso)
);

create table if not exists Regioni(
	id_region int(7) auto_increment,
	description varchar(20) not null,
	iso_coun varchar(3),
	primary key (id_region),
	foreign key (iso_coun) references Nazioni (iso)
);

create table if not exists Province(
	id_prov varchar(3) not null,
	description varchar(20) not null,
	id_region int(7) not null,
	primary key (id_prov),
	foreign key (id_region) references Regioni (id_region)
);

create table if not exists Citta(
	id_city int(7) not null,
	description varchar(20) not null,
	id_prov varchar(3) not null,
	primary key (id_city),
	foreign key (id_prov) references Province (id_prov)
);
create table if not exists Dipendenti(
	id int(7) auto_increment,
	name varchar(15) not null,
	surname varchar(15) not null,
	taxCode varchar(15) not null,
	gender varchar(1) not null,
	address varchar(20) not null,
	city int(7) not null, 
	primary key (id),
	foreign key (city) references Citta (id_city)
);

