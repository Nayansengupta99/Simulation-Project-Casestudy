package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CartItemEmptyForUserException extends RuntimeException {

	public CartItemEmptyForUserException(Long userid) {
		super("No cart item is available for userid " + userid);
	}

}
