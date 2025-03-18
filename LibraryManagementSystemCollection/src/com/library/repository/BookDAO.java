package com.library.repository;

import java.util.ArrayList;
import java.util.List;

import com.libray.beans.Book;


public class BookDAO {
	private static List<Book> books = new ArrayList<Book>(100);

	private static int bookCount = 0;

	public boolean addBook(Book book) {
		 // only increase the stock if book is duplicate
			books.add(book);
			return true;
		
	}

	public List<Book> getAllBooks() {
		
		return books;
	}

	public Book getBookById(long bookId) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == bookId) {
				System.out.println(books.get(i));
				return books.get(i);
			}
		}
		return null;
	}

	public boolean updateBook(Book updateBook) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getId() == updateBook.getId()) {
				books.add(updateBook);
				return true;
			}
		}
		return false;
	}
}