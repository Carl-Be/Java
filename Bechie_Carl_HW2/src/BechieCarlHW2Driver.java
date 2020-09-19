/*
*   Student: Carl Bechie
*     Class: CIS 279
*Assignment: HW2
* File Name: StudentDriver.java
*Description: This program take Student data from an input file and processes it. 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BechieCarlHW2Driver{

	public static void main(String[] args){
	
		File file = new File("HW1_Students.txt"); // Make file object 
		ArrayList<Student> students = new ArrayList<>(); // new ArrayList object
		
		try { try ( // try to open the file

            	Scanner scanner = new Scanner(file) // create a scanner object that reads the file
                  ) {
					readFile(scanner, students);
            		scanner.close();  // close scanner
                  }
		} catch (FileNotFoundException e) { // catch exception

			System.out.println("File Not Found"); // handle the exception 
		}
		
		
		// using recussion to get averageScore	
		double averageScore = 0.0;
		averageScore = averageScore(students, students.size(), averageScore);
	
		// Calculate the standard deviation using the sample standard deviation formula
		double sampleStandardDeviation = calculateStandardDeviation(averageScore, students);
		
		
		System.out.printf("Group average: %.1f%6sStandard deviation: %.5f\n\n", averageScore, " ",sampleStandardDeviation);


		// make a contstant string for the header of the display 
		final String HEADER = "                                      Relative to       Letter\n" +
				              "Student                   Score        Average           Grade\n";
		// Display Results 
		System.out.println(HEADER);
		displayTable(students, averageScore);

	}
	
	
	// display the table
	private static void displayTable(ArrayList<Student> students, double averageScore){
		
		// display the student status 
		for(Student student1 : students) {
			 
			 String letterGrade = calculateTensPlace(student1.getTestScore()); // gets the letter grade 
			 String relativeToAverage = relativeToAverage(averageScore, student1.getTestScore()); // gets the relative to average
			 System.out.print(student1);
			 System.out.printf("%-20s %s\n\n",  relativeToAverage, letterGrade);
		}
	}
	

	// calculate the standard deviation                                                                          
	private static double calculateStandardDeviation(double averageScore, ArrayList<Student> students){          
	
		double sumOfXMinusAverageSquared = sumOfXMinusAverageSquared(students, averageScore);              
		double toBeSquaredRooted = divideByNMinusOne(students.size() - 1, sumOfXMinusAverageSquared);      
		return standardDeviationProduct(toBeSquaredRooted);                                                  
	
	}            												     

	// this square roots the to get the standard deviation product   					     
	private static double standardDeviationProduct(double toBeSquaredRooted){ 				     
	
		return Math.sqrt(toBeSquaredRooted); // returns the standard deviation  	    		     
	}  													     
	
	// Divide by size-1 											     
	private static double divideByNMinusOne(double divisor, double sumOfXMinusAverageSquared){ 		     
	
		return sumOfXMinusAverageSquared / divisor; // returns what is to be sqrt      		     
	} 													     
	
	// Gets the first portion of the formula calculated 							   
	private static double sumOfXMinusAverageSquared(ArrayList<Student> students, double averageScore){ 	     
	
		double sum = 0.0; // local var to hold the sumnation 						     
	
		// for each loop to calculate the summing 							     
		for (Student student : students) { 								     
			sum += Math.pow((student.getTestScore() - averageScore), 2); // sum the values 			     
		}												     
	
		return sum;  											     
	} 													     
	
	// calculate averageScores recurrsively 								     
	private static double averageScore(ArrayList<Student> students, int count,double averageScore){ 	     
	
		count --; // deincrement count by one 								     
		
		if(count > -1){ 	
			
			Student student = students.get(count); // get the current student
			averageScore += student.getTestScore(); // sum the values to be divided 			     
			return 	averageScore(students, count, averageScore); // the recurssion 		
			
		}                                    								     
	
		return averageScore / students.size(); // return average score                                     
	}                                                                                                              
	
	
	// this retuns the 10s place on a test score so it can be used to find the letter grade 
	private static String calculateTensPlace(double testScore){
		
		// we only want to compare the tens place of the numric value
		testScore /= 10; // divide testScore by 10  
		return getLetterGrade((int)Math.floor(testScore)); // gets rid of the decimal place while keeping the 10s place value accurate 
	}
	
	// gets the letter grade for the score 
	private static String getLetterGrade(int tensPlace){
	
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
	private static String relativeToAverage(double averageScore, double testScore){
		
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
	
	
	// This methods adds students to an ArrayList
	private static void readFile(Scanner scanner, ArrayList<Student> students){ 
		
		while(scanner.hasNextLine()){ // keep reading file until end of file 
			
			Student student = new Student(); // Make student object
			
			student.setStudentID(Integer.parseInt(scanner.nextLine())); // set student ID
			student.setStudentName(scanner.nextLine()); // set student name
			student.setTestScore(Double.parseDouble(scanner.nextLine())); // set student test score 
			
			students.add(student); // add student object to ArrayList
		}
	}

}
