
FROM maven:3.9.8-eclipse-temurin-22 AS build
LABEL MAINTAINER="srijaadhya.11sc.2020@gmail.com"
COPY . .
RUN mvn clean install

FROM amazoncorretto:22-alpine3.19-jdk
WORKDIR /app
COPY --from=build target/*.jar app.jar
COPY .env /app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","app.jar" ]


