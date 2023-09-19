package com.banking.models;

import java.time.LocalDate;

public class Account {
	// PROPERTIES
	private static String _routingNumber;
	public String getRoutingNumber() {
		return _routingNumber;
	}
	public void setRoutingNumber(String address) {
		Account._routingNumber = address;
	}
	
	private int _nextAccountNo = 1;
	public int getNextAccountNo() {
		return _nextAccountNo;
	}
	public void setNextAccountNo(int nextAccountNo) {
		this._nextAccountNo = nextAccountNo;
	}
	
	private int _accountNo;
	public int getAccountNo() {
		return _accountNo;
	}
	public void setAccountNo(int accountNo) {
		this._accountNo = accountNo;
	}
	
	private double _balance = 0;
	public double getBalance() {
		return _balance;
	}
	public void setBalance(int balance) {
		this._balance = balance;
	}
	
	private String _description = "";
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		this._description = description;
	}
	
	private LocalDate _dateCreated = java.time.LocalDate.now();
	public LocalDate getDateCreated() {return _dateCreated;}
	public void setDateCreated(LocalDate dateCreated) {this._dateCreated = dateCreated;}
	
	
	// METHODS
	public String TimeStamp() {
		String timeStamp = java.time.LocalDate.now().toString();
		return timeStamp;
	}
	
	public boolean Deposit(double amount) {
		if(!AmountIsPositive(amount)) return false;
		_balance += amount;
		String newTimeStamp = TimeStamp();
		System.out.println(newTimeStamp);
		System.out.println("Deposit successfull");
		return true;
	}
	
	public boolean Withdraw(double amount) throws Exception {
		if(!AmountIsPositive(amount)) return false;
		if(_balance < amount) {
			throw new Exception("Insufficient Funds!");
		}
		_balance -= amount;
		System.out.println("Withdraw successful!");
		return true;
	}
	
	public void Transfer(double amount, Account toAccount) {
		try {
			if(this.Withdraw(amount)) {
				toAccount.Deposit(amount);
				System.out.println("Transfer Successful!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Transfer Failed!");
	}
	
	private boolean AmountIsPositive(double amount) {
		if(amount > 0) {
			return true;
		}
		System.out.println("Amount must be greater than $0.00!");
		return false;
	}
	
	public void Print() {
		System.out.printf("AccountNo: %d", _accountNo);
		System.out.printf("Description: %s", _description);
		System.out.printf("Balance: %d", _balance);
	}
	
	public Account() {
		this._accountNo += _nextAccountNo++; 
	}
	
}
