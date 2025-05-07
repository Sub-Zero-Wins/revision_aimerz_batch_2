package com.ecommerce.service;

import com.ecommerce.beans.User;
import com.ecommerce.repository.UserDAO;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean registerUser(String name, String email, String password) {
        if (userDAO.getUserByEmail(email) != null) {
            return false;
        }
        return userDAO.addUser(new User(userDAO.hashCode(), name, email, password, "USER"));
    }

    public User loginUser(String email, String password) {
        User user = userDAO.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}