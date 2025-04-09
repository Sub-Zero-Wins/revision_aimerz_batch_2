package com.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lib.beans.Book;
import com.lib.repo.BookRepo;

public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepo repo;

	@Override
	public boolean addBook(String name, String author, String language, double price, int stock) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

}
