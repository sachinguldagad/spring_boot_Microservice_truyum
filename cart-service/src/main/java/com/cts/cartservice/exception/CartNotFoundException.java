package com.cts.cartservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart not found.")
public class CartNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CartNotFoundException() {
		super("User Id not Available. Cart was never initialised.");
	}

}