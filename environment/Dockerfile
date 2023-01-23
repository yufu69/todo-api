FROM postgres:15.1

RUN mkdir /init-data-files
COPY init.sh /docker-entrypoint-initdb.d/
COPY data /init-data-files