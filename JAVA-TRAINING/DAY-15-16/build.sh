#! /bin/sh

cd ./customer-service
mvn clean package -DskipTests
docker build -t customer-service:latest .
cd ..

cd ./gateway-service
mvn clean package -DskipTests
docker build -t gateway-service:latest .
cd ..