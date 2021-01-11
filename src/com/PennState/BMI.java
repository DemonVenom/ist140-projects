package com.PennState;

import java.util.Scanner;

/**
 * @author Henry Hoffman
 * @version 09/28/2020
 *
 *
 * This program computes and displays the body mass index (BMI) value
 * for an individual, given the height and weight.
 *
 */

public class BMI
{
    /**
     * The entry point for the program.
     *
     *  @param args The command-line arguments.
     */

    public static void main(String[] args)
    {
        // Create a new Scanner object...
        Scanner scnr = new Scanner(System.in);

        // Input the height...
        double height = scnr.nextDouble();

        // Input the weight...
        double weight = scnr.nextDouble();

        // Echo-print...
        System.out.printf("You entered %.2f inches and %.2f pounds.\n",
                height, weight);

        // Compute the BMI...
        double bmi = 703 * weight / Math.pow(height, 2.0);

        // Output the BMI...
        System.out.printf("The corresponding BMI value is %.2f.\n", bmi);

        // Create cascading if statement for bmi
        if (bmi < 18.5) {
            // Create and print classification for underweight less than 18.5
            System.out.print("Classification: Underweight.");
        }
        else if (bmi < 25.0) {
            // Create classification for normal between 18.5 and less than 25.0
            System.out.print("Classification: Normal weight.");
        }
        else if (bmi < 30.0) {
            // Create classification for overweight more than 25.0, less than 30.0
            System.out.print("Classification: Overweight.");
        }
        else {
            // Create classification for obesity more than or equal to 30.0
            System.out.print("Classification: Obesity.");
        }
    }
}