package com.bank.controller;

import java.util.Scanner;

import com.bank.beans.User;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;

public class BankController
{
	 static BankRepository repo = new BankRepository();
	 static BankService service = new BankService(repo);
	 
	    static Scanner sc = new Scanner(System.in);
	    
	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("1. Register 2. Login 3. Exit");
	            int choice = sc.nextInt();
	            sc.nextLine(); // Consume newline
	            if (choice == 1) registerUser();
	            else if (choice == 2) loginUser();
	            else break;
	        }
	    }
	    
	    static void registerUser() {
	        System.out.print("Enter Username: ");
	        String username = sc.nextLine();
	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();
	        System.out.print("Enter Role (Admin/Customer): ");
	        String role = sc.nextLine();
	        int accountId = -1;
	        if (role.equalsIgnoreCase("Customer")) {
	            System.out.print("Enter Account ID: ");
	            accountId = sc.nextInt();
	        }
	        service.repo.addUser(username, password, role, accountId);
	        System.out.println("User registered successfully!");
	    }
	    
	    static void loginUser() {
	        System.out.print("Enter Username: ");
	        String username = sc.nextLine();
	        System.out.print("Enter Password: ");
	        String password = sc.nextLine();
	        User user = service.repo.authenticateUser(username, password);
	        if (user != null) {
	            if (user.getRole().equalsIgnoreCase("Admin")) adminMenu();
	            else customerMenu(user.getAccountId());
	        } else {
	            System.out.println("Invalid credentials.");
	        }
	    }
	    
	    static void adminMenu() {
	        while (true) {
	            System.out.println("1. Create Account 2. Enable/Disable Account  3.View All transactions 4.View All accounts 5.Logout");
	            int choice = sc.nextInt();
	            if (choice == 1) {
	                System.out.println("Enter ID, Name, Balance: ");
	                service.repo.createAccount(sc.nextInt(), sc.next(), sc.nextDouble());
	            } else if (choice == 2) {
	                System.out.println("Enter Account ID: ");
	                service.repo.toggleAccountStatus(sc.nextInt());
	            }else if (choice == 3) {
	                System.out.println("here are all transactions");
	                service.repo.viewTransactions();
	                
	            }
	            else if (choice == 4) {
	                System.out.print("here are all accounts");
	                service.repo.getAllAccounts();
	            }
	            else break;
	        }
	    }
	    
	    static void customerMenu(int accountId) {
	        while (true) {
	            System.out.println("1. Deposit 2. Withdraw 3. Transfer 4. View Transactions 5. view Balance 6. Logout");
	            int choice = sc.nextInt();
	            if (choice == 1) service.deposit(accountId, sc.nextDouble());
	            else if (choice == 2) service.withdraw(accountId, sc.nextDouble());
	            else if (choice == 3) service.transfer(accountId, sc.nextInt(), sc.nextDouble());
	            else if (choice == 4) service.repo.viewTransactions(accountId);
	            else if (choice == 5) service.repo.viewBalance(accountId);
	            else break;
	        }
	    }
	}



