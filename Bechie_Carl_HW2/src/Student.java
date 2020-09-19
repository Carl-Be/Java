/*
*   Student: Carl Bechie
*     Class: CIS 279
*Assignment: HW2
* File Name: Student.java
*Description: This source file is the Student object
*/

public class Student {

	// Properties
	protected int studentID = 0; 
	protected String studentName = "";
	protected double testScore = 0.0;
	
	// Constructors
	public Student(int studentID, String studentName, double testScore) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.testScore = testScore;
	}
	
	public Student(){
		super();
	}
	
	// Setters and Getters 
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getTestScore() {
		return testScore;
	}

	public void setTestScore(double testScore) {
		this.testScore = testScore;
	}
	
	// Mutator 
	@Override // override toString()
	public String toString() {
		
		
		return	String.format("%-25s %-12.0f", studentName, testScore);
	}
}
