# Spring Boot Exam (Mid-level) — 60 minutes
## Task Tracker API (Maven + H2 + Flyway + MapStruct)

### Goal
Build a small Spring Boot REST API to manage tasks. Focus on clean architecture, correctness, and a couple of tests.

---

## Constraints
- Java 17
- Spring Boot 3.x
- Maven
- H2 database (in-memory is OK)
- **Flyway** migrations must be used for schema
- **MapStruct** must be used for DTO/entity mapping
- No authentication / login
- Timebox: 60 minutes

---

## Domain Model
### Task
- `id`: Long (generated)
- `title`: String (**required**, 3–100 chars)
- `description`: String (optional, max 500)
- `status`: enum `OPEN | IN_PROGRESS | DONE` (default `OPEN`)
- `createdAt`: timestamp (auto)
- `updatedAt`: timestamp (auto)

---

## API
Base path: `/api/tasks`

### Create
`POST /api/tasks`
- Returns: `201 Created`
- Include a `Location` header pointing to `/api/tasks/{id}`

Request example:
```json
{
  "title": "Buy milk",
  "description": "2 liters",
  "status": "OPEN"
}
```

### Get by id
`GET /api/tasks/{id}`
- Returns: `200 OK` and the task
- If not found: `404 Not Found`

### List
`GET /api/tasks`
- Minimum: return all tasks
- Optional bonus: pagination via `page`, `size`, `sort`

### Update
`PUT /api/tasks/{id}`
- Updates an existing task
- Returns: `200 OK`
- If not found: `404 Not Found`

### Delete
`DELETE /api/tasks/{id}`
- Returns: `204 No Content`
- If not found: `404 Not Found`

---

## Validation + error handling
- Use bean validation (`jakarta.validation`)
- On validation errors, return `400 Bad Request` with a readable JSON body that includes field-level errors.
- On not found, return `404 Not Found` with a short message.

---

## Persistence
- Use Spring Data JPA + H2.
- Schema must be created by Flyway migrations (already scaffolded).
- The app should start with: `mvn spring-boot:run`

---

## MapStruct requirement
- Use MapStruct to map:
  - `TaskCreateRequest -> Task`
  - `TaskUpdateRequest -> Task` (update existing entity)
  - `Task -> TaskResponse`
- When request `status` is null, default to `OPEN`.

---

## Tests (minimum)
Provide at least **2** tests:
- 1 Controller/web test using MockMvc (happy path OR validation failure)
- 1 Repository test (`@DataJpaTest`) OR service test

---

## Deliverables
- Source code
- `README.md` with:
  - How to run: `mvn spring-boot:run`
  - How to test: `mvn test`
  - Example curl commands

---

## Bonus (only if time remains)
Pick ONE:
- pagination for `GET /api/tasks`
- filter by status: `GET /api/tasks?status=DONE`
- improved consistent error format using `@ControllerAdvice`
- OpenAPI / Swagger UI