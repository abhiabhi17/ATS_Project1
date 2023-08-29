package com.ats.exceptns;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value=NoSuchElementException.class)
	public ResponseEntity handleNoSuchElementException()
	{
		ApiError error=new ApiError(400, "No User Found", new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
