package com.library.service;

import java.util.List;

import com.library.repository.AccountDAO;
import com.library.repository.BookDAO;
import com.library.repository.UserDAO;
import com.libray.beans.Book;

public class BookService {
    private BookDAO bookDAO = new BookDAO();
    private UserDAO userDAO = new UserDAO();
    private AccountDAO orderDAO = new AccountDAO();

    public boolean addBook( String name, String author, String language,double price, int stock) {
        return bookDAO.addBook(new Book(((long)(new Book().hashCode())),  name, author, language,price ,stock));
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    
    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }
    
    
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
    
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

 
}
