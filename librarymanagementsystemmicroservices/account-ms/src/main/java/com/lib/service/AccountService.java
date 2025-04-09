package com.lib.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lib.beans.Account;
import com.lib.beans.IssueStatus;

@Service
public interface AccountService 
{
	public boolean placeAccount(int userId, long bookId, String issueDate, String dueDate, double fine,
			IssueStatus status,int quantity) ;

	public List<Account> getUserAccounts(int userId);

	public List<Account> getAllAccounts();

}
