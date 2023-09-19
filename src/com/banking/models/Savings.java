package com.banking.models;

public class Savings extends Account {
	
	private Account _account;
	
	public Account GetAccount() {
		return _account;
	}
	public void SetAccount(Account _account) {
		this._account = _account;
	}

	public double interestRate = 0.12;
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// METHODS
	public double CalculateInterestByMonths(int months)
	{
	    double interest = getBalance() * (interestRate / 12) * months;
	    Deposit(interest);
	    return interest;
	    
	}

	// call the base constructor
	public Savings()
	{
	    _account = new Account();
	}
}
