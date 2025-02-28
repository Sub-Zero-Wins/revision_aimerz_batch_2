package com.bank.beans;

public class Account 
{
	private int id;
	private String name;
	private double balance;
	private boolean isActive;
	
	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.isActive = isActive;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", isActive=" + isActive + "]";
	}
	
	
	

}
