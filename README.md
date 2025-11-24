# product-discount-api
A Kotlin + Ktor microservces that provides an API for managing product, VAT inclusive prices and idempotent discount application.

## Features
- GET `/products?country={country}` List all products for a country including VAT & Discounts
- POST `/products/{id}/discount` Apply a discount to a product idempotently
- PostgreSQL database for product storage ( no in memory storage )

## Build & Run
### 1. Prequisites
- JDK 17 or higher
- Docker & Docker compose
- Gradle

### 2. Running with Docker Compose
docker compuse up --build

### 3. Manual Local Run
./gradlew build
./gradlew run

## Example curl commands
### GET products by country
curl -X GET "http://localhost:8080/products?country=Sweden" -H "accept: application/json"

### POST discount on product
curl -X POST "http://localhost:8080/products/1/discount" -H "Content-Type: application/json" -d '{"discountId": WELCOMEID, "percent": 10.0}'

## Database
on startup with Docker compose, PostgreSQL is seeded automatically with products and discount per init.sql
