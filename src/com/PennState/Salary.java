package com.PennState;

import java.util.Scanner;

/**
 *   Inputs a series of six (6) integer values representing the hours
 *   worked in 6 separate weeks. These values are used to compute
 *   the gross pay for an individual, based on a salary of $21.00/hour
 *   with a $10 weekly bonus for working more than 40 hours in that week.
 *
 *   @author Henry Hoffman
 *   @version 10/08/2020
 */

public class Salary
{
    /**
     *   Entry point for the class (program).
     *
     *   @param args The command-line arguments.
     */

    public static void main(String[] args)
    {
        // Create the Scanner object...
        Scanner scnr = new Scanner(System.in);

        // Create a variable to store the hours...
        int hours = 0;
        // Create a variable to store the total pay...
        double pay = 0.00;


        // Prompt the user...
        System.out.print("Enter 6 values for the hours worked, "
                + "separated by a space: ");
        // Create for statement to loop pay calculation
        for (int i = 0; i < 6; i++) {
            // scan user input for hours
            hours = scnr.nextInt();
            // calculate pay based on hours
            pay = (double)(pay + (21.00 * hours));
            // print if statement for when they work more than 40 hours
            if (hours > 40) {
                // add 10 dollars to their pay for that week
                pay = pay + 10.00;
            }
        }
        // Print out calculations
        System.out.printf("The gross pay is $%.2f.", pay);
    }
}