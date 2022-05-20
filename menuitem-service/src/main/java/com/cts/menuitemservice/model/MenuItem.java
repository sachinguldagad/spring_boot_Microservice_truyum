package com.cts.menuitemservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="menuitem")
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menuItemId;

	private String menuItemName;
	
	private String menuItemCategory;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date menuItemDateOfLaunch;
	
	private float menuItemPrice;
	
	private boolean menuItemActive;
	
	private boolean menuItemFreeDelivery;

}
