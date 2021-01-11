package com.PennState;

import java.util.Scanner;

/**
 *   Program that allows the user to input an acidity level number
 *   and the program outputs the acidity level name.
 *
 *   @author Henry Hoffman
 *   @version 09/21/20
 *
 */

public class Acidity2
{
    /**
     *  Entry point for the program.
     *
     *  @param args The command-line arguments for the class.
     */

    public static void main(String [] args)
    {
        // Create new scanner
        Scanner scnr = new Scanner(System.in);
        // Declare pH double variable
        double pH = 0.0;
        // Declare string variable for level
        String level = null;

        // Inform the user to input pH level
        System.out.print("Please enter a pH level " +
                            "in the range [0.0...14.0]: ");
        // Put user input into variable
        pH = scnr.nextDouble();

        // Create cascading if statement for level assignment
        if (pH < 0.0) {
        // Outputs a level that is outside of range
        System.out.print("Error: Not a real pH level.");
        }
        else if (pH < 3.0) {
            // Outputs a level of very acidic
            level = "Very Acidic";
        }
        else if (pH < 7.0) {
            // Outputs a level of acidic
            level = "Acidic";
        }
        else if (pH == 0.0) {
            // Outputs a level of neutral
            level = "Neutral";
        }
        else if (pH < 12.0) {
            // Outputs a level of alkaline
            level = "Alkaline";
        }
        else if (pH <= 14.0) {
            // Outputs a level of very alkaline
            level = "Very Alkaline";
        }
        else {
            // Outputs a level that is outside of range
            System.out.print("Error: Not a real pH level.");
        }
        // Print out results
        System.out.printf("\nYour rainwater has a pH level of %.4f and is"
                            + " a(n) " + level + " solution.", pH);
    }
}
