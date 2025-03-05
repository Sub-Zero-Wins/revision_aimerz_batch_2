package com.movie.repository;

import com.movie.entity.User;

public class UserRepository {
    User[] users = new User[10];
    int count = 0;

    public void register(User user) {
        if (count < users.length) {
            users[count++] = user;
        }
    }

    public User login(String username, String password) {
        for (int i = 0; i < count; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }
}