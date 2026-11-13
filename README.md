# Unique Scanner Project

Technology:
- Backend: Java 17 + Spring Boot
- Database: PostgreSQL
- Frontend: React + Vite

## Step 1: Create database

CREATE DATABASE unique_scanner_db;

## Step 2: Configure PostgreSQL password

Edit:

backend/src/main/resources/application.properties

Set:

spring.datasource.password=YOUR_POSTGRES_PASSWORD

## Step 3: Start backend

cd backend
mvn spring-boot:run

Backend runs on:
http://localhost:8080

## Step 4: Start frontend

cd frontend
npm install
npm run dev

Frontend normally runs on:
http://localhost:5173

## API

POST /api/scanners/generate

Every request generates a UUID and saves it into PostgreSQL.
