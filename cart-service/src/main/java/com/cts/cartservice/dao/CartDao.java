package com.cts.cartservice.dao;

import java.util.ArrayList;

import com.cts.cartservice.exception.CartNotFoundException;
import com.cts.cartservice.exception.MenuItemNotFoundException;
import com.cts.cartservice.model.MenuItem;

public interface CartDao {

	// to add item in given user cart
	void addCartItem(int userId, int menuItemId)throws MenuItemNotFoundException;

	// fetch all items in given user cart
	ArrayList<MenuItem> getAllCartItems(int userId)throws CartNotFoundException;

	// delete item from given user and cart
	void deleteCartItem(int userId, int menuItemId) throws MenuItemNotFoundException;
}
