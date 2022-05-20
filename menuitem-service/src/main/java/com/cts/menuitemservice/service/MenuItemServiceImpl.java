package com.cts.menuitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.menuitemservice.dao.MenuItemDaoImpl;
import com.cts.menuitemservice.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDaoImpl menuItemDaoImpl;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		log.info("MenuItemServiceImpl public List<MenuItem> getMenuItemListAdmin() START");
		List<MenuItem> menuItemListAdmin = menuItemDaoImpl.getMenuItemListAdmin();
		log.debug("MenuItemListAdmin: {}", menuItemListAdmin);
		log.info("MenuItemServiceImpl public List<MenuItem> getMenuItemListAdmin()  END");
		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("MenuItemServiceImpl public List<MenuItem> getMenuItemListCustomer( START");
		List<MenuItem> menuItemListCustomer = menuItemDaoImpl.getMenuItemListCustomer();
		log.debug("MenuItemListAdmin: {}", menuItemListCustomer);
		log.info("MenuItemServiceImpl public List<MenuItem> getMenuItemListCustomer(  END");
		return menuItemListCustomer;
	}

	@Override
	public MenuItem modifyMenuItem(int menuItemId, MenuItem menuItem) {
		log.info("MenuItemServiceImpl public MenuItem modifyMenuItem(int menuItemId, MenuItem menuItem) START");
		MenuItem menuItemModify = menuItemDaoImpl.modifyMenuItem(menuItemId, menuItem);
		log.info("MenuItemServiceImpl MenuItem modifyMenuItem(int menuItemId, MenuItem menuItem) END");
		return menuItemModify;
	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {
		log.info("MenuItemServiceImpl public MenuItem getMenuItem(int menuItemId) START");
		MenuItem menuItem = menuItemDaoImpl.getMenuItem(menuItemId);
		log.debug("MenuItem : {}", menuItem);
		log.info("MenuItemServiceImpl public MenuItem getMenuItem(int menuItemId) END");
		return menuItem;
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		log.info("MenuItemServiceImpl public MenuItem getMenuItem(MenuItem menuItem) START");
		MenuItem menuItemAdd = menuItemDaoImpl.addMenuItem(menuItem);
		log.info("MenuItemServiceImpl public MenuItem getMenuItem(MenuItem menuItem) START");
		return menuItemAdd;
	}

	@Override
	public MenuItem removeMenuItem(int menuItemId) {
		log.info("MenuItemServiceImpl public MenuItem removeMenuItem(int menuItemId) START");
		MenuItem menuItemRemove = menuItemDaoImpl.removeMenuItem(menuItemId);
		log.info("MenuItemServiceImpl public MenuItem removeMenuItem(int menuItemId) END");
		return menuItemRemove;
	}

}
