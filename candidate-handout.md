# Spring Boot Exam (Mid-level) — 60 minutes
Project: Task Tracker API (Maven + H2, no security)

## Goal
Build a small Spring Boot REST API to manage tasks. Focus on correctness, clean structure, and a couple of tests.

## Tech constraints
- Java 17
- Spring Boot 3.x
- Maven
- H2 database (in-memory is OK)
- No authentication / login

---

## Domain model
Create an entity `Task` with:

- `id`: Long (generated)
- `title`: String (required, 3–100 chars)
- `description`: String (optional, max 500)
- `status`: enum `OPEN`, `IN_PROGRESS`, `DONE` (default `OPEN`)
- `createdAt`: timestamp (auto)
- `updatedAt`: timestamp (auto)

---

## API
Base path: `/api/tasks`

### 1) Create
`POST /api/tasks`
- Returns `201 Created` and the created task

Request JSON example:
```json
{
  "title": "Buy milk",
  "description": "2 liters",
  "status": "OPEN"
}
```

### 2) Get by id
`GET /api/tasks/{id}`
- Returns `200 OK` and the task
- Returns `404 Not Found` if the id does not exist

### 3) List
`GET /api/tasks`
- Minimum: return all tasks
- Optional: support pagination (`page`, `size`, `sort`)

### 4) Update
`PUT /api/tasks/{id}`
- Updates an existing task
- Returns `200 OK` with updated task
- Returns `404 Not Found` if id does not exist
- Validation rules apply

### 5) Delete
`DELETE /api/tasks/{id}`
- Returns `204 No Content` if deleted
- Returns `404 Not Found` if id does not exist

---

## Validation + error handling
- Use bean validation (`jakarta.validation`).
- On validation errors, return `400 Bad Request` with a clear response body (field -> message is fine).
- On not found, return `404 Not Found` with a short message.

---

## Persistence
- Use Spring Data JPA + H2.
- The app must run without installing anything external.

---

## Tests (minimum)
Provide at least **2 tests** total:
- 1 controller/web test with MockMvc (happy path OR validation failure)
- 1 service test OR repository test

---

## Deliverables
- Source code
- `README.md` that includes:
  - how to run: `mvn spring-boot:run`
  - how to run tests: `mvn test`
  - example curl commands for the endpoints

---

## Bonus (only if time remains)
Pick ONE:
- pagination for `GET /api/tasks`
- filter by status: `GET /api/tasks?status=DONE`
- consistent error format using `@ControllerAdvice`
- OpenAPI/Swagger UI