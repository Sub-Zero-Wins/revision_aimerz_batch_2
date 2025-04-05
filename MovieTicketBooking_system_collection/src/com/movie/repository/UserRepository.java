package com.movie.repository;

import java.util.ArrayList;
import java.util.List;

import com.movie.entity.User;

public class UserRepository {
    List<User> users = new ArrayList<User>();
    int count = 0;

    public void register(User user) {
       
           users.add(user);
           count++;
        
    }

    public User login(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
                return users.get(i);
            }
        }
        return null;
    }
}