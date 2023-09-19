package com.banking.models;

public class Checking extends Account{
	
	private Account _account;
	
	public Account GetAccount() {
		return _account;
	}
	public void SetAccount(Account account) {
		this._account = account;
	}
	
	private static int _nextCheckNo = 100;
	public int getNextCheckNo() {
		return _nextCheckNo;
	}
	public void setNextCheckNo(int nextCheckNo) {
		Checking._nextCheckNo = nextCheckNo;
		}
	
	public boolean writeCheck(double amount) throws Exception {
		try {
		if(!Withdraw(amount)) {return false;}
		
        int checkNo = _nextCheckNo++;
        String newTimeStamp = _account.TimeStamp();
        System.out.println(newTimeStamp);
        System.out.printf("Check no: %d for %f", checkNo, amount);
        System.out.println();
        return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void Transfer(double amount, Checking checking) throws Exception {

	    if(this.Withdraw(amount))
	    {
	        checking.Deposit(amount);
	        String newTimeStamp = _account.TimeStamp();
	        System.out.println(newTimeStamp);
	        System.out.println("Transfer successful");
	        return;
	    }
	}
	
	public void Print()
	{
	    _account.Print();
	}

	// CALL BASE CONSTRUCTOR
	public Checking()
	{
	    _account = new Account();
	}
	
}
