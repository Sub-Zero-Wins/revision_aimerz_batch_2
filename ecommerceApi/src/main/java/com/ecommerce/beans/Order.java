package com.ecommerce.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="Orders")
public class Order {
	@Id
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private double totalPrice;
   
    // Constructor
    public Order(int id, int userId, int productId, int quantity, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}
    

}
