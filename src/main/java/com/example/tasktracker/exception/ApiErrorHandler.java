package com.example.tasktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiErrorHandler {

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleNotFound(TaskNotFoundException ex) {
    // TODO: return 404 body
    throw new UnsupportedOperationException("TODO");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
    // TODO: return 400 with field errors
    throw new UnsupportedOperationException("TODO");
  }

  static Map<String, Object> body(String message) {
    Map<String, Object> m = new HashMap<>();
    m.put("message", message);
    return m;
  }
}