# cars-api
Cars Management api

![Java Badge](https://img.shields.io/badge/java-11-red?logo=java)
[![Sonarqube Badge](https://img.shields.io/badge/Sonarqube-gray?logo=Sonarqube)](http://xxxxxxx:9000/dashboard?id=com.example%3Ademo)
[![Swagger Badge](https://img.shields.io/badge/Swagger-API%20Spec-6DB33F?logo=Swagger)]( http://xxxxx:8081/swagger-ui.html)
![Spring boot MVC Badge](https://img.shields.io/badge/Spring%20Boot-MVC-6DB33F?logo=spring)
![Jenkins Build Status](http://34.125.83.167:8080/buildStatus/icon?job=springboot-maven-docker "http://xxxxxx:8080/job/cars-api/")

## This springboot application is automated with CI and CD pipelines and deployed on to GCP VM instance.
Sonarqube Report -  http://xxxxxx:9000/dashboard?id=com.example%3Ademo  <br />
Jenkins Pipeline - http://xxxxxxx:8080/job/springboot-maven-docker/ <br />
Push to Docker Hub - https://hub.docker.com/repository/docker/madhuperam29/xxxxx <br />

## Swagger link
http://xxxxx:8081/swagger-ui.html <br />

## Here are the links to the API endpoints for testing directly on GCP instance where API is up and running- 
API base endpoint  - http://34.125.83.167:8081/api/v1 <br />
HTTP GET api/v1/cars/all <br />
HTTP GET api/v1/cars/{id} <br />
HTTP POST api/v1/cars ( user payload to be sent) <br />
HTTP PUT api/v1/cars/{id} <br />
HTTP DELETE api/v1/cars/{id} <br />

## Below are the feature branches where main story and stretch goals are worked upon and merged to master branch upon completion of code review and sonarqube fixes



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


