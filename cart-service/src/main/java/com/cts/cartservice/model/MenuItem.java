package com.cts.cartservice.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MenuItem {

	private int menuItemId;
	private String menuItemName;
	private String menuItemCategory;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date menuItemDateOfLaunch;
	private float menuItemPrice;
	private boolean menuItemActive;
	private boolean menuItemFreeDelivery;
}