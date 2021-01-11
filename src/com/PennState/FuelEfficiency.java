import java.util.Scanner;

/**
 * A program that allows the user to enter the MPG of a vehicle that uses
 * gasoline and a vehicle that uses a hybrid of gasoline and electricity.
 * The program will then calculate how many gallons each gasoline
 * and hybrid vehicle will use within a 100,000 mile lifespan.
 * Finally, the program will calculate the cost of gasoline
 * (assuming a constant cost of $2.95) over this 100,000 mile lifespan
 * for each vehicle.
 *
 *
 * @author Henry Hoffman
 * @version 09/09/20
 */

public class FuelEfficiency
{
   /**
     *
     * Entry point for the class (program).
     *
     * @param args the command-line arguments.
     */

   public static void main(String [] args)
   {
      // Declare the variable for mpg of gas
      double mpg_gas = 0.0;
      // Declare the varable for mpg of hybrid
      double mpg_hybrid = 0.0;
      
      // Create new scanner object
      Scanner scnr = new Scanner(System.in);
      
      // Prompt the user for gas mpg
      System.out.print("Enter the MPG for a gas car: ");
      // Input the value
      mpg_gas = scnr.nextDouble();
      
      // Prompt the user for hybrid mpg
      System.out.print("Enter the MPG for a hybrid car: ");
      mpg_hybrid = scnr.nextDouble();
      
      // Show two digits on the right for gas car
      System.out.printf("\nThe gas car achieves %.2f miles per gallon.",
                        mpg_gas);
      
      // Show two digits on the right for hybrid car
      System.out.printf("\nThe hybrid car achieves %.2f miles per gallon.\n",
                        mpg_hybrid);
      
      // Declare variable for gallons gas over 100,000 miles for gas car
      double gallons_gas = 0.0;
      // Declare variable for gallons gas over 100,000 miles for hybrid car
      double gallons_hybrid = 0.0;
      
      // Store calculations inside of gas car variable previously declared
      gallons_gas = 100000/mpg_gas;
      // Store calculations inside of gas car variable previously declared
      gallons_hybrid = 100000/mpg_hybrid;
      
      // Print out calculations for gas car
      System.out.printf("\nThe gas car uses %.2f gallons per 100000 miles.\n",
                        gallons_gas);
      // Print out calculations for hybrid car
      System.out.printf("The hybrid car uses %.2f gallons per 100000 miles.\n",
                        gallons_hybrid);

      // Declare variables for cost of gallons over 100,000 miles for gas car
      double cost_gas = 0.0;
      // Declare variables for cost of gallons over 100,000 miles for hybrid
      double cost_hybrid = 0.0;
      
      // Store calculations inside of cost of gas variable for gas car
      cost_gas = gallons_gas * 2.95;
      // Store calculations inside of cost of gas variable for hybrid car
      cost_hybrid = gallons_hybrid * 2.95;
      
      // Print out calculations for gas car
      System.out.printf("\nThe gas car cost $%.2f per 100000 miles.\n",
                        cost_gas);
      // Print out calculations for hybrid car
      System.out.printf("The hybrid car costs $%.2f per 100000 miles.",
                        cost_hybrid);
   }
}