package com.lib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.beans.Account;
import com.lib.beans.Book;
import com.lib.beans.User;
import com.lib.dto.AccountDTO;
import com.lib.dto.LoginDTO;
import com.lib.service.AccountService;
import com.lib.service.BookService;
import com.lib.service.UserService;

@RestController
@RequestMapping("/api/user/lib")
public class UserController 
{
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return userService.registerUser(user.getName(), user.getEmail(), user.getPassword());
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginDTO loginDTO)
	{
		return userService.loginUser(loginDTO.getUsername(), loginDTO.getPassword());
	}
	
	@GetMapping("/viewAllBooks")
	public List<Book> viewAllBooks()
	{
		return bookService.getAllBooks();
	}
	
	@PostMapping("/placeAccount")
	public Account placeMyAccount(@RequestBody AccountDTO account)
	{
		return accountService.placeAccount(account.getUserId(), account.getBookId(), account.getIssueDate(), account.getDueDate(), account.getFine(), account.getStatus(),account.getQuantity());
	}
	
	@GetMapping("/myAccounts")
	public List<Account> viewMyAccounts()
	{
		return accountService.getAllAccounts();
	}

}
