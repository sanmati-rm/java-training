FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /sanmati/app/workspace

COPY ./target/eureka-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8761

ENTRYPOINT java -jar ./app.jar