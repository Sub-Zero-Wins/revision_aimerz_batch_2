package com.ecom.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
    private int orderId;
    private int userId;
    private String status;  
    @OneToMany
    private List<OrderItem> orderItem;
    
	public void setStatus(String status) {
		this.status=status;
		
	}
   
   

}
