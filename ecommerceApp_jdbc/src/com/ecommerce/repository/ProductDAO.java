package com.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.beans.Product;
import com.ecommerce.util.JdbcConnection;

public class ProductDAO {

	public boolean addProduct(Product product) {
		// increase stock for if product already exist
		String selectSql = "SELECT stock FROM product WHERE id = ?";
		String updateSql = "UPDATE product SET stock = ? WHERE id = ?";
		String insertSql = "INSERT INTO product (id, name, price, stock) VALUES (?, ?, ?, ?)";
		try (Connection conn = JdbcConnection.getConnection())
		{
			try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
				selectStmt.setInt(1, product.getId());
				ResultSet rs = selectStmt.executeQuery();

				if (rs.next()) {
					// Product exists, update stock
					try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
						updateStmt.setInt(1, product.getStock());
						updateStmt.setInt(2, product.getId());
						updateStmt.executeUpdate();
						return true;
					}
				}

			}
			// Product doesn't exist, insert new
			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
				insertStmt.setInt(1, product.getId());
				insertStmt.setString(2, product.getName());
				insertStmt.setDouble(3, product.getPrice());
				insertStmt.setInt(4, product.getStock());
				int res= insertStmt.executeUpdate();
				if(res>0)
					return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}




	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM product";
		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Product product = new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getInt("stock")
						);
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}


	public Product getProductById(int productId) {
		String sql = "SELECT * FROM product WHERE id = ?";

		try (Connection conn = JdbcConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Product(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getInt("stock")
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}