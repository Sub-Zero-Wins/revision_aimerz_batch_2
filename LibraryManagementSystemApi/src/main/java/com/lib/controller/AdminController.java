package com.lib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.beans.Book;
import com.lib.service.BookService;

@RestController
@RequestMapping("/api/admin/lib")
public class AdminController 
{
	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book)
	{
       return bookService.addBook(book); 
	}

	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book)
	{
		return bookService.updateBook(book);
        
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id)
	{
        return bookService.deleteBook(id);
	}
	
	//login
	


}
