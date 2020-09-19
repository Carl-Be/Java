/*
*   Student: Carl Bechie
*     Class: CIS 279
*Assignment: HW1
* File Name: BechieCarlHW1.java
*Decription: This program takes Student data from an input file and processes it. 
*/

package bechie_carl_hw1;

import java.io.File; // import file object type 
import java.io.FileNotFoundException; // import exception for try catch
import java.util.ArrayList; // import arrarylist to hold file inputs 
import java.util.Scanner; // import scanner to read file 
import java.lang.Math; // import the math lib 

public class BechieCarlHW1 {

	public static void main(String[] args) {
		
 	 	ArrayList<Integer> studentIDs = new ArrayList<>(); // create arrarylist to hold student IDs
		ArrayList<String> studentNames = new ArrayList<>(); // create arrarylist to hold student names
		ArrayList<Double> testScores = new ArrayList<>(); // create arrarylist to hold test scores 
		
		File file = new File("HW1_Students.txt");
		
		try { try ( // try to open the file

                	Scanner scanner = new Scanner(file) // create a scanner object that reads the file
                      ) {
				readFile(scanner, studentIDs, studentNames, testScores);
                		scanner.close();  // close scanner
                      }

		} catch (FileNotFoundException e) { // catch exception

			System.out.println("File Not Found");
		}
	
		// using recussion to get averageScore	
		double averageScore = 0.0;
		averageScore = averageScore(testScores,testScores.size(), averageScore);
	
		// Calculate the standard deviation using the sample standard deviation formula
		double sampleStandardDeviation = calculateStandardDeviation(averageScore, testScores);
		
		
		System.out.printf("Group average: %.1f%6sStandard deviation: %.5f\n\n", averageScore, " ",sampleStandardDeviation);


		// make a contstant string for the header of the display 
		String HEADER = "                                      Relative to       Letter\n" +
				"Student                  Score        Average           Grade\n";

		displayTable(HEADER, averageScore, studentNames, testScores);

}
	// Display the information 
	public static void displayTable(String HEADER, double averageScore, ArrayList<String> studentNames, ArrayList<Double> testScores){

		System.out.println(HEADER); // display the header 

		// displayTable 	
		for(int i = 0 ; i <= studentNames.size() -1; i++){
			
			String letterGrade = calculateTensPlace(testScores.get(i)); // gets the letter grade 
			String relativeToAverage = relativeToAverage(averageScore, testScores.get(i)); // gets the relative to average
			System.out.printf("%-24s %-12.0f %-20s %s\n\n", studentNames.get(i), testScores.get(i), relativeToAverage, letterGrade);// display table formatted 
		}	
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                  This block of methods get the standard Deviation 						     //
// 			                                                                                             //
	                                                                                                             //	
	// calculate the standard deviation                                                                          //
        public static double calculateStandardDeviation(double averageScore, ArrayList<Double> testScores){          //
			                   	                                                                     //
		double sumOfXMinusAverageSquared = sumOfXMinusAverageSquared(testScores, averageScore);              //
		double toBeSquaredRooted = divideByNMinusOne(testScores.size() - 1, sumOfXMinusAverageSquared);      //
		return standardDeviationProduct(toBeSquaredRooted);                                                  //
	 													     //
	}            												     //
		 											             //
	              												     //
	// this square roots the to get the standard deviation product   					     //
	public static double standardDeviationProduct(double toBeSquaredRooted){ 				     //
 													       	     //
		return Math.sqrt(toBeSquaredRooted); // returns the standard deviation  	    		     //
	}  													     //
 												 	 	     //
	// Divide by size-1 											     //
	public static double divideByNMinusOne(double divisor, double sumOfXMinusAverageSquared){ 		     //
														     //
			return sumOfXMinusAverageSquared / divisor; // returns what is to be sqrt      		     //
	} 													     //
														     //
	// Gets the first portion of the formula calculated 							     //
	public static double sumOfXMinusAverageSquared(ArrayList<Double> testScores, double averageScore){ 	     //
														     //
		double sum = 0.0; // local var to hold the sumnation 						     //
														     //
		// for each loop to calculate the summing 							     //
		for (double testScore : testScores) { 								     //
			sum += Math.pow((testScore - averageScore), 2); // sum the values 			     //
		}												     //
														     //
		return sum;  											     //
	} 													     //	
														     //
														     //
	// calculate averageScores recurrsively 								     //
	public static double averageScore(ArrayList<Double> testScores, int count,double averageScore){ 	     //
														     //
		count --; // deincrement count by one 								     //
														     //
		if(count > -1){ 										     //
														     //
			averageScore += testScores.get(count); // sum the values to be divided 			     //
			return 	averageScore(testScores, count, averageScore); // the recurssion 		     //
		}                                    								     //
		                                                                                                     //
		return averageScore / testScores.size(); // return average score                                     //
	}                                                                                                            //  
//                                                                                                                   //
//               End Sample Stanard Deviation calulation                                                             //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// this retuns the 10s place on a test score so it can be used to find the letter grade 
	public static String calculateTensPlace(double testScore){

		// we only want to compare the tens place of the numric value
		testScore /= 10; // divide testScore by 10  
		return getLetterGrade((int)Math.floor(testScore)); // gets rid of the decimal place while keeping the 10s place value accurate 
	}

	// gets the letter grade for the score 
	public static String getLetterGrade(int tensPlace){
		
		// return the correct letter grade 
		switch(tensPlace){
		
			case 10: return "A";// == 100  
			case 9:  return "A";// >= 90  
			case 8:  return "B";// >= 80 and < 90
			case 7:  return "C";// >= 70 and < 80
			case 6:  return "D";// >= 60 and < 70
			default: return "F";//  < 60 

		}

	}
	
	// finds out if a score is <, >, or == to averageScore and returns the result 
	public static String relativeToAverage(double averageScore, double testScore){
	
		if(testScore < averageScore){
			return "< Average";
		}
		else if(testScore > averageScore){
			return "> Average"; 
		}
		else if(testScore == averageScore){
			return "= Average"; 
		}

		return "";
	}

	// this method contols indexing each list item in paralle
	public static void readFile(Scanner scanner,ArrayList<Integer> studentIDs, ArrayList<String> studentNames, ArrayList<Double> testScores){ 
		
		while(scanner.hasNextLine()){ // keep reading file until end of file 
			indexStudentID(studentIDs, scanner); // pass objects by reference to add to designated arrarylist.
			indexStudentName(studentNames, scanner); // pass objects by reference to add to designated arrarylist.
			indexTestScore(testScores, scanner); // pass objects by reference to add to designated arrarylist.
		}
	}

	// places the student ID inside the student ID arrarylist 
	public static void indexStudentID(ArrayList<Integer> studentIDs, Scanner scanner) {
	
		String studentIDStr = scanner.nextLine(); // read in student ID number 
		int studentID = Integer.parseInt(studentIDStr); // convert the string to a int
		studentIDs.add(studentID); // append the studentID to the list 
	}

	// places the student name inside the student name arrarylist
	public static void indexStudentName(ArrayList<String> studentNames, Scanner scanner){
		
		String studentNameStr = scanner.nextLine(); // read in student name 
		studentNames.add(studentNameStr); // append the student name to the list 
	}

	// places the test score inside the test score arrarylist
	public static void indexTestScore(ArrayList<Double> testScores, Scanner scanner) {

		String testScoreStr = scanner.nextLine(); // read in test score 
		double testScore = Double.parseDouble(testScoreStr); // convert the string to a double
		testScores.add(testScore); // append the test score to the list 
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////TESTING BLOCK////////////////////////////////////////////////////////////////
	
	public static void test(ArrayList<Double> testScores, ArrayList<String> studentNames, ArrayList<Integer> studentIDs){

		System.out.println("\n");
		
                studentIDs.forEach((id) -> {
                    System.out.println(Integer.toString(id));
            });


		System.out.println("\n");

                studentNames.forEach((name) -> {
                    System.out.println(name);
            });

		System.out.println("\n");
		
                testScores.stream().map((double1) -> Double.toString(double1)).forEachOrdered((str) -> {
                    System.out.println(str);
            });
	}
//////////////////////////END TEST BLOCK///////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
	

}	











