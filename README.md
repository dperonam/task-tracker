# Task Tracker API (Exam Starter)

## Requirements
- Java 17
- Maven

## Run
```bash
mvn spring-boot:run
```

App: http://localhost:8080  
H2 console (optional): http://localhost:8080/h2-console

## Test
```bash
mvn test
```

## API
Base path: `/api/tasks`

Example create:
```bash
curl -i -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy milk","description":"2 liters","status":"OPEN"}'
```