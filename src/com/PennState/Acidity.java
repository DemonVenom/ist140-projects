package com.PennState;
import java.util.Scanner;

/**
 *   Demonstrates the use of arithmetic operations in Java.
 *
 *   @author Henry Hoffman
 *   @version 09/13/20
 *
 */

public class Acidity
{
    /**
     *  Entry point for the program.
     *
     *  @param args The command-line arguments for the class.
     */

    public static void main(String [] args)
    {
        // Create the Scanner object...
        Scanner scnr = new Scanner(System.in);

        // Input the user's first PH reading...
        int pH_1 = scnr.nextInt();
        // Input the user's second PH reading...
        int pH_2 = scnr.nextInt();

        // Storage for the magnitude....
        double magnitude = 0;

        // Determine magnitude between pH levels
        magnitude = Math.pow(10, -(pH_1) + pH_2);

        // Print out the relative difference between them
        System.out.println("A pH of " + pH_1 + " is " + magnitude
                + " time(s) as acidic as a pH of " + pH_2 + ".");
    }
}
