package com.ecommerce.repository;

import java.util.Arrays;

import com.ecommerce.beans.Order;

public class OrderDAO {
    private static Order[] orders = new Order[100];
    private static int orderCount = 0;

    public boolean addOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount++] = order;
            return true;
        }
        return false;
    }

    public Order[] getOrdersByUserId(int userId) {
        Order[] userOrders = new Order[orderCount];
        int index = 0;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getUserId() == userId) {
                userOrders[index++] = orders[i];
            }
        }
        Order[] result = new Order[index];
        System.arraycopy(userOrders, 0, result, 0, index);
        return result;
    }

    public Order[] getAllOrders() {
        return Arrays.copyOf(orders, orderCount);
    }
    
}