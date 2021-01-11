package com.PennState;

import java.util.Scanner;

public class ClassConvertUnits
{
    public static void main(String [] args)
    {
        // Declare a variable for the user input...
        double measurement_in_feet = 0.0;
        // Declare variables for conversions...
        double inches = 0.0, meters = 0.0, centimeters = 0.0;

        // Create a new Scanner object...
        Scanner scnr = new Scanner(System.in);

        // Prompt the user...
        System.out.print("Please enter a measurement, in feet: ");
        // Input the value...
        measurement_in_feet = scnr.nextDouble();
        // Echo-print the input value...
        System.out.println("You entered: " + measurement_in_feet);

        // Convert to inches...
        inches = measurement_in_feet * 12.0;
        // Convert to meters...
        meters = measurement_in_feet * 0.3048;
        // Convert to centimeters...
        centimeters = measurement_in_feet * 30.48;
        // centimeters = meters * 100;

        // Output the results (inches)...
        System.out.printf("Inches: %.3f\n",
                inches);
        // Output the results (meters)...
        System.out.printf("Meters: %8.3f\n", meters);
        // Output the results (centimeters)...
        System.out.printf("Centimeters: %.2f\n", centimeters);

    }
}

