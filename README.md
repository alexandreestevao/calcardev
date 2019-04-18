# calcard

Executando aplicação AngularJS e Spring Boot com Docker

## Pré requisito

- Maven 3
- Java 8
- Docker 2
- AngularJS 1.x
- Spring Boot 2.1.4
- Postgres 9.5

## Preparando ambiente


```
$ mvn clean -Dmaven.test.skip=true package

$ docker build --build-arg JAR_FILE=target/*.jar -t calcard/calcardev .

$ docker run -it -d --name=postgres-docker -p 5432:5432 -e POSTGRES_PASSWORD='1234' postgres

$ docker ps -a

$ docker-compose up docker-app
```

## Documentação Swagger

```
http://localhost:8080/swagger-ui.html
```


