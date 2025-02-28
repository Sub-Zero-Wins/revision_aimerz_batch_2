package com.bank.repository;

import com.bank.beans.Account;
import com.bank.beans.Transactions;
import com.bank.beans.User;

public class BankRepository 
{
	Account[] accounts = new Account[100];
	Transactions[] transactions = new Transactions[1000];
	User[] users = new User[100];

	int accountCount = 0;
	int transactionCount = 0;
	int userCount = 0;

	public void createAccount(int id, String name, double balance) {
		accounts[accountCount++] = new Account(id, name, balance);
	}
	
	 public Account getAccount(int id) {
	        for (int i = 0; i < accountCount; i++) {
	            if (accounts[i] != null && accounts[i].getId() == id) {
	                return accounts[i];
	            }
	        }
	        return null;
	    }

	 public Account getAllAccounts() {
	        for (int i = 0; i < accountCount; i++) {
	            {
	              System.out.println(accounts[i]);
	            }
	        }
	        return null;
	    }

	 public void addUser(String username, String password, String role, int accountId) {
	        users[userCount++] = new User(username, password, role, accountId);
	    }

	  public User authenticateUser(String username, String password) {
	        for (int i = 0; i < userCount; i++) {
	            if (users[i] != null && users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
	                return users[i];
	            }
	        }
	        return null;
	    }

	  public void updateAccount(int id, String name, double balance) {
	        Account acc = getAccount(id);
	        if (acc != null) {
	            acc.setName(name);
	            acc.setBalance(balance);
	        }
	    }
	    
	    public void deleteAccount(int id) {
	        for (int i = 0; i < accountCount; i++) {
	            if (accounts[i] != null && accounts[i].getId() == id) {
	                accounts[i] = null;
	                break;
	            }
	        }
	    }
	    
	    public void toggleAccountStatus(int accountId) {
	        Account acc = getAccount(accountId);
	        if (acc != null) {
	            acc.setActive(!acc.isActive());
	            System.out.println("Account " + accountId + " is now " + (acc.isActive() ? "Active" : "Disabled"));
	        }
	    }
        
	    public void addTransaction(int accountId, String type, double amount) {
	        transactions[transactionCount++] = new Transactions(accountId, type, amount);
	    }
	    
	    public void viewTransactions() {
	        for (int i = 0; i < transactionCount; i++) {
	        
	            System.out.println("Account " + transactions[i].getAccountId() + " " + transactions[i].getType() + " " + transactions[i].getAmount());
	        }
	    }
	    public void viewTransactions(int accountId) {
	        System.out.println("Transactions for Account " + accountId + ":");
	        for (int i = 0; i < transactionCount; i++) {
	            if (transactions[i] != null && transactions[i].getAccountId() == accountId) {
	                System.out.println(transactions[i].getType() + " - " + transactions[i].getAmount());
	            }
	        }
	    }
	    
	    public void viewBalance(int accountId) {
	        System.out.println("Available Balance for Account " + accountId + ":");
	        for (int i = 0; i < accountCount; i++) {
	            if (accounts[i] != null && accounts[i].getId() == accountId) {
	                System.out.println(accounts[i].getBalance());
	            }
	        }
	    }
	    
	    



}
