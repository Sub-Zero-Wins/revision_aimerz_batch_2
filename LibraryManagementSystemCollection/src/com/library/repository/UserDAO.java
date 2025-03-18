package com.library.repository;

import java.util.ArrayList;
import java.util.List;

import com.libray.beans.User;

public class UserDAO {
    private static List<User> users = new ArrayList<User>(100);
    private static int userCount = 0;
    
    public static boolean loadAdmin(User admin)
    {
    	 if (userCount == 0) {
            users.add(admin);
            userCount++;
             return true;
         }
         return false;
    }

    public boolean addUser(User user) {
      
    	users.add(user);
            
            return true;
        
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return users.get(i);
            }
        }
        return null;
    }
}