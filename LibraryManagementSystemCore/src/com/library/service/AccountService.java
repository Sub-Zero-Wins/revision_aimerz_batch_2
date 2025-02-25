package com.library.service;

import com.library.repository.AccountDAO;
import com.library.repository.BookDAO;
import com.libray.beans.Account;
import com.libray.beans.Book;
import com.libray.beans.IssueStatus;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAO();
    private BookDAO bookDAO = new BookDAO();

    public boolean placeAccount(int userId, long bookId, String issueDate, String dueDate, double fine,
			IssueStatus status,int quantity) {
        Book product = bookDAO.getBookById((int)bookId);
        if (product == null || product.getStock() < quantity) {
            return false;
        }
        product.setStock(product.getStock() - quantity);
        return accountDAO.addAccount(new Account (new Account().hashCode(), userId, (int)bookId,  issueDate,  dueDate, fine, status));
    }

    public Account[] getUserAccounts(int userId) {
        return accountDAO.getAccountsByUserId(userId);
    }
    
    public Account[] getAllAccounts()
    {
    	return accountDAO.getAllAccounts();
    }
}