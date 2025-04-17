package com.library.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.util.JdbcConnection;
import com.libray.beans.Book;


public class BookDAO {
	

	

	public boolean addBook(Book book) 
	{
	
		try {
			Connection conn=JdbcConnection.getConnection();
			    
			
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO Book (id, name, author, language, price, stock) VALUES\r\n"
					+ "(?,?,?,?,?,?) ");
			
			pstmt.setLong(1,book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getLanguage());
			pstmt.setDouble(5, book.getPrice());
			pstmt.setInt(6, book.getStock());
			
			int rowsUpdated=pstmt.executeUpdate();
			System.out.println(rowsUpdated+ " book added");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
		
	}

	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<Book>(100);;
		try {
			Connection conn=JdbcConnection.getConnection();
		
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from book");

			     while(rs.next())	{
			    	 books.add(new Book(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6)));
			     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}

	public Book getBookById(long bookId) {
		Book book=null;
		try{
			Connection conn=JdbcConnection.getConnection();
			
			PreparedStatement stmt=conn.prepareStatement("select * from book where id=?");
			stmt.setLong(1, bookId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				book=new Book(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6));
				   
			}
			return book;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public boolean updateBook(Book book) {
		try {
			Connection conn=JdbcConnection.getConnection();
			
			PreparedStatement pstmt=conn.prepareStatement("update book set  name=? author=? language=? price=? stock=? where id=?");

			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getLanguage());
			pstmt.setDouble(4, book.getPrice());
			pstmt.setInt(5, book.getStock());
			pstmt.setLong(6,book.getId());
			
			int rs=pstmt.executeUpdate();
			
			System.out.println(rs+" book updated");
			   return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}