package com.movie.controller;

import java.util.Scanner;

import com.movie.entity.User;
import com.movie.repository.BookingRepository;
import com.movie.repository.MovieRepository;
import com.movie.repository.UserRepository;
import com.movie.service.AdminService;
import com.movie.service.UserService;

public class MovieBookingMain {

	    public static void main(String[] args) {
	        MovieRepository movieRepo = new MovieRepository();
	        UserRepository userRepo = new UserRepository();
	        AdminService adminService = new AdminService(movieRepo);
	        UserService userService = new UserService(movieRepo, userRepo);
	        
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("1. Admin Login\n2. Add Movie\n3. Update Movie\n4. Delete Movie\n5."
	            		+ " User Register\n6. User Login\n7. View Movies\n8. Search Movies\n9. Rate & Review Movie"
	            		+ "\n10. Exit");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	            switch (choice) {
	                case 1:
	                    System.out.println("Enter Admin Username:");
	                    String adminUser = scanner.nextLine();
	                    System.out.println("Enter Password:");
	                    String adminPass = scanner.nextLine();
	                    if (adminUser.equals("admin") && adminPass.equals("admin")) {
	                        System.out.println("Admin Logged In");
	                    }
	                    break;
	                case 2:
	                    System.out.println("Enter Movie ID:");
	                    int id = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Enter Movie Name:");
	                    String name = scanner.nextLine();
	                    System.out.println("Enter Category:");
	                    String category = scanner.nextLine();
	                    adminService.addMovie(id, name, category);
	                    break;
	                case 3:
	                    System.out.println("Enter Movie ID:");
	                    int updateId = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Enter New Name:");
	                    String newName = scanner.nextLine();
	                    System.out.println("Enter New Category:");
	                    String newCategory = scanner.nextLine();
	                    adminService.updateMovie(updateId, newName, newCategory);
	                    break;
	                case 4:
	                    System.out.println("Enter Movie ID:");
	                    int deleteId = scanner.nextInt();
	                    adminService.deleteMovie(deleteId);
	                    break;
	                case 5:
	                    System.out.println("Enter Username:");
	                    String username = scanner.nextLine();
	                    System.out.println("Enter Password:");
	                    String password = scanner.nextLine();
	                    userRepo.register(new User(username, password, false));
	                    break;
	                case 6:
	                    System.out.println("Enter Username:");
	                    String loginUser = scanner.nextLine();
	                    System.out.println("Enter Password:");
	                    String loginPass = scanner.nextLine();
	                    userRepo.login(loginUser, loginPass);
	                    break;
	                case 7:
	                    userService.viewMovies();
	                    break;
	                case 8:
	                    System.out.println("Enter Category:");
	                    String searchCategory = scanner.nextLine();
	                    userService.searchMovies(searchCategory);
	                    break;
	                case 9:
	                    System.out.println("Enter Movie ID:");
	                    int movieId = scanner.nextInt();
	                    scanner.nextLine();
	                    System.out.println("Enter Review:");
	                    String review = scanner.nextLine();
	                    System.out.println("Enter Rating:");
	                    double rating = scanner.nextDouble();
	                    userService.addReview(movieId, review, rating);
	                    break;
	                case 10:
	                    System.exit(0);
	            }
	        }
	    }
	}
