package com.lib.service;

import java.util.List;

import com.lib.beans.Book;

public interface BookService 
{
	  public boolean addBook( String name, String author, String language,double price, int stock) ;

	    public List<Book> getAllBooks() ;
	    
	    public Book getBookById(int id) ;
	    
	    
	    public void addBook(Book book);
	    
	    public void updateBook(Book book);


}
