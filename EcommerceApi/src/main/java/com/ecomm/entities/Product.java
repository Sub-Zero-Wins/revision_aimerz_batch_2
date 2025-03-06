package com.ecomm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
    private int productId;
    private String name;
    private double price;
    private int stock;
    private String category;
    
   
    
}