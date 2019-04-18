# calcardev

Executando aplicação AngularJS e Spring Boot no Docker

## Pré requisito
- AngularJS
- Maven 3
- Java 8
- Docker 1.4.2
- Spring Boot 2.1.4

## Preparando ambiente


```
sudo docker ps -a
sudo docker run -it -d --name=postgres-docker -p 5432:5432 -e POSTGRES_PASSWORD='1234' postgres
sudo docker build --build-arg JAR_FILE=target/*.jar -t calcardev/calcardev .
mvn clean package dockerfile:build 
docker-compose up
```

## Documentação Swagger

```
http://localhost:8080/swagger-ui.html
```

## Front-End

```
AngularJS

```
## Back-End

```
Spring Boot
API Rest

```
