package com.lib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.beans.Account;
import com.lib.beans.Book;
import com.lib.beans.IssueStatus;
import com.lib.repository.AccountRepository;
import com.lib.repository.BookRepository;

@Service
public class AccountService {
	@Autowired
    private AccountRepository accountRepo ;
	
	@Autowired
    private BookRepository bookRepo;

    public Account placeAccount(int userId, long bookId, String issueDate, String dueDate, double fine,
			IssueStatus status,int quantity) {
        Book product = bookRepo.findById((int)bookId).get();
        if (product == null || product.getStock() < quantity) {
            return null;
        }
        product.setStock(product.getStock() - quantity);
        return accountRepo.save(new Account (new Account().hashCode(), userId, (int)bookId,  issueDate,  dueDate, fine, status));
    }

    public List<Account> getUserAccounts(int userId) {
        return accountRepo.findAllByTxnId(userId);
    }
    
    public List<Account> getAllAccounts()
    {
    	return accountRepo.findAll();
    }
}