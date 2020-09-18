package com.cognizant.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND) 
public class BookNotFoundException extends RuntimeException{
	

	public BookNotFoundException(Long id) {
	    super("Could not find the book " + id);
	  }
}
