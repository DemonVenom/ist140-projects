package com.PennState;

import java.util.Scanner;

/**
 *   Calculates the amount of water that a tree needs throughout the lifespan
 *   of a tree's user-inputted years and trunk diameter grown per year
 *
 *   @author Henry Hoffman
 *   @version 10/16/2020
 */

public class TreeGrowth {

    /**
     *  Entry point for the program.
     *
     *  @param args the command line arguments
     */

    public static void main(String[] args) {

        // Create new scanner object
        Scanner scnr = new Scanner(System.in);
        // Create double variables for...
        // centimeters, the amount of tree trunk diameters added each year
        // diameter, the diameter of tree trunk outputted in loop
        double centimeters = 0, diameter = 0;
        // Create integer variables for...
        // years, the number of years for the tree to grow
        // water, the number of water needed measured in liters/week
        int years = 0, water = 0;

        // Execute centimeterInput method, allow the user to input centimeters
        centimeters = centimeterInput(centimeters, scnr);
        // Execute yearsInput method, allow the user to input years
        years = yearsInput(years, scnr);

        // Echo print user inputs
        System.out.println("You entered a diameter of " + centimeters +
                            " cm and a time span of " + years + " year(s).\n");

        // Create for loop to output each year in the tree's lifespan
        for (int i = 1; i <= years; i++) {
            // Calculate centimeters grown
            diameter = diameter + centimeters;
            // Calculate water needed as 37.85 liters per every 2.54cm of trunk
            water = (int)(Math.round(diameter * (37.85 / 2.54)));
            // Print out results
            System.out.printf("Year " + i + ": diameter = %.2f cm, " +
                    "water required = " + water + " liters/week.\n", diameter);
        }
    }

    /**
     * Allows the user to input trunk diameter growth, but only more than zero
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param centimeters   The user input double of the diameter of the tree
     *                          added per year, but set to zero initially.
     * @param scnr          The scanner object that the reads the user input
     * @return centimeters  An updated version of the user input corrected by
     *                          the user
     *
     */

    public static Double centimeterInput(double centimeters, Scanner scnr) {

        // Prompt the user to input variables for centimeters
        System.out.print("Enter the diameter added per year, in cm: ");
        // Place user input into centimeters variable
        centimeters = scnr.nextDouble();

        // Create while loop to cycle through user inputs until centimeters > 0
        while (centimeters <= 0) {
            // Print out error message when inputted incorrectly
            System.out.println("ERROR: The diameter must be > 0. "+
                    "Please try again.");
            // Prompt the user to input variables again
            System.out.print("Enter the diameter added per year, in cm: ");
            // Place user input into centimeters variable
            centimeters = scnr.nextDouble();
        }
        // Return the user input
        return centimeters;
    }

    /**
     * Allows the user to input tree lifespan in years, but only more than zero
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param years     The user input of years of the tree lifespan,
     *                      but set to zero initially.
     * @param scnr      The scanner object that the reads the user input
     * @return years    An updated version of the user input corrected by
     *                      the user
     *
     */

    public static int yearsInput(int years, Scanner scnr) {

        // Prompt the user to input variables for years
        System.out.print("Enter the number of years: ");
        // Place user input into centimeters variable
        years = scnr.nextInt();

        // Create while loop to cycle through user inputs until years > 0
        while (years <= 0) {
            // Print out error message when inputted incorrectly
            System.out.println("ERROR: The years must be > 0. "+
                    "Please try again.");
            // Prompt the user to input variables again
            System.out.print("Enter the number of years: ");
            // Place user input into centimeters variable
            years = scnr.nextInt();
        }
        // Return the user input
        return years;
    }
}
