package com.library.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.library.util.JdbcConnection;
import com.libray.beans.Account;
import com.libray.beans.Book;


public class AccountDAO {
    private static List<Account> accounts = new ArrayList<Account>(100);
    private static int accountCount = 0;

    public boolean addAccount(Account account) {
    	try {
			Connection conn=JdbcConnection.getConnection();
			    
			
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO Account (txnId,userId, bookId, issueDate,dueDate,fine,status) VALUES\r\n"
					+ "(?,?,?,?,?,?,?) ");
			
			pstmt.setInt(1,account.getTxnId());
			pstmt.setInt(2, account.getUserId());
			pstmt.setInt(3, account.getBookId());
			pstmt.setString(4, account.getIssueDate());
			pstmt.setString(5, account.getDueDate());
			pstmt.setDouble(6, account.getFine());
			pstmt.setString(7, account.getStatus().toString());
			
			int rowsUpdated=pstmt.executeUpdate();
			System.out.println(rowsUpdated+ " account added");
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
        
     
    }

    public List<Account> getAccountsByUserId(int userId) {
       List<Account> list= new ArrayList<Account>();
       try {
			Connection conn=JdbcConnection.getConnection();
			
			PreparedStatement stmt=conn.prepareStatement("select * from account where userId=?");
			stmt.setInt(1, userId);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
			list.add(new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        return list;
    }

    public List<Account> getAllAccounts() {
    	List<Account> accounts = new ArrayList<Account>(100);;
		try {
			Connection conn=JdbcConnection.getConnection();
		
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from Account");

			     while(rs.next())	{
			    	 accounts.add(new Account(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
			     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
    }
    
}