package com.example.tasktracker.service;

import com.example.tasktracker.dto.TaskCreateRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.dto.TaskUpdateRequest;

import java.util.List;

public interface TaskService {
  TaskResponse create(TaskCreateRequest request);

  TaskResponse getById(long id);

  List<TaskResponse> listAll();

  TaskResponse update(long id, TaskUpdateRequest request);

  void delete(long id);
}