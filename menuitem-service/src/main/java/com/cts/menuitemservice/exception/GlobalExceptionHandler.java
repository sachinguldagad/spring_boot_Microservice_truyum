package com.cts.menuitemservice.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MenuItemNotFoundException.class)
	public String handleSweetItemNotFoundException(MenuItemNotFoundException e,HttpServletResponse response)
	{
		//please change it
		return "Sweet Item Not Found";
	}
}
