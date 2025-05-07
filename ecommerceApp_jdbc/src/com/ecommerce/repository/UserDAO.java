package com.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecommerce.beans.User;
import com.ecommerce.util.JdbcConnection;

public class UserDAO {
	 public static boolean loadAdmin(User admin) {
	        return addUser(admin); // Reuses addUser method
	    }

	    public static boolean addUser(User user) {
	        String sql = "INSERT INTO user (id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";

	        try (Connection conn = JdbcConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, user.getId());
	            stmt.setString(2, user.getName());
	            stmt.setString(3, user.getEmail());
	            stmt.setString(4, user.getPassword());
	            stmt.setString(5, user.getRole());

	            stmt.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public User getUserByEmail(String email) {
	        String sql = "SELECT * FROM user WHERE email = ?";

	        try (Connection conn = JdbcConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, email);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                return new User(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("email"),
	                    rs.getString("password"),
	                    rs.getString("role")
	                );
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

}