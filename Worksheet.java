/* 
 * Programmer: Shreya Mantripragada
 * Date: January 30, 2018
 * Worksheet.java
 * Purpose: To create an elementary school work sheet by creating two arrays with values and adding or subtracting the corresponding subscripts together.
 * 			 Also randomly generate the plus and minus signs.
 * 
 *  Testing Plan: 
 				*  Input: Please enter the maximum value for your work sheet: 33  --> Output:  						
 				   	  	  Please enter the minimum value for your work sheet: 12
 				  																									                        Name: _______________
                             																                        Date:_______________

																					                                    1. 19+22= 	2. 23-15= 	3. 23+27= 	4. 26+12= 	
																					                                    5. 17+31= 	6. 14+32= 	7. 30+18= 	8. 33-21= 	
																					                                    9. 15+28= 	10. 16+26= 	11. 24-33= 	12. 15-22= 	
																					                                    13. 27+16= 	14. 30-17= 	15. 31-13= 	16. 18-19= 	
																					                                    17. 32+32= 	18. 21-32= 	19. 30-21= 	20. 20-32= 	
                                                                                  
																				                                     	Answers: 

																					                                    0. 41 		1. 8 		2. 50 		3. 38 		
																					                                    4. 48 		5. 46 		6. 48 		7. 12 		
																					                                    8. 43 		9. 42 		10. -9 		11. -7 		
																					                                    12. 43 		13. 13 		14. 18 		15. -1 		
																				                                    	16. 64 		17. -11 	18. 9 		19. -12 
 																				
 				* Input: Please enter the maximum value for your worksheet: 56  --> Output: 
                 Please enter the minimum value for your worksheet: 41                                                                  Name: _______________
                             																							          Date:_______________

																					                              1. 53+48= 	2. 49-53= 	3. 42+42= 	4. 51+53= 	
																					                              5. 41+47= 	6. 44-52= 	7. 56-50= 	8. 48+55= 	
																					                              9. 56-51= 	10. 42-55= 	11. 49+52= 	12. 45+48= 	
																					                              13. 48+46= 	14. 50+56= 	15. 53+44= 	16. 44+55= 	
																				                              	17. 46-55= 	18. 50+54= 	19. 53-55= 	20. 46+54= 	



																					                              Answers: 

																					                              1. 101 		2. -4 		3. 84 		4. 104 		
																					                              5. 88 		6. -8 		7. 6 		8. 103 		
																					                              9. 5 		10. -13 	11. 101 	12. 93 		
																					                              13. 94 		14. 106 	15. 97 		16. 99 		
																					                              17. -9 		18. 104 	19. -2 		20. 100 																
 */

import java.util.Scanner; //importing Scanner which will allow user input
import java.io.File; // importing  
import java.io.PrintWriter; //importing PrintWriter which will allow us to write to a file 
import java.io.IOException; //importing the IOException which will determine whether we can write to a file 

public class Worksheet
{
	private int max, min; // declaring the variables max and min which will later be used to ask the user what the highest and lowest values of their work sheet should be
	private int random, symbol; // delcaring the variable random which will store the randomly generated values in respect to the range, the variable symbol which will store the randomly generated sign
	private int arithmetic; // declaring the variable arithmetic which will decide whether the problem is going to be addition or subtraction
	private int [] firstVals; //storing the randomly generated values into an array called firstVals 
	private int [] secondVals; //storing the randomly generated values another array called secondVals
	private int [] newVals; //newVals will store the addition or subtraction from the arrays, firstVals and secondVals
	private String plusminus; //declaring the variable plusminus which will either become a "-" or a "+" depending on if the variable, symbol, generates a 0 or a 1
	
	public Worksheet() //creating the constructor 
	{
		max = 0; //initializing the max variable to 0
		min = 0; //initializing the min variable to 0
		firstVals = new int [20]; //initializing the firstVals array to a length of 20
		secondVals = new int[20]; //initializing the secondVals array to a length of 20
		newVals = new int[20]; //initializing the newVals array to a length of 20
		random = 0; //initializing the random variable to 0
		symbol = 0; //initializing the symbol variable to 0
		plusminus = ""; //initializing the plusminus variable to an empty string 
		arithmetic = 0; //initialzing the arithmetic variable 0
	}
	
	public static void main(String[] args) //creating the main method 
	{
		Worksheet run = new Worksheet(); //creating an instance of the class called run 
		run.calculate(); //using the instance run to call the calculate method 
	}
	
	public void calculate() //the calculate method will call all the other methods in the program
	{
		getInput(); //call the getInput() method, which will ask user input 
		calculateArray(); //call the calculateArray() method, which will calculate the values in the two arrays, firstVals and secondVals
		randomGenerate(); //call the randomGenerate() method, which will randomly generate either a 0("-") or a 1("+")
		addToFile(); //call the addToFile() method, which will write the problems and solutions to another file called Worksheet.txt
		
	}
	
