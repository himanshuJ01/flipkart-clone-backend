package com.flipkartclone.products.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class GlobalExceptionalHandler {

	
	@ControllerAdvice
	public class GlobalExceptionHandler {
		@Value(value = "${data.exception.msg}")
		private String msg;

		@ExceptionHandler(value = ProductAlreadyExistException.class)
		public ResponseEntity<String> UserAlreadyExistException(ProductAlreadyExistException pae) {
			return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
		}

	}
}
