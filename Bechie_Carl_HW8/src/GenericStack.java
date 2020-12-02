/*************************************************************************
* Name of File: GenericStack.java                                        *
*                                                                        *
* Author: Carl Bechie                                                    *
*  Class: CIS 279 CNR 10853                                              *
*     HW: 8 (Page 758 Ex 19.1)                                           *
*                                                                        *
* Description:                                                           *
* Revise GenericStack class to implement it using an                     *
* array rather than an ArrayList.                                        *
*                                                                        *
* Built With:                                                            *
* JDK 8                                                                  *
*                                                                        *
* DEVELOPMENT HISTORY:                                                   * 
*                                                                        *
* Date          Author      Change Id Release     Description Of Change  * 
* -----       ---------     -----------------     ---------------------  *
* 11/5/2020   Carl Bechie        1.0              First Edit / Finish    *
*                                                                        *
*************************************************************************/


public class GenericStack<E> {
	
	private E[] list = (E[]) new Object[1]; // initializing a genric array
	private int arraySize = 0; // initializing a way to keep count of how big the array is
	
	public static void main(String[] args) {
		GenericStack<String> myStringStack = new GenericStack<>();// Declearing a GenericStack object
		
		// Places string literals into the GenericStack object 
		myStringStack.push("Apple");
		myStringStack.push("Pie");
		myStringStack.push("Is");
		myStringStack.push("Good");
		myStringStack.push("By");
		myStringStack.push("Itself");
		myStringStack.push("But");
		myStringStack.push("Better");
		myStringStack.push("With");
		myStringStack.push("Icecream");
		
		myStringStack.toString();// Display the object 
		
		// Remove string literals from the object 
		myStringStack.pop();
		myStringStack.pop();
		myStringStack.pop();
		myStringStack.pop();
		myStringStack.pop();
		myStringStack.pop();
		
		myStringStack.toString();// Display the object
		
		GenericStack<Integer> myIntStack = new GenericStack<>();// Declearing another GenericStack object
		
		for(int i = 0; i <= 10; i++) {
			myIntStack.push(i); // Filling the Integer "stack"
		}
		
		myIntStack.toString(); // Display the object 
		
		// Removing Integer objects from the GenericStack object myIntStack
		myIntStack.pop();
		myIntStack.pop();
		myIntStack.pop();
		myIntStack.pop();
		myIntStack.pop();
	
		
		myIntStack.toString();// Display the object
	}
	
	
	public int getSize() {
		return arraySize; // Retrun the size the GenericStack object 
	}
	
	public E peek() {
		return list[arraySize - 1]; // return the top object
	}
	
	public void push(E o) {
		
		if(arraySize >= list.length) { // Checks if there is enough room in the list array to add more elements 
			
			newArray();// make a new array if more room is needed
		}
		
		list[arraySize++] = o; // Use the arraySize as is then increment by 1
	}
	
	public E pop() {
		E o = list[--arraySize];// Deincrement arraySize by 1 then return its value
		return o;
	}
	
	public boolean isEmpty() {
		return arraySize == 0; // if arraySize equals zero return true else false
	};
	
	
	// Make a new array twice as big
	public void newArray() {
		
		E[] newArray= (E[]) new Object[list.length * 2]; //Holds the old elements from the list array while new list array is being made
		
		for(int i = 0; i < list.length; i++) {
			
			newArray[i] = list[i]; //Copy the old list array into the newArray
		}
		
		list = newArray; //Point the old array at the newArray starting memory location
		
	}
	
	@Override 
	public String toString() { // Display the users GenericStack object
		
		System.out.println("New Stack");
		
		for(int i = 0; i < arraySize; i++) {
			System.out.println("stack: " + list[i].toString());
		}
		
		System.out.println("");// Print and empty new line
		
		return "";
	}
}













