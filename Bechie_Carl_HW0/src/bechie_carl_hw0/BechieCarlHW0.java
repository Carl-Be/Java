/*
   Student: Carl Bechie
     Class: CIS 279
Assignment: HW0
 File Name: BechieCarlHW0.java
Decription: This is a Monthly Deposits Plus Interest I/O program. 
*/
package bechie_carl_hw0;

import java.util.Locale;
import java.util.Scanner;


public class BechieCarlHW0 {

    public static void main(String[] args) {
                //initiulazing constant to aviod hard coded values
      		final int DIVISOR_FOR_MONTHLY_RATE = 100;//divisor for monthly interest rate
                    //Header message for the display 
                final String HEADER = " ____________________________________________________________________________________________________________________ \n" +   
                                      "|                                    Number of                                     Compound                          |\n" +
                                      "|  Month                             Months of                Monthly               Monthly              End         |\n" +
                                      "|  Count         Deposit          Intrest Accured          Interest Rate             Rate              Balance       |\n" +
                                      "|====================================================================================================================|  " ;
             
                //Test Header
                //System.out.println(HEADER);
                
                //defining initalized named data item here  
                double sumOfDepositsMade = 0.0;//this well hold the total deposits amount over the accrued months 
                int monthCount = 1;//the month count starts at 1 and works its way up to user input numMonths
                double monthlyCompoundInterestRate = 0.0;//holds the calulation value for the monthly compound interest rate
                double endBalance = 0.0;// holds the end balance for every month 
                double endOfYearTotal = 0.0;//holds the end of year total 
                // Input from user
		Scanner scan = new Scanner(System.in);//scanner object named scan 
		
		// Number of months
		System.out.print("Enter the number of months: " );//ask for input 
		int numMonth = scan.nextInt();//take user input as a int 
		 
		// Periodic deposit
                System.out.print("Enter the deposit amount: ");//ask for input 
		double depositAmount = scan.nextDouble(); //take user input as a double
                
		// Annual interest
		System.out.print("Enter annual interest rate: ");//ask for input
                double annualInterestRate = scan.nextDouble();//take user input as double 
                
                //Calculations done out side of loop to avoid useless cpu usage 
                double monthlyInterestRate = (annualInterestRate / DIVISOR_FOR_MONTHLY_RATE / numMonth) + 1;//calculation for monthly interest rate
                sumOfDepositsMade = numMonth * depositAmount;//accumalating the total sum of deposits made 
                
                // Print the header here before loop
                System.out.println(HEADER);
                                
		// Perform a loop compounds the interest
		for(int i = numMonth; i > 0; i--)//start at the top months and work down to 1 
                {
                    //Calculations here 
                    monthlyCompoundInterestRate = Math.pow(monthlyInterestRate,i);//calculating the monthly compound interest rate
                    endBalance = monthlyCompoundInterestRate * depositAmount;//calculating the monthly end balance 
                    endOfYearTotal += endBalance;//accumalate the total end of year amount 
                    //String.format() for display 
                    //The string formatter 
                    String output = String.format(Locale.US,"  %-6s%-9d%-23.2f%-22d%-21.4f%-20.6f%.4f","Month",monthCount, depositAmount, i, monthlyInterestRate, monthlyCompoundInterestRate, endBalance);
                    System.out.println(output);//output the string 
                    
                    //increment monthCount
                    monthCount ++; //incrementing month count by one every itteration 
                }
                
		// Show sum of deposit
                String outputSumDeposit = String.format("\nSum of deposits: %.2f", sumOfDepositsMade);//formatter for the output
                System.out.println(outputSumDeposit);//sum deposited output 
                
                //Show end of year total 
                String outputEndYearTotal = String.format("End-of-Year total: %.2f", endOfYearTotal);//formatter for the output
                System.out.println(outputEndYearTotal);//end of year total output 
                
		scan.close(); // close the scanner object scan
    }
    
}
