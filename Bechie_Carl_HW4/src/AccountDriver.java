/*
* File Name: Mortage.java
* Description: Bechie Carl HW4 Driver class
* 
*   Student: Carl Bechie
*     Class: CIS 279
*Assignment: HW4
*
* Created: 9/19/2020
* Updated: 9/19/2020
* Version: 1
* 
* Build: Eclipse IDE
*   Run: Eclipse IDE 
*/
import java.util.LinkedList;

public class AccountDriver
{
	public static void main(String[] args)
	{
		final char PAYMENT_TYPE = 'P' ;
		final char CHECK_TYPE   = 'C' ;
		final char DEPOSIT_TYPE = 'D' ;

		// Here we declare and instantiate an empty LinkedList of the base class.

		LinkedList<Account> accountList = new LinkedList<Account>();

		// Mortgage = new Mortgage( customerID, accountNumber, accountType, interestRate, balance, term);
		Mortgage mortgageOne = new Mortgage( 1000, 10000, 'M', 0.06875, 95000, 15);
		
		// Transaction(int transactionID, int transactionDate, double amount , char type)
    	mortgageOne.processTransaction( new Transaction(5001, 20200919, 847.26, PAYMENT_TYPE));
    	mortgageOne.processTransaction( new Transaction(5002, 20201019, 847.26, PAYMENT_TYPE));
    	mortgageOne.processTransaction( new Transaction(5003, 20201119, 847.26, PAYMENT_TYPE));
    	mortgageOne.processTransaction( new Transaction(5004, 20201219, 847.26, PAYMENT_TYPE));

		accountList.addLast( mortgageOne ) ;
		
		//int customerID, int accountNumber, char accountType, double interestRate, double balance
		CheckingAccount checkingOne = new CheckingAccount(1001, 10001, 'C', 0, 20000);
		
		// Transaction(int transactionID, int transactionDate, double amount , char type)
		checkingOne.processTransaction( new Transaction(6001, 20200919, 1000.25, DEPOSIT_TYPE));
		checkingOne.processTransaction( new Transaction(6002, 20200920, 2000.84, CHECK_TYPE));
		checkingOne.processTransaction( new Transaction(6003, 20200921, 500.35, DEPOSIT_TYPE));
		checkingOne.processTransaction( new Transaction(6004, 20200922, 10000.15, CHECK_TYPE));

		accountList.addLast( checkingOne ) ;
		
		// Mortgage = new Mortgage( customerID, accountNumber, accountType, interestRate, balance, term);
		Mortgage mortgageTwo = new Mortgage( 1002, 10002, 'M', 0.0275, 200000, 30);
		
		// Transaction(int transactionID, int transactionDate, double amount , char type)
		mortgageTwo.processTransaction( new Transaction(7001, 20200919, 1000.33, PAYMENT_TYPE));
		mortgageTwo.processTransaction( new Transaction(7002, 20201019, 1000.33, PAYMENT_TYPE));
		mortgageTwo.processTransaction( new Transaction(7003, 20201119, 1000.33, PAYMENT_TYPE));
		mortgageTwo.processTransaction( new Transaction(7004, 20201219, 1000.33, PAYMENT_TYPE));

		accountList.addLast( mortgageTwo ) ;
		
		//int customerID, int accountNumber, char accountType, double interestRate, double balance
		CheckingAccount checkingTwo = new CheckingAccount(1003, 10003, 'C', 0, 60000);
		
		// Transaction(int transactionID, int transactionDate, double amount , char type)
		checkingTwo.processTransaction( new Transaction(8001, 20200919, 800.51, DEPOSIT_TYPE));
		checkingTwo.processTransaction( new Transaction(8002, 20200920, 5135.15, CHECK_TYPE));
		checkingTwo.processTransaction( new Transaction(8003, 20200921, 900.97, DEPOSIT_TYPE));
		checkingTwo.processTransaction( new Transaction(8004, 20200922, 29871.15, CHECK_TYPE));

		accountList.addLast( checkingTwo ) ;
		
		// Output the objects 
		for ( Account accountObj : accountList )
		{
			System.out.println(accountObj.toString() + "\n") ;
			System.out.println(accountObj.listTransactions()) ;
			System.out.println("\nThe current account balance is " + UtilityMethods.round(accountObj.getBalance(),2) + ".\n\n");
		}
	}
}
