/*
* File Name: Mortage.java
* Description: Mortgage account class
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

public class Mortgage extends Account {

	private int termInYears;
	private int termInMonths;
	private double periodicPayment; 
	private double balanceRepaid;
	
	//	Mortgage = new Mortgage( customerID, accountNumber, accountType, interestRate, balance, term);
	public Mortgage(int customerID, int accountNumber, char accountType, double interestRate, double balance, int term) {
		super(customerID, accountNumber, accountType, interestRate, balance);
		this.termInMonths = term;
	}
	
	public Mortgage() {
		super();
		
	}
	
	@Override
	public void processTransaction(Transaction transactionObject) {

		trasactionList.addLast(transactionObject); // Add a transaction to the list.
		// Calculate interest the amount repaid and change the account balance.
		if ( transactionObject.getTransactionType() == 'P')
		{
			setCurrentMonthInterest( balance * monthlyInterestRate );
			setBalanceRepaid( transactionObject.getTransactionAmount() - currentMonthInterest) ;
			setBalance( balance - this.balanceRepaid );
		}
		// To simplify this, we avoided dealing with an invalid transaction type.

	}
	
	public void setTerm(int term) {
		this.termInMonths = term;
		this.termInYears = term;
	}
	
	public int getTerm() {
		
		return termInMonths;
	}
	
	public double getCurrentMonthInterest() {
		
		return super.getCurrentMonthInterest();
	}

	
	public void setCurrentMonthInterest(double currentMonthInterest) {
		
		super.setCurrentMonthInterest(currentMonthInterest);
	}

	public double getBalanceRepaid() {
		return balanceRepaid;
	}

	public void setBalanceRepaid(double balanceRepid) {
		this.balanceRepaid = balanceRepid;
	}
	
	public double calcPeriodicPayment (){
		double annuityFactor = (( 1 - ( 1 / Math.pow((1 + monthlyInterestRate ), termInMonths))) / monthlyInterestRate);
		return balance / annuityFactor;
	}
	

	@Override
	public String toString() {
		
		StringBuffer strBuf = new StringBuffer(super.toString()); // StringBuffer object 
	
		strBuf.append("Term            : ");
		strBuf.append(termInMonths);	
		strBuf.append("\nPeriodic payment: ");
		strBuf.append(trasactionList.getLast().getTransactionAmount());
		strBuf.append( "\n") ;
		
		return strBuf.toString();
	}
	
	
}
