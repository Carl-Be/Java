/*
* File Name: CheckingAccount.java
* Description: Checking Account class 
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

public	class CheckingAccount extends Account {
	
	public CheckingAccount(int customerID, int accountNumber, char accountType, double interestRate, double balance) {
		super(customerID, accountNumber, accountType, interestRate, balance);
	}
	

	public CheckingAccount() {
		super();
	}

	// This method will add deposits to the CheckingAccount balance,
	// subtract checks from the balance,
	// add the transaction object to a LinkedList of Transactions.
	@Override
	public void processTransaction(Transaction transactionObject) {
		
		trasactionList.addLast(transactionObject);
		
		if ( transactionObject.getTransactionType() == 'C'){
			
			balance -= transactionObject.getTransactionAmount(); 
			
		}
		
		else if ( transactionObject.getTransactionType() == 'D'){
			
			balance += transactionObject.getTransactionAmount(); 
		}
	}
	
}
