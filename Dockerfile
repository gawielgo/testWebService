FROM mysql:5.7.24

LABEL MAINTAINER Anthony Ferranti <Anthony.Ferranti@corvallis.it>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE Employees_Management

ADD database.sql /docker-entrypoint-initdb.d

EXPOSE 3399
