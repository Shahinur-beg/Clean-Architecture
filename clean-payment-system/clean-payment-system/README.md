# Clean Payment System (Demo)

A small demo project demonstrating **Clean Architecture** (Uncle Bob) for a Payment System.
- Java 17, Spring Boot (Maven)
- PostgreSQL configuration included (update credentials in application.yml)
- Kafka & Redis: **mock implementations** included for simplicity

## Structure
- `domain` - entities and repository interfaces
- `usecase` - application use cases (TransferMoney, RefundPayment)
- `adapter` - controllers, persistence adapters (JPA), messaging adapters (mock Kafka), cache adapters (mock Redis)
- `framework` - Spring Boot application and configs

## Run
1. Ensure Java 17 and Maven are installed.
2. (Optional) Start PostgreSQL and update `src/main/resources/application.yml` with connection details.
3. Build and run:
```
mvn clean package
mvn spring-boot:run
```
4. Example API:
- POST `http://localhost:8080/api/payments/transfer` with JSON body:
```
{"fromAccount":"A-100","toAccount":"B-200","amount":100.0}
```

