package com.vinit.angularspringboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vinit.angularspringboot.domainObjects.AppError;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(LoginException.class)
	public final ResponseEntity<AppError> handleInvalidLoginException(LoginException ex, WebRequest request){
		return new ResponseEntity<>(new AppError(new Date(), ex.getMessage(), HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<AppError> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request){
		return new ResponseEntity<>(new AppError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<AppError> handleAllExceptions(Exception ex, WebRequest request) {
		AppError appError = new AppError(new Date(), "Something went wrong. Please contact system Admin", HttpStatus.INTERNAL_SERVER_ERROR);
	  return new ResponseEntity<>(appError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ValidationException.class)
	public final ResponseEntity<AppError> handleEntityNotFoundException(ValidationException ex, WebRequest request){
		return new ResponseEntity<>(new AppError(new Date(), ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}
}
