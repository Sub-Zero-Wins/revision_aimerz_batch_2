package com.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.beans.Order;
import com.ecommerce.util.JdbcConnection;

public class OrderDAO {


	public boolean addOrder(Order order) {
		String sql = "INSERT INTO orders (id, userId, productId, quantity, totalPrice) VALUES (?, ?, ?, ?, ?)";

		try {
			Connection conn =JdbcConnection.getConnection();
			PreparedStatement stmt=conn.prepareStatement(sql);

			stmt.setInt(1, order.getId());
			stmt.setInt(2, order.getUserId());
			stmt.setInt(3, order.getProductId());
			stmt.setInt(4, order.getQuantity());
			stmt.setDouble(5, order.getTotalPrice());
			int res=   stmt.executeUpdate();
			if (res>0)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Order> getOrdersByUserId(int userId) {
		String sql = "SELECT * FROM orders WHERE userId = ?";
		List<Order> userOrders = new ArrayList<>();
		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();



			while (rs.next()) {
				Order order = new Order(
						rs.getInt("id"),
						rs.getInt("userId"),
						rs.getInt("productId"),
						rs.getInt("quantity"),
						rs.getDouble("totalPrice")
						);
				userOrders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userOrders;


	}

	public List<Order> getAllOrders() {
		String sql = "SELECT * FROM orders";
		List<Order> orders = new ArrayList<>();
		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Order order = new Order(
						rs.getInt("id"),
						rs.getInt("userId"),
						rs.getInt("productId"),
						rs.getInt("quantity"),
						rs.getDouble("totalPrice")
						);
				orders.add(order);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

}