package com.ecomm.entities;

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
    @ManyToOne
    private User user;
    private String status;  
    @OneToMany
    private List<OrderItem> orderItem;
   
   

}
