package com.library.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.libray.beans.Account;


public class AccountDAO {
    private static List<Account> accounts = new ArrayList<Account>(100);
    private static int accountCount = 0;

    public boolean addAccount(Account account) {
    	
           accounts.add(account);
            return true;
        
     
    }

    public List<Account> getAccountsByUserId(int userId) {
       List<Account> list= new ArrayList();
        int index = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserId() == userId) {
                list.add(accounts.get(index));
            }
        }
      
        return list;
    }

    public List<Account> getAllAccounts() {
        return  accounts;
    }
    
}