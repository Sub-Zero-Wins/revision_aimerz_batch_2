package com.library.repository;

import java.util.Arrays;

import com.libray.beans.Account;


public class AccountDAO {
    private static Account[] accounts = new Account[100];
    private static int accountCount = 0;

    public boolean addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
            return true;
        }
        return false;
    }

    public Account[] getAccountsByUserId(int userId) {
        Account[] userAccounts = new Account[accountCount];
        int index = 0;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getUserId() == userId) {
                userAccounts[index++] = accounts[i];
            }
        }
        Account[] result = new Account[index];
        System.arraycopy(userAccounts, 0, result, 0, index);
        return result;
    }

    public Account[] getAllAccounts() {
        return Arrays.copyOf(accounts, accountCount);
    }
    
}