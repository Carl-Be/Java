/*
* File Name: CreditCardAccount.java  
* Description: Credit Card Account attributes and methods 
* 
*   Student: Carl Bechie
*     Class: CIS 279
*Assignment: HW3 
*
* Created: 9/13/2020
* Updated: 9/13/2020
* Version: 1
* 
* Build: Eclipes IDE
*   Run: Eclipes IDE 
*/

public class CreditCardAccount {

	// Declear private class vars 
	private int accountNumber; 
	private double beginningBalance;
	private double endingBalance;
	private double creditLimit;
	private double interestRate;
	private Customer customer;
	
	// Create Class construstor 
	public CreditCardAccount(int accountNumber, double beginningBalance, double endingBalance, double creditLimit,
							double interestRate, int customerID, String lastName, String firstName, int creditScore) {
		super();
		this.accountNumber = accountNumber;
		this.beginningBalance = beginningBalance;
		this.endingBalance = endingBalance;
		this.creditLimit = creditLimit;
		this.interestRate = interestRate;
		this.customer = new Customer(customerID, lastName, firstName, creditScore);
	}
	
	
	// Create Empty Class construstor
	public CreditCardAccount() {
		super();
	}


	//Begin Class Setters and Getters
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBeginningBalance() {
		return beginningBalance;
	}

	public void setBeginningBalance(double beginningBalance) {
		this.beginningBalance = beginningBalance;
	}

	public double getEndingBalance() {
		return endingBalance;
	}

	public void setEndingBalance(double endingBalance) {
		this.endingBalance = endingBalance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	// Start Setters and Getters for customer attribute 
	public int getCustomerID() {
		return customer.getCustomerID();
	}

	public void setCustomerID(int customerID) {
		this.customer.setCustomerID(customerID);
	}

	public String getLastName() {
		return customer.getLastName();
	}

	public void setLastName(String lastName) {
		this.customer.setLastName(lastName);
	}

	public String getFirstName() {
		return customer.getFirstName();
	}

	public void setFirstName(String firstName) {
		this.customer.setFirstName(firstName);
	}

	public int getCreditScore() {
		return customer.getCreditScore();
	}

	public void setCreditScore(int creditScore) {
		this.customer.setCreditScore(creditScore);
	}
	// EndSetters and Getters for customer attribute 
	//End Class Seters and Getters 

	// Class calculations 
	
	// finds out the accounts status 
	//It will display an Account Status whose values are OK if the ending balance is lower than the credit limit and OVER if it exceeds the credit limit.
	private String accountStatus() {
		
		String accountStatus = ""; // var to hold calculation result 
		
		double checkStatus = this.creditLimit - this.endingBalance; // the calculation 
 
		// selection statments to select proper account status 
		if(checkStatus >= 0) {
			accountStatus = "OK";
		}else if(checkStatus < 0) {
			accountStatus = "OVER";
		}
		
		return accountStatus; // return the account status  
	}
	
	// retruns a penalty fee if the Account Status is OVER, calculate a penalty amount as 5% of the ending balance.
	private double penaltyFee(){
		
		final double PENALTY_FEE_RATE = 0.05; // 5% 
		
		// no penalty fee 
		if(accountStatus().equals("OK")) {
			return 0.0;
		}
		
		// return penalty fee
		return this.endingBalance * PENALTY_FEE_RATE;
	}
	
	// calculate the average of the beginning and ending balances.
	private double averageBalance() {
		
		return (this.beginningBalance + this.endingBalance) / 2.0;
	}
	
	// CreditCardAccount Class toString() method 
	@Override
	public String toString() {
		// formatted String return
		return  String.format("%-13d%-13d%-14s%-17s%-11d%-12.2f%-14.2f%-14s%-12.2f%-17.2f%.0f%s",getAccountNumber(), getCustomerID(), getLastName(), getFirstName(), 
															                                     getCreditScore(), getCreditLimit(), getEndingBalance(), accountStatus(),
															                                     penaltyFee(), averageBalance(), getInterestRate() * 100.00,"%");  
	}
	
}
