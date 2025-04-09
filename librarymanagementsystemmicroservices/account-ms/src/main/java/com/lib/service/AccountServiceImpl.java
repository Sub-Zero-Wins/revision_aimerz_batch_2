package com.lib.service;

import java.util.List;

import com.lib.beans.Account;
import com.lib.beans.IssueStatus;

public class AccountServiceImpl implements AccountService
{

	@Override
	public boolean placeAccount(int userId, long bookId, String issueDate, String dueDate, double fine,
			IssueStatus status, int quantity) {
		
		return false;
	}

	@Override
	public List<Account> getUserAccounts(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

}
