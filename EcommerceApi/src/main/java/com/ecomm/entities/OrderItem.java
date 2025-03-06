package com.ecomm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem 
{
	@Id
	private int id;	
	private Order order;
	@ManyToOne
	private Product product;
	private int quantity;
	private double price;

}
