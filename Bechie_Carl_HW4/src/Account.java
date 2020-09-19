/*
* File Name: Account.java
* Description: abstract class for accounts 
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

public abstract class Account {
	
	protected int customerID;
	protected int accountNumber;
	protected char accountType; // ‘c’ for checking, ‘m’ for mortgage
	protected double interestRate; // probably 0 for checking accounts
	protected double monthlyInterestRate; // interestRate / 12
	protected double currentMonthInterest; 
	protected double balance;
	protected LinkedList<Transaction> trasactionList = new LinkedList<Transaction>(); // List of Transaction objects 
	
	// Constructor with parameters 
	public Account(int customerID, int accountNumber, char accountType, double interestRate,
	 		        double balance) {
	    super();
		this.customerID = customerID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.interestRate = interestRate;
		this.monthlyInterestRate = interestRate / 12;
		this.balance = balance;

	}
	
	// Constructor without parameters 
	public Account() {
		super();
	}
	
	public abstract void processTransaction(Transaction transactionObject); // abstract method 


	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) { // ‘c’ for checking, ‘m’ for mortgage
		this.accountType = accountType;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate;
	}

	public void setMonthlyInterestRate(double monthlyInterestRate) {
		this.monthlyInterestRate = monthlyInterestRate;
	}

	public double getCurrentMonthInterest() {
		return currentMonthInterest;
	}

	public void setCurrentMonthInterest(double currentMonthInterest) {
		this.currentMonthInterest = currentMonthInterest;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) { // to be overridden by derived classes 
		this.balance = balance;
	}

	// Display transactions
	public  String listTransactions() { // transactionObject.toString()
			
		for(Transaction o : this.trasactionList) {
			System.out.print(o.toString());
		}
		
		return "";
	}
	
	@Override
	public String toString() { // Displays the values of the base class data members
		
		StringBuffer strBuf = new StringBuffer(); // StringBuffer object 
		
		// customerID accountNumber accountType interestRate balance 
		strBuf.append("Account data:\n");
		strBuf.append("\nAccount Number  : ");
		strBuf.append(accountNumber);
		strBuf.append("\nCustomer ID     : " );
		strBuf.append(customerID);
		strBuf.append("\nAccount Type    : ");
		strBuf.append(accountType);
		strBuf.append("\nBalance         : ");
		strBuf.append(UtilityMethods.round(balance, 2));	
		strBuf.append("\nInterest Rate   : ");
		strBuf.append(UtilityMethods.round(interestRate * 100, 3));
		strBuf.append("%");
		strBuf.append( "\n") ;	
		
		return strBuf.toString();
	}
	
	
}
