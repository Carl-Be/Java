/*
* File Name: BechieCarlHW3Driver.java  
* Description: This program summarizes a customers credit card account 
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

// import required  libs 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BechieCarlHW3Driver {
	
	public static void main(String[] args){
		File file = new File("HW3_Accounts.txt"); // Make file object 
		
		// Create Header for output
		final String HEADER = "Account                                                 Credit      Credit      Ending       Account      Penalty       Average       Interest\n" +
						      "Number     Customer ID    Last Name     First Name      Score       Limit       Balance      Status         Fee         Balance         Rate\n";
		
		System.out.println(HEADER); // display header 
		
		try { try ( // try to open the file

            	Scanner scanner = new Scanner(file) // create a scanner object that reads the file
                  ) {
					readFile(scanner); // read the file 
            		scanner.close();  // close scanner
                  }
		} catch (FileNotFoundException e) { // catch exception

			System.out.println("File Not Found"); // handle the exception 
		}
		
	}
	
	// This method reads the file 
	private static void readFile(Scanner scanner){ 
		
		while(scanner.hasNextLine()){ // keep reading file until end of file 
			
			// initialize  vars to take in file input 
			int accountNumber = Integer.parseInt(scanner.nextLine());
			double beginningBalance = Double.parseDouble(scanner.nextLine());
			double endingBalance = Double.parseDouble(scanner.nextLine());
			double creditLimit = Double.parseDouble(scanner.nextLine());
			double interestRate = Double.parseDouble(scanner.nextLine());
			int customerID = Integer.parseInt(scanner.nextLine());
			String lastName = scanner.nextLine();
			String firstName = scanner.nextLine();
			int creditScore = Integer.parseInt(scanner.nextLine());
			
			// initialize CreditCardAccountObject 
			CreditCardAccount account = new CreditCardAccount(accountNumber, beginningBalance, endingBalance, creditLimit,
                                                              interestRate, customerID, lastName, firstName, creditScore);
			// Print display 
			System.out.println(account.toString() + "\n");
		}
	}
}
