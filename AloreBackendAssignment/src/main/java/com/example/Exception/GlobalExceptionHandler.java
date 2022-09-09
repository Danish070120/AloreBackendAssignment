package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entity.User;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<User> userNotfoundExceptionHandler(CustomException exception) {
		String message = exception.getMessage();
		User user = new User();
		return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

	}
}
