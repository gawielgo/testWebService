FROM mysql:5.7.24

LABEL MAINTAINER Ciccio Pasticcio
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE employees_management

ADD timesheet.sql /docker-entrypoint-initdb.d

EXPOSE 3390
