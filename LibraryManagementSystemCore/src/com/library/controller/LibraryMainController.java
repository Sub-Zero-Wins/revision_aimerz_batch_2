package com.library.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.library.repository.UserDAO;
import com.library.service.AccountService;
import com.library.service.BookService;
import com.library.service.UserService;
import com.libray.beans.Account;
import com.libray.beans.Book;
import com.libray.beans.IssueStatus;
import com.libray.beans.User;

public class LibraryMainController {

	private static Scanner scanner = new Scanner(System.in);
	private static UserService userService = new UserService();
	private static BookService adminService = new BookService();
	private static AccountService accountService = new AccountService();
	private static User loggedInUser = null;

	static {
		UserDAO.loadAdmin(new User(1,"admin", "admin@ecomm.in", "admin@123","ADMIN"));
		// load books on startup
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n===== Digital Library Application =====");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				registerUser();
				break;
			case 2:
				loginUser();
				break;
			case 3:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private static void registerUser() {
		System.out.print("Enter Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		if (userService.registerUser(name, email, password)) {
			System.out.println("Registration successful!");
		} else {
			System.out.println("Registration failed.");
		}
	}

	private static void loginUser() {
		System.out.print("Enter Email: ");
		String email = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		loggedInUser = userService.loginUser(email, password);
		if (loggedInUser != null) {
			System.out.println("Login successful! Welcome, " + loggedInUser.getName());
			if (loggedInUser.getRole().equals("ADMIN")) {
				adminMenu();
			} else {
				userMenu();
			}
		} else {
			System.out.println("Invalid email or password.");
		}
	}

	private static void adminMenu() {
		while(true)
		{
			System.out.println("1. Add Book");
			System.out.println("2. View Books");
			System.out.println("3. exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				
			System.out.print("Enter Book Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Book Author: ");
				String author = scanner.nextLine();
				System.out.print("Enter Book Language: ");
				String language = scanner.nextLine();
				System.out.print("Enter Book Price: ");
				double price = scanner.nextDouble();
				System.out.print("Enter Stock: ");
				int stock = scanner.nextInt();

				adminService.addBook(name,author,language, price, stock);
				System.out.println("Book Added!");
			} else if(choice == 2) {
				Book[] books = adminService.getAllBooks();
				for (Book p : books) {
					System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice()+" "+p.getAuthor() +" "+p.getLanguage()+" "+" "+p.getPrice()+" "+p.getStock());
				}
			}
			else if(choice == 3) {
				break;
			}
		}
	}
	private static void userMenu() {
		while (true) {
			System.out.println("\n===== User Menu =====");
			System.out.println("1. View Books");
			System.out.println("2. Place Account");
			System.out.println("3. View My Accounts");
			System.out.println("4. Logout");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewBooks();
				break;
			case 2:
				placeAccount();
				break;
			case 3:
				viewAccounts();
				break;
			case 4:
				System.out.println("Logging out...");
				return;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	private static void viewBooks() {
		Book[] books = adminService.getAllBooks();
		if (books == null) {
			System.out.println("No books available.");
			return;
		}
		System.out.println("\n===== Available Books =====");
		for (Book book : books) {
			System.out.println(book.getId() + ". " + book.getName() + " - $" + book.getPrice() + " (Stock: " + book.getStock() + ")");
		}
	}

	private static void placeAccount() {
		viewBooks();
		System.out.print("Enter book ID to purchase: ");
		long bookId = scanner.nextLong();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		Book book2 = adminService.getBookById((int)bookId);


			if (book2 == null || book2.getStock() < quantity) {
				System.out.println("Invalid book ID or insufficient stock.");
				return;
			}

			double totalPrice = book2.getPrice() * quantity;
			
			LocalDate issueDate=LocalDate.now();
			
			LocalDate dueDate = issueDate.plusDays(5);
			
			
			if (accountService.placeAccount(loggedInUser.getId(),book2.getId(),issueDate.toString(),dueDate.toString(),0,IssueStatus.PENDING,quantity)) {
				adminService.updateBook(new Book(bookId,book2.getName(),book2.getAuthor(),book2.getLanguage(),book2.getPrice(), book2.getStock() - quantity));
				System.out.println("Account placed successfully! Total cost: $" + totalPrice);
			} else {
				System.out.println("Account failed. Please try again.");
			}
		}
	

	private static void viewAccounts() {
		Account[] accounts = accountService.getUserAccounts(loggedInUser.getId());
		if (accounts == null) {
			System.out.println("No accounts found.");
			return;
		}
		System.out.println("\n===== Your Accounts =====");
		for (Account account : accounts) {
			System.out.println("Account ID: " + account.getTxnId() + " | Book ID: " + account.getBookId() + 
					" | Quantity: " + account.getDueDate() + " | Total Price: $" + account.getFine());
		}
	}

}
