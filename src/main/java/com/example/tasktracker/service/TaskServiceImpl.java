package com.example.tasktracker.service;

import com.example.tasktracker.dto.TaskCreateRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.dto.TaskUpdateRequest;
import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.TaskStatus;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;

  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public TaskResponse create(TaskCreateRequest request) {
    // TODO: map request -> entity, apply default status, save, return response
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  public TaskResponse getById(long id) {
    // TODO: fetch or throw not-found, return response
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  public List<TaskResponse> listAll() {
    // TODO: fetch all, map to responses
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  public TaskResponse update(long id, TaskUpdateRequest request) {
    // TODO: fetch existing or throw not-found, update fields, save, return response
    throw new UnsupportedOperationException("TODO");
  }

  @Override
  public void delete(long id) {
    // TODO: delete or throw not-found
    throw new UnsupportedOperationException("TODO");
  }

  static TaskResponse toResponse(Task task) {
    return new TaskResponse(
        task.getId(),
        task.getTitle(),
        task.getDescription(),
        task.getStatus(),
        task.getCreatedAt(),
        task.getUpdatedAt()
    );
  }

  static TaskStatus defaultStatus(TaskStatus status) {
    return status == null ? TaskStatus.OPEN : status;
  }
}