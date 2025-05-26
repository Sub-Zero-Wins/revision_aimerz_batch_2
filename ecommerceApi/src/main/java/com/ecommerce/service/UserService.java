package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.beans.User;
import com.ecommerce.repository.UserDAO;

@Service
public class UserService {
	
	@Autowired
    private UserDAO userDAO ;

    public User registerUser(String name, String email, String password) {
        if (userDAO.findUserByEmail(email) != null) {
            return null;
        }
        return userDAO.save(new User(userDAO.hashCode(), name, email, password, "USER"));
    }

    public User loginUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}