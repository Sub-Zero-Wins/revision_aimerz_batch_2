package com.ecommerce.controller;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ecommerce.beans.Order;
import com.ecommerce.beans.Product;
import com.ecommerce.beans.User;
import com.ecommerce.repository.UserDAO;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;

public class EcommerceMainController {

	private static Scanner scanner = new Scanner(System.in);
	private static UserService userService = new UserService();
	private static ProductService adminService = new ProductService();
	private static OrderService orderService = new OrderService();
	private static User loggedInUser = null;

	static {
        UserDAO.loadAdmin(new User(1,"admin", "admin@ecomm.in", "admin@123","ADMIN"));
        // load products on startup
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n===== E-Commerce Application =====");
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
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				System.out.print("Enter Product id");
				int id= scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Product Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Price: ");
				double price = scanner.nextDouble();
				System.out.print("Enter Stock: ");
				int stock = scanner.nextInt();
				adminService.addProduct(id,name, price, stock);
				System.out.println("Product Added!");
			} else if(choice == 2) {
				List<Product> products = adminService.getAllProducts();
				for (Product p : products) {
					System.out.println(p.getId() + " - " + p.getName() + " - $" + p.getPrice());
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
			System.out.println("1. View Products");
			System.out.println("2. Place Order");
			System.out.println("3. View My Orders");
			System.out.println("4. Logout");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				viewProducts();
				break;
			case 2:
				placeOrder();
				break;
			case 3:
				viewOrders();
				break;
			case 4:
				System.out.println("Logging out...");
				return;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}

	private static void viewProducts() {
		List<Product> products = adminService.getAllProducts();
		if (products == null) {
			System.out.println("No products available.");
			return;
		}
		System.out.println("\n===== Available Products =====");
		for (Product product : products) {
			System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice() + " (Stock: " + product.getStock() + ")");
		}
	}

	private static void placeOrder() {
		viewProducts();
		System.out.print("Enter product ID to purchase: ");
		int productId = scanner.nextInt();
		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		List<Product> product = new CopyOnWriteArrayList<Product>(adminService.getAllProducts());
        Product product2 = null;
		for (Product p : product) {
			{  if(p.getId()==productId)
				product2 = p;
			}
			


			if (product2 == null || product2.getStock() < quantity) {
				System.out.println("Invalid product ID or insufficient stock.");
				return;
			}

			double totalPrice = product2.getPrice() * quantity;
			if (orderService.placeOrder(loggedInUser.getId(), productId, quantity, totalPrice)) {
				adminService.addProduct(productId,product2.getName(), product2.getPrice(), product2.getStock() - quantity);
				System.out.println("Order placed successfully! Total cost: $" + totalPrice);
			} else {
				System.out.println("Order failed. Please try again.");
			}
		}
		
	}

	private static void viewOrders() {
		List<Order> orders = orderService.getUserOrders(loggedInUser.getId());
		if (orders == null) {
			System.out.println("No orders found.");
			return;
		}
		System.out.println("\n===== Your Orders =====");
		for (Order order : orders) {
			System.out.println("Order ID: " + order.getId() + " | Product ID: " + order.getProductId() + 
					" | Quantity: " + order.getQuantity() + " | Total Price: $" + order.getTotalPrice());
		}
	}

}
