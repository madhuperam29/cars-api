# cars-api
Cars Management api

![Java Badge](https://img.shields.io/badge/java-11-red?logo=java)
[![Sonarqube Badge](https://img.shields.io/badge/Sonarqube-gray?logo=Sonarqube)](http://34.125.83.167:9000/dashboard?id=com.ecs.technicaltask%3Acars-api)
[![Swagger Badge](https://img.shields.io/badge/Swagger-API%20Spec-6DB33F?logo=Swagger)]( http://34.125.83.167:8081/swagger-ui.html)
![Spring boot MVC Badge](https://img.shields.io/badge/Spring%20Boot-MVC-6DB33F?logo=spring)
![Jenkins Build Status](http://34.125.83.167:8080/buildStatus/icon?job=springboot-maven-docker "http://34.125.83.167:8080/job/cars-api/")

## This springboot application is automated with CI and CD pipelines and deployed on to GCP VM instance.
Sonarqube Report -  http://34.125.83.167:9000/dashboard?id=com.ecs.technicaltask%3Acars-api  <br />
Jenkins Pipeline - http://xxxxxxx:8080/job/springboot-maven-docker/ <br />
Push to Docker Hub - https://hub.docker.com/repository/docker/madhuperam29/xxxxx <br />

## Swagger link to test all operations of this API directly on GCP instance where API is up and running. Please test from this Endpoint.
http://34.125.83.167:8081/swagger-ui.html <br />

## Here are the links to the API endpoints  - 
API base endpoint  - http://34.125.83.167:8081/api/v1 <br />
HTTP GET api/v1/cars <br />
HTTP GET api/v1/cars/{id} <br />
HTTP POST api/v1/cars ( user payload to be sent) <br />
HTTP DELETE api/v1/cars/{id} <br />

## Below are the feature branches where main story and stretch goals are worked upon and merged to master branch upon completion of code review and sonarqube fixes
feature/story1-add-retrieve-delete-car-with-in-memory-implementation <br>

## How to build and run in local

## Building

```console
# Windows
C:\Users\Me\cars-api> .\mvnw.cmd clean package
```
```dos
# UNIX
you@your-pc:cars-api/$ ./mvnw clean package
```

## Running

```console
# Windows
C:\Users\Me\cars-api> .\mvnw.cmd spring-boot:run
```
```dos
# UNIX
you@your-pc:cars-api$ ./mvnw spring-boot:run


