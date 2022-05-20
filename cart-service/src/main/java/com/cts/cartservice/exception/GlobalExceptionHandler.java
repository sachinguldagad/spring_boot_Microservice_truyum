package com.cts.cartservice.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public String handleFeignException(FeignException e,HttpServletResponse response)
	{
		
		response.setStatus(e.status());
		return "MenuItem Not Found";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e,HttpServletResponse response)
	{
		return "Please provide valid inputs. \n"+ e.getMessage() ;
	}
	
	
	@ExceptionHandler(MenuItemNotFoundException.class)
	public String handleSweetItemNotFoundException(MenuItemNotFoundException e,HttpServletResponse response)
	{
		
		return "MenuItem Not Found";
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public String handleCartNotFoundException(CartNotFoundException e,HttpServletResponse response)
	{
		return "Cart Not Found";
	}
}
