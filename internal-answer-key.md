# Answer key outline — Task Tracker API (Mid-level, 60 min)

## Expected architecture
- Controller -> Service -> Repository
- DTOs preferred (TaskCreateRequest/TaskUpdateRequest + TaskResponse) but entity-in/out is acceptable if validation + separation are still clean.

## Data layer
- Task entity:
  - @Entity + @Id @GeneratedValue
  - status as @Enumerated(EnumType.STRING)
  - createdAt/updatedAt set via @PrePersist/@PreUpdate OR JPA auditing
- Repository extends JpaRepository<Task, Long>

## Service layer
- createTask(request): maps request -> entity, saves
- getTask(id): throws TaskNotFoundException (or ResponseStatusException)
- updateTask(id, request): load, mutate, save
- deleteTask(id): check exists then delete OR deleteById with handling
- listTasks(): findAll OR pageable

## Controller layer
- @RestController @RequestMapping("/api/tasks")
- POST returns ResponseEntity.status(CREATED)
- DELETE returns ResponseEntity.noContent()

## Validation
- title: @NotBlank + @Size(min=3,max=100)
- description: @Size(max=500)
- Request DTO annotated with @Valid in controller

## Error handling
Minimum acceptable:
- throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
Better:
- custom exception TaskNotFoundException
- @ControllerAdvice maps:
  - TaskNotFoundException -> 404
  - MethodArgumentNotValidException -> 400 with field errors

Suggested validation error body:
{
  "message": "Validation failed",
  "errors": [
    {"field":"title","message":"must not be blank"}
  ]
}

## H2 config
- application.properties:
  - spring.datasource.url=jdbc:h2:mem:tasksdb
  - spring.h2.console.enabled=true (optional)
  - spring.jpa.hibernate.ddl-auto=update OR create-drop

## Tests (minimum acceptable)
1) Controller test (MockMvc):
- POST /api/tasks with valid body -> 201 and JSON contains title/status
OR
- POST invalid title -> 400 and error response contains "title"

2) Repository test (@DataJpaTest) OR Service test (Mockito):
- repository saves and retrieves entity
OR
- service update returns updated values, not-found throws

## Common pitfalls (deduct)
- Using entity directly with missing validation
- Returning 200 on create instead of 201
- No 404 handling (exceptions leak as 500)
- No tests or tests that don’t assert behavior
- Mixing persistence logic into controller