package com.cts.cartservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "user_carts")
@Data
@Slf4j
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Min(value = 1,message = "User ID should not be 0 or less than 0")
	@Column(name = "user_id")
	private int user_id;
	
	@Min(value = 1,message = "Item ID should not be 0 or less than 0")
	@Column(name = "item_id")
	private int item_id;
	
	//constructor
	public Cart(){
		log.info("Cart object created.");
	}
}