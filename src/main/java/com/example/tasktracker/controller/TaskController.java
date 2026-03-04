package com.example.tasktracker.controller;

import com.example.tasktracker.dto.TaskCreateRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.dto.TaskUpdateRequest;
import com.example.tasktracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public ResponseEntity<TaskResponse> create(@Valid @RequestBody TaskCreateRequest request) {
    // TODO: return 201 with Location header
    throw new UnsupportedOperationException("TODO");
  }

  @GetMapping("/{id}")
  public TaskResponse getById(@PathVariable long id) {
    // TODO
    throw new UnsupportedOperationException("TODO");
  }

  @GetMapping
  public List<TaskResponse> listAll() {
    // TODO
    throw new UnsupportedOperationException("TODO");
  }

  @PutMapping("/{id}")
  public TaskResponse update(@PathVariable long id, @Valid @RequestBody TaskUpdateRequest request) {
    // TODO
    throw new UnsupportedOperationException("TODO");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    // TODO: return 204
    throw new UnsupportedOperationException("TODO");
  }

  static URI location(long id) {
    return URI.create("/api/tasks/" + id);
  }
}