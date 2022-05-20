package com.cts.menuitemservice.service;

import java.util.List;

import com.cts.menuitemservice.model.MenuItem;

public interface MenuItemService {

	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public MenuItem modifyMenuItem(int menuItemId,MenuItem menuItem);

	public MenuItem getMenuItem(int menuItemId);
	
	public MenuItem addMenuItem(MenuItem menuItem);
	
	public MenuItem removeMenuItem(int menuItemId);
}
