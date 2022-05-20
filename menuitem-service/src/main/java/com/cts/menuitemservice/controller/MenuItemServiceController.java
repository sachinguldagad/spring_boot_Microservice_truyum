package com.cts.menuitemservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.menuitemservice.model.MenuItem;
import com.cts.menuitemservice.service.MenuItemServiceImpl;

@RestController
@RequestMapping(value = "/menu-item")
public class MenuItemServiceController {

	@Autowired
	MenuItemServiceImpl MenuItemServiceImpl;

	// Method is used to fetch MenuItem List for Admin
	@GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON)
	public List<MenuItem> getMenuItemListAdmin() {
		return MenuItemServiceImpl.getMenuItemListAdmin();
	}

	// Method is used to fetch MenuItem List for Customer
	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON)
	public List<MenuItem> getMenuItemListCustomer() {
		return MenuItemServiceImpl.getMenuItemListCustomer();
	}

	// Method is used to modify MenuItem by menuItemId and accessible for Admin
	@PutMapping(value = "/admin/{menuItemId}")
	public String modifyMenuItem(@PathVariable @Valid int menuItemId, @RequestBody MenuItem menuItem) {
		MenuItem MenuItemModify = MenuItemServiceImpl.modifyMenuItem(menuItemId, menuItem);
		return "Menu Item modify successfully. \n" + MenuItemModify.toString();
	}

	// Method is used to fetch MenuItem by MenuItem Id for Customer
	@GetMapping(value = "/customer/{menuItemId}", produces = MediaType.APPLICATION_JSON)
	public MenuItem getMenuItemCustomer(@PathVariable int menuItemId) {

		return MenuItemServiceImpl.getMenuItem(menuItemId);
	}

	// Method is used to fetch MenuItem by MenuItem Id for Admin
	@GetMapping(value = "/admin/{menuItemId}", produces = MediaType.APPLICATION_JSON)
	public MenuItem getMenuItemAdmin(@PathVariable int menuItemId) {

		return MenuItemServiceImpl.getMenuItem(menuItemId);
	}

	// Method is used to add MenuItem in Database and accessible for Admin
	@PostMapping(value = "/admin")
	public String addMenuItem(@RequestBody @Valid MenuItem menuItem) {
		MenuItem menuItemAdd = MenuItemServiceImpl.addMenuItem(menuItem);
		return "Menu Item added successfully. \n"+menuItemAdd.toString();
	}

	// Method is used to remove MenuItem from Database and accessible for Admin
	@DeleteMapping(value = "/admin/{menuItemId}")
	public String removeMenuItem(@PathVariable @Valid int MenuItemId) {
		MenuItem MenuItemRemove = MenuItemServiceImpl.removeMenuItem(MenuItemId);
		return "Menu Item removed successfully. \n"+MenuItemRemove.toString();
	}
}
