FROM mysql:5.7.24

LABEL MAINTAINER Fila 4 <jesus@maria.db>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE employees_management

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3391
