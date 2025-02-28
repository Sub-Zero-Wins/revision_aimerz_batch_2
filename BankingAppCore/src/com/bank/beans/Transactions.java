package com.bank.beans;

public class Transactions 
{
	private int accountId;
	private String type;
	private double amount;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(int accountId, String type, double amount) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	@Override
	public String toString() {
		return "Transactions [accountId=" + accountId + ", type=" + type + ", amount=" + amount + "]";
	}
	

}
