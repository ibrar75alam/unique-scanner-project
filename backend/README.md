# Unique Scanner Backend

## Database
Create PostgreSQL database:

CREATE DATABASE unique_scanner_db;

Update `src/main/resources/application.properties` with your PostgreSQL password.

## Run
mvn spring-boot:run

API:
POST http://localhost:8080/api/scanners/generate
