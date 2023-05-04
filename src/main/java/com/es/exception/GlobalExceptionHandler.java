package com.es.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.es.apierror.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<ApiError> handle(Exception e) {
		ApiError error = new ApiError();
		error.setMsg(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> resp = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return resp;

	}

	@ExceptionHandler(value = EntityNotFoundException.class)

	public ResponseEntity<ApiError> handle1(Exception b) {
		ApiError error = new ApiError();
		error.setMsg(b.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> resp = new ResponseEntity(error, HttpStatus.NOT_FOUND);
		return resp;

	}
	@ExceptionHandler(value = NoSuchElementException.class)

	public ResponseEntity<ApiError> handle2(Exception b) {
		ApiError error = new ApiError();
		error.setMsg(b.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		

	}
	@ExceptionHandler(value = InsuffientBalanceException.class)

	public ResponseEntity<ApiError> handle3(Exception b) {
		ApiError error = new ApiError();
		error.setMsg(b.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		ResponseEntity<ApiError> resp = new ResponseEntity(error, HttpStatus.NOT_FOUND);
		return resp;

	}
	@ExceptionHandler(value = UserAlreadyExistException.class)

	public ResponseEntity<ApiError> handle4(Exception b) {
		ApiError error = new ApiError();
		error.setMsg(b.getMessage());
		ResponseEntity<ApiError> resp = new ResponseEntity(error, HttpStatus.NOT_FOUND);
		return resp;

	}

}
