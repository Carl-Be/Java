/*
* File Name: Customer.java  
* Description: Customer attributes and methods
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

public class Customer {
	
	// Declear private class vars 
	private int customerID;
	private String lastName; 
	private String firstName;
	private int creditScore;
	
	// Create Class construstor 
	public Customer(int customerID, String lastName, String firstName, int creditScore) {
		super();
		this.customerID = customerID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.creditScore = creditScore;
	}

	// Create Empty Class construstor
	public Customer() {
		super();
	}

	//Begin Class Setters and Getters
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	//End Class Seters and Getters 
	
}