	public void getInput()
	{
		Scanner in = new Scanner(System.in); //creating a Scanner
		System.out.print("\n\n"); 
		System.out.print("Please enter the maximum value for your worksheet: "); //prompting the user to enter the maximum value in their range
		max = in.nextInt();  //the user will enter the maximum value they want in their range 
		System.out.print("Please enter the minimum value for your worksheet: "); //prompting the user to enter the minimum value in their range
		min = in.nextInt();  //the user will enter the minimum value they want in their range 
		System.out.printf("\n\n"); 
	}
	
	public void calculateArray()
	{
		int range = (max - min) + 1; //calculating the range given the max and min values from the user input
		for (int i = 0; i<firstVals.length; i++) //creating a for loop and making it less than the firstVals(array) length 
		{
			int value = (int) (Math.random()*range + min); //randomly generating values with a span of the range and starts at the min value
			firstVals [i] = value; //storing every value in the array to the randomly generated value 
		}
		for (int i = 0; i<secondVals.length; i++) //creating a for loop and making it less than the secondVals(array) length
		{
			int value = (int) (Math.random()*range + min); //randomly generating values with a span of the range and starts at the min value
			secondVals [i] = value; //storing every value in the array to the randomly generated value 
		}
	}
	
	public void randomGenerate()
	{
		symbol = (int) (Math.random()*2 + 0); //randomly generating a 0 or a 1 and storing it in a variable called symbol
		
		if (symbol == 0) //if the value of symbol is equal to 0 then assign plusminus a minus sign
		{
			plusminus = "-"; //assigning a minus sign to the variable plusminus
		}
		else if (symbol == 1) //if the value of symbol is equal to 1 then assign plusminus a plus sign 
		{
			plusminus = "+"; //assigning a plus sign to the variable plusminus
		}
		
	}
	
	public void addToFile()
	{
		int counter = 0; //declare and initialize a counter variable to help will aligning 
		String outFileName = new String("Worksheet.txt"); //making the variable outFileName equal to the file we are writing to, Worksheet.txt
		File outFile = new File(outFileName); //making the variable outFile to equal outFileName
		PrintWriter makesOutput = null; //assigned the variable, makesOutput(PrintWriter) a null value 
		
		try //using a try catch block to write to a file 
		{
			makesOutput = new PrintWriter(outFile); //trying to write to a file using the PrintWriter 
		}
		catch (IOException e) //if the Print Writer cannot write to the file, the IOException error is thrown
		{
			System.err.println("Cannot create " + outFileName + "file to be written to."); //an error message will output if writing to the file is not possible
			System.exit(1); //the program will exit the try catch block
		} 
		makesOutput.printf("%50s","Name: _______________"); //if the try catch blocks runs smoothly, then the program will output the name 
		makesOutput.print("\n"); 
		makesOutput.printf("%49s","Date:_______________"); //if the try catch blocks runs smoothly, then the program will output the date 
		makesOutput.printf("\n\n"); 
		
		for (int i = 1; i<=firstVals.length; i++) //iterating through a for loop from when i = 1 and until i is less than or equal to firstVals.length
		{
			randomGenerate(); //call the randomGenerate method to always generate a new symbol, + or -, for every new equation
			makesOutput.print(i + ". " + firstVals[i-1] + plusminus + secondVals[i-1] + "= \t"); //outputting the addition or subtraction of the corresponding values in both arrays  
			counter++; //incrementing the counter by 1
			
			if (counter % 4 == 0) //if the counter value divided by 4 equals 0 then put the next equation on a new line 
			{
				makesOutput.print("\n"); //outputs a new line if counter is a multiple of four
			}
					
			if (plusminus.equals("+")) //if the sign is equal to a + then make the answer equal to the summation of the corresponding index in the firstVals array and secondVals array 
			{
				newVals[i-1] = firstVals[i-1] + secondVals[i-1]; //assign the sum to an index in an array, newVals
			}
			else if (plusminus.equals("-"))//if the sign is equal to a - then make the answer equal to the difference of the corresponding index in the firstVals array and secondVals array 
			{
				newVals[i-1] = firstVals[i-1] - secondVals[i-1]; //assign the difference to an index in an array, newVals
			}
		}
		counter = 0; //reseting the value of counter so that it could be used for printing out the answers in the addToFile() method 
		makesOutput.print("\n\n\n\n\n"); //prints out 5 spaces between the equations and the answers
		makesOutput.print("Answers: "); //prints out "Answers" to the file   
		makesOutput.print("\n\n"); 
		
		for (int i = 0; i<newVals.length; i++) //iterate through a for loop until newVals.length, this array contains all the sums and differences from the equations
		{
			int value = i+1;  
			makesOutput.print(value + ". " + newVals[i]+ "\t\t\t\t"); //prints out the sum to Worksheet.txt
			counter++; //incrementing counter
			
			if (counter % 4 == 0) //if the counter is divisible by 4 then make a new line 
			{
				makesOutput.print("\n"); //outputting a new line if counter is divisible by 4
			}
			
		}
			
			
		 
		makesOutput.close(); //closing the PrintWriter 
	}
}

