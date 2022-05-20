package com.cts.cartservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.cartservice.exception.CartNotFoundException;
import com.cts.cartservice.exception.MenuItemNotFoundException;
import com.cts.cartservice.model.MenuItem;
import com.cts.cartservice.service.CartServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {

	@Autowired
	private CartServiceImpl cartServiceImpl;

	// Adds given item to given users cart.
	@PostMapping("/{userId}/{menuItemId}")
	@HystrixCommand(fallbackMethod = "fallbackaddCartItem")
	public String addCartItem(@PathVariable("userId") int userId, @PathVariable("menuItemId") int menuItemId)
			throws MenuItemNotFoundException {
		log.info("START");
		cartServiceImpl.addCartItem(userId, menuItemId);

		log.info("END");
		return "MenuItem added successfully in Cart";
	}

	public String fallbackaddCartItem(@PathVariable("userId") int userId,
			@PathVariable("menuItemId") int menuItemId) {

		return "MenuItem Service is Down. Please contact admin";
	}

	// fetch all the cart items of existing users
	@GetMapping(value = "/{userId}")
	@HystrixCommand(fallbackMethod = "fallbackgetCartItem")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable("userId") int userId) throws CartNotFoundException {
		log.info("START");

		return cartServiceImpl.getAllCartItems(userId);
	}

	public ArrayList<MenuItem> fallbackgetCartItem(@PathVariable("userId") int userId)
			throws MenuItemNotFoundException {
		log.info("START");

		log.info("Start Fallback");
		MenuItem menuItem = new MenuItem();
		menuItem.setMenuItemId(0);
		menuItem.setMenuItemName("Default");
		menuItem.setMenuItemPrice(0);
		menuItem.setMenuItemFreeDelivery(false);
		menuItem.setMenuItemActive(false);
		menuItem.setMenuItemCategory(null);
		menuItem.setMenuItemDateOfLaunch(null);
		log.debug("MenuItem Service is Down");
		ArrayList<MenuItem> returnList = new ArrayList<MenuItem>();
		returnList.add(menuItem);
		return returnList;
	}

	// Delete item from users cart
	@DeleteMapping("/{userId}/{menuItemId}")
	@HystrixCommand(fallbackMethod = "fallbackdeleteCartItem")
	public String deleteCartItems(@PathVariable("userId") int userId, @PathVariable("menuItemId") int menuItemId)
			throws MenuItemNotFoundException {
		log.debug("START");
		cartServiceImpl.deleteCartItem(userId, menuItemId);
		log.debug("END");
		return "MenuItem deleted successfully from Cart";
	}

	public String fallbackdeleteCartItem(@PathVariable("userId") int userId,
			@PathVariable("menuItemId") int menuItemId) throws MenuItemNotFoundException {
		return "MenuItem Service is Down. Please contact admin";
	}

}