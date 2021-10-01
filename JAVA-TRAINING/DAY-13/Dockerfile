FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /sanmati/app/workspace

COPY ./target/day-13-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 9090

ENTRYPOINT java -jar ./app.jar