FROM mysql:5.7.24

LABEL MAINTAINER Fila 4 <fila4@its.it>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE employees_management

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3001
