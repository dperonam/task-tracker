package com.example.tasktracker.controller;

import com.example.tasktracker.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

@WebMvcTest(TaskController.class)
@Import({/* TODO: import ApiErrorHandler if you implement it */})
class TaskControllerTest {

  // TODO: add MockMvc + mock TaskService and write at least 1 test
  @Test
  void placeholder() {
    // TODO
  }
}