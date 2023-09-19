package com.banking;

import com.banking.models.*;

public class Program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		var chk1 = new Checking();
		var chk2 = new Checking();
		var sav1 = new Savings();   

		chk1.setDescription("Checking Account");
		chk1.Deposit(3000);
		System.out.println(chk1.getBalance());
		chk1.Withdraw(50);
		chk1.writeCheck(25);
		chk1.Transfer(100, chk2);
		chk1.Withdraw(500);

		chk2.setDescription("Slush Fund");

		sav1.setDescription("Savings Account");
		sav1.Deposit(400);
		System.out.println(sav1.getBalance());
		sav1.Withdraw(50);


		//chk1.Print();
		//chk2.Print();
		//sav1.Print();
	}

}
