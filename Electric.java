/* 
 * Programmer: Shreya Mantripragada
 * Date: November 1, 2018 
 * Purpose: To use if else blocks to code a program about electric bills 
 		* Testing Plan: 
 		* Input: C and kilowatt hours used is 34.56 --> Output:			Commercial Bill 
 		 																Peak Hours: 34.56
 																		Cost: $ 120.00
 																		
 		* Input: C and the kilowatt hours used is 1987.34 --> Output:	Commercial Bill 
 																		Peak hours: 1987.34
 		 																Cost = $ 201.95
 		 																
 		* Input: R and the kilowatt hours used is 459.23 --> Output: 	Residential Bill 
 																		Peak hours: 459.23
 		 																Cost = $55.63															
 																
 		* Input: R and the kilowatt hours used is 23.34 --> Output: 	Residential Bill
 																		Peak Hours: 23.34
  																		Cost = $14.22	
 		
 		* Input: I and the peak hours used is 45.23 and the off peak hours used is 56.98 --> Output:	Industrial Bill
 		 																								Peak Hours: 56.98
 		 																								Off Peak Hours: 56.98
 		 																								Cost = $260.00
 		 																								
 		* Input I and the peak hours used is 91 and the off peak hours used is 10098.45 --> Output:		Industrial Bill 
 		 																								Peak Hours: 91.00
 		 																								Off Peak Hours: 10098.45
 		 																								Cost = $687.63 													
 */
import java.util.Scanner; // importing the Scanner package
public class Electric 
{
	private String inputVal;
	private double amtHoursR, amtHoursC, amtHoursI, totalCostR, totalCostC, totalCostI, costDiffC, costDiffI, peakVal, offPeakVal, costDiffII, totalCostII, finalCostI;
	final double R_CONV = 0.095; 
	final double C_CONV = 0.083; // creating final constants for the conversions
	final double I_CONVpeak = 0.109; 
	final double I_CONVoffpeak = 0.047; 
	
	
	public Electric () // making a constructor so we can initialize all of our field variables
	{
		inputVal = ""; 
		peakVal = 0.0; 
		offPeakVal = 0.0; 
		totalCostII = 0.0;
		amtHoursR = 0.0; 
		finalCostI = 0.0; 
		amtHoursC = 0.0; 
		amtHoursI = 0.0; 
		totalCostR = 0.0; 
		totalCostC = 0.0; 
		totalCostI = 0.0; 
		costDiffC = 0.0; 
		costDiffI = 0.0; 
		costDiffII = 0.0; 
	}
	public static void main(String[] args) // the main method calls the computeIt method by creating an instance of the class
	{
		Electric test = new Electric(); 
		test.computeIt(); 
	} 
	public void computeIt() // the computeIt method calls three methods, getData, calculateCost, and printInfo
	{
		getData(); 
		calculateCost(); 
		printInfo(); 
		
	}
	public void getData() 
	{
		Scanner in = new Scanner(System.in); // creating a Scanner to use in only this method
		System.out.println("___________________________________________________________________________");
		System.out.print("\n\n\n");
		System.out.printf("%s","Enter the type of electric bill, R for residential, C for commercial, I for industrial --> ");
		inputVal = in.nextLine(); // asking the user if he/she the type of electric bill they have
		
		if (inputVal.equals("R") || inputVal.equals("r"))  // creating if statements to decide whether the user entered r, c, or i and if they didn't enter those values, to enter them again
		{
			System.out.print("Enter the number of kilowatt hours of electricity used: ");
			amtHoursR = in.nextDouble();
			
			if (amtHoursR < 0) 
			{
				System.out.println("Please enter a number that is positive! ");
			}
		}
		else if (inputVal.equals("I") || inputVal.equals("i")) 
		{
			System.out.print("Enter the number of kilowatt hours of electricity used during peak hours --> ");
			peakVal = in.nextDouble(); 
			
			if (peakVal < 0)
			{
				System.out.println("Please enter a number that is positive!");
			}
			
			System.out.print("Enter the number of kilowatt hours of electricity used during off-peak hours --> ");
			offPeakVal = in.nextDouble();
			
			if (offPeakVal < 0)
			{
				System.out.println("Please enter a number that is positive!");
			}
		}
		else if (inputVal.equals("C") || inputVal.equals("c")) 
		{
			System.out.print("Enter the number of kilowatt hours of electricity used: ");
			amtHoursC = in.nextDouble(); 
			
			if (amtHoursC < 0) 
			{
				System.out.println("Please enter a number that is positive!");
			}
		}
		else { // if the user enters in an invalid character, then this will show
			System.out.print("Please enter a valid character! ");
		}
		
	}
	public void calculateCost() // this method calculates the cost for each bill given the information from the userInput method
	{
		if (inputVal.equals("R") || inputVal.equals("r")) 
		{
			totalCostR = 12.00 + amtHoursR*R_CONV;
		}
		else if (inputVal.equals("I") || inputVal.equals("i")) 
		{
			if (peakVal > 1000) 
			{
					costDiffI = peakVal - 1000; 
					totalCostI = 152.00 + costDiffI*I_CONVpeak;
			}
				else 
				{
				totalCostI = 152.00;
				}
			
			if (offPeakVal > 1000) 
			{
				
					costDiffII = offPeakVal -1000; 
					totalCostII = 108.00 + costDiffII*I_CONVoffpeak;
			}
				else 
				{
					totalCostII = 108.00; 
				}
			
			finalCostI = totalCostI + totalCostII; 
		}
		if (inputVal.equals("C") || inputVal.equals("c"))
		{
			if (amtHoursC > 1000) 
			{
				costDiffC = amtHoursC - 1000; 
				totalCostC = 120.00 + costDiffC*C_CONV; 
				
			}
			else 
			{
				totalCostC = 120.00; 
			}
		}
	}
	public void printInfo() //printing all the calculations 
	{
		if (inputVal.equals("R") || inputVal.equals("r"))
		{
			System.out.println("\n\n");
			System.out.printf("%-20s", "Residential Bill"); 
			System.out.println("\n");
			System.out.printf("%-20s %10.2f", "Peak Hours: ",amtHoursR);
			System.out.print("\n");
			System.out.printf("%-15s %5s %10.2f", "Cost:","$", totalCostR);
			System.out.print("\n");
			System.out.println("________________________________________________________________________");
			
		}
		else if (inputVal.equals("I") || inputVal.equals("i"))
		{
			System.out.println("\n\n");
			System.out.printf("%s", "Industrial Bill");
			System.out.println("\n");
			System.out.printf("%-20s %10.2f", "Peak Hours: ", peakVal);
			System.out.println("\n");
			System.out.printf("%-20s %10.2f", "Off Peak Hours: ", offPeakVal);
			System.out.println("\n");
			System.out.printf("%-15s %5s %10.2f" , "Cost: ", "$" ,finalCostI );
			System.out.println("\n");
			System.out.println("________________________________________________________________");
		}
			
		else if (inputVal.equals("C") || inputVal.equals("c")) 
		{
			System.out.print("\n\n");
			System.out.printf("%-20s", "Commercial Bill"); 
			System.out.println("\n");
			System.out.printf("%-20s %10.2f", "Peak Hours:",amtHoursC);
			System.out.println("\n");
			System.out.printf("%-15s %5s %10.2f", "Cost:","$", totalCostC);
			System.out.print("\n");
			System.out.println("\n\n\n");
			System.out.println("__________________________________________________________________");
			
		}
		
	}

}
