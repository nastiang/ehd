Установка и подключение к бд Oracle:

docker pull wnameless/oracle-xe-11g:14.04.4

docker run -d -p 22:22 -p 1521:1521 docker.io/konnecteam/docker-oracle-xe-11g:latest

hostname: localhost
port: 1521
sid: xe
username: SYS
password: oracle