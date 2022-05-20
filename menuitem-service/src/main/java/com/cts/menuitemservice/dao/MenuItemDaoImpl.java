package com.cts.menuitemservice.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.menuitemservice.exception.MenuItemNotFoundException;
import com.cts.menuitemservice.model.MenuItem;
import com.cts.menuitemservice.repository.MenuItemRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MenuItemDaoImpl implements MenuItemDao {

	/*
	 * Reference is used to retrieve SweetItem Data from Database
	 */
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListAdmin() START");
		// Gives list of all MenuItems
		List<MenuItem> menuItemListAdmin = menuItemRepository.findAll();
		log.debug("MenuItemListAdmin: {}", menuItemListAdmin);
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListAdmin()  END");
		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListCustomer() START");
		List<MenuItem> menuItemListCustomer = menuItemRepository.findAll();
		Iterator<MenuItem> menuItemListIterator = menuItemListCustomer.iterator();
		// Gives list of all active MenuItems
		while (menuItemListIterator.hasNext()) {
			MenuItem menuItem = menuItemListIterator.next();
			if (!menuItem.isMenuItemActive()) {
				menuItemListIterator.remove();
			}
		}
		log.debug("MenuItemListCustomer: {}", menuItemListCustomer);
		log.info("MenuItemDaoImpl public List<MeunItem> getMenuItemListCustomer()  END");
		return menuItemListCustomer;
	}

	@Override
	public MenuItem modifyMenuItem(int menuItemId, MenuItem menuItem) {
		log.info("public void modifyMenuItem(int menuItemId, MenuItem menuItem) START");
		MenuItem menuItemFound = menuItemRepository.findById(menuItemId).orElseThrow(() -> {
			throw new MenuItemNotFoundException();
		});
		menuItemFound.setMenuItemName(menuItem.getMenuItemName());
		menuItemFound.setMenuItemCategory(menuItem.getMenuItemCategory());
		menuItemFound.setMenuItemDateOfLaunch(menuItem.getMenuItemDateOfLaunch());
		menuItemFound.setMenuItemPrice(menuItem.getMenuItemPrice());
		menuItemFound.setMenuItemActive(menuItem.isMenuItemActive());
		menuItemFound.setMenuItemFreeDelivery(menuItem.isMenuItemFreeDelivery());
		log.info("public void modifyMenuItem(int menuItemId, MenuItem menuItem)  END");
		return menuItemFound;
	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {
		log.info("public MenuItem getMenuItem(int menuItemId) START");
		MenuItem menuItemFound = menuItemRepository.findById(menuItemId).orElseThrow(() -> {
			throw new MenuItemNotFoundException();
		});
		log.debug("MenuItemFound : {}", menuItemFound);
		log.info("public MenuItem getMenuItem(int menuItemId)  END");
		return menuItemFound;
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		log.info("public void addMenuItem(MenuItem menuItem) START");
		menuItemRepository.save(menuItem);
		log.debug("MenuItem : {}", menuItem);
		log.info("public void addMenuItem(MenuItem menuItem)  END");
		return menuItem;
	}

	@Override
	public MenuItem removeMenuItem(int menuItemId) {
		log.info("public void removeMenuItem(int menuItemId) START");
		MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow(() -> {
			throw new MenuItemNotFoundException();
		});
		menuItemRepository.delete(menuItem);
		log.info("public void removeMenuItem(int menuItemId)  END");
		return menuItem;
	}

}
