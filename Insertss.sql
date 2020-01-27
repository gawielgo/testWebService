use Employees_management;

insert into Countries values ("ITA","Italia");
insert into Countries values ("KK","Kazakhistan");
insert into Countries values ("FR","Francia");

insert into Regions values(null,"Veneto","ITA");
insert into Regions values(null,"Friuli-Venezia-Giulia","ITA");
insert into Regions values(null,"Bretagna","FR");
insert into Provinces values (null,"Belluno","1");
insert into Provinces values (null,"Vicenza","1");
insert into Provinces values (null,"Padova","1");
insert into Provinces values (null,"Rovigo","1");
insert into Provinces values (null,"Verona","1");
insert into Provinces values (null,"Treviso","1");
insert into Provinces values (null,"Venezia","1");
insert into Provinces values (null,"Udine","2");
insert into Provinces values (null,"Gorizia","2");
insert into Provinces values (null,"Pordenone","2");
insert into Provinces values (null,"Triestre","2");
insert into Cities values(null,"Padova",1);
insert into Cities values (null,"Belluno",1);

drop table Cities ;
drop table Countries ;
drop table Regions;
drop table Provinces ;

truncate table Cities ;




insert into Employees values(null,"Mirco", "Pastorino","PSTMRC85J8564D",2,"Via Brombeis 15","M","mirco_pastorino@belbel.com", "3986547852" );
insert into Employees values(null,"Marco", "Casarin","CSMRC3545GH782DS",1,"Via Brombeis 12","M","marco_casarin@belbel.com", "3966556155" );
insert into Employees values(null,"Lorenzo", "Savian","LRZSV23545GH782DS",1,"Via Brombeis 4","M","lorenzo_sav@belbel.com", "3966558455" );
insert into Employees values(null,"Igor", "Lazic","IGRLAZ3545GH782DS",1,"Via Brombeis 1","M","igor_lazic@belbel.com", "3966556743" );
insert into Employees values(null,"Manuel", "Maraga","MNLMRG845GH782DS",1,"Via Brombeis 18","M","m.m@belbel.com", "393521479" );

