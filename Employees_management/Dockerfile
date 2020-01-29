FROM mysql:5.7.24

LABEL MAINTAINER Anthony Ferranti <Anthony.Ferranti@corvallis.it>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE Employees

ADD DB_EMPLOYEES.sql /docker-entrypoint-initdb.d

EXPOSE 3391
