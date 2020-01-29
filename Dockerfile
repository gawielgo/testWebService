FROM mysql:5.7.24
<<<<<<< HEAD

LABEL MAINTAINER Fila 4 <jesus@maria.db>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE employees_management

ADD schema.sql /docker-entrypoint-initdb.d

EXPOSE 3391
=======
LABEL MAINTAINER Anthony Ferranti <Anthony.Ferranti@corvallis.it>
LABEL description="Immagine DBMS MySql"

ENV MYSQL_DATABASE employees_management

ADD employees_management.sql /docker-entrypoint-initdb.d

EXPOSE 3392
>>>>>>> branch 'fila2' of https://github.com/gawielgo/testWebService.git
