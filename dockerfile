FROM maven:3.9.8-amazoncorretto AS build
LABEL MAINTAINER="srijaadhya.11sc.2020@gmail.com"
COPY . .
RUN mvn clean install

FROM amazoncorretto:17-alpine-jdk
COPY --from=build target/*.jar app.jar 
EXPOSE 8080
RUN mvn clean install
