package com.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.beans.Book;
import com.lib.repository.AccountRepository;
import com.lib.repository.BookRepository;
import com.lib.repository.UserRepository;

@Service
public class BookService {
	@Autowired
    private BookRepository bookRepository;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private AccountRepository orderRepository;
	

//    public Book addBook( String name, String author, String language,double price, int stock) {
//        return bookRepository.save(new Book(((long)(new Book().hashCode())),  name, author, language,price ,stock));
//    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }
    
    
    public Book addBook(Book book) {
       return bookRepository.save(book);
    }
    
    public Book updateBook(Book book) {
       
    	if(bookRepository.findById(book.getId())!=null)
    	{
    		return bookRepository.save(book);
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public String deleteBook(int id)
    {
    	if(bookRepository.findById(id)!=null)
    	{
    		bookRepository.deleteById(id);

    		return "book deleted with id "+id;
    	}
    	else
    	{
    		return "book not found";
    	}
    		
     }

 
}
