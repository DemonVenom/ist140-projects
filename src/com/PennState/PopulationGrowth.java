package com.PennState;
import java.util.Scanner;

/**
 *
 * This program calculates the growth and decline of a population
 * based on birth rates, death rates, initial population,
 * and time span that the event occurred
 *
 *
 * @author Henry Hoffman
 * @version 09/28/2020
 */

public class PopulationGrowth {
    /**
     * The entry point for the program.
     *
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {

        // Create a new Scanner object
        Scanner scnr = new Scanner(System.in);

        // Create double variables for...
        // b, the per capita birth rate in the range [0.0...1.0)
        // d, the per capita death rate in the range [0.0...1.0)
        // time_span, the number of years for which to compute population total
        // r, difference between the average number of births and deaths
        double b = 0.0, d = 0.0, time_span = 0.0, r = 0.0, p = 0.0;
        // Create integer variables for..
        // counter, the year and counter used by the while statement
        // p, the initial population size in the range [1...1000]
        int counter = 0;
        // Create boolean variable for...
        // populationBelowZero, whether or not the population is extinct
        boolean populationZero = false;

        // Prompt the user to input population size
        System.out.print("Enter the initial population size [1-1000]: ");
        // Scan user input for population size
        p = scnr.nextDouble();

        // Prompt the user to input population size
        System.out.print("Enter the birth rate [0.0...1.0): ");
        // Scan user input for birth rate
        b = scnr.nextDouble();

        // Prompt the user to input death rate
        System.out.print("Enter the death rate [0.0...1.0): ");
        // Scan user input for death rate
        d = scnr.nextDouble();

        // Prompt the user to input number of years
        System.out.print("Enter the number of years [1...100): ");
        // Scan user input for number of years
        time_span = scnr.nextDouble();

        // Output the column labels for population and year
        System.out.printf("\n%-20s  %-20s%n", "Year", "Population\n");
        // Calculate difference between the average number of births and deaths
        r = b - d;

        // Create while statement to calculate population per year
        while ((counter < time_span) && (populationZero == false)) {
            // Print out calculations
            System.out.printf("%-20s  %-20s%n", counter, (int)p);
            // Calculate the population
            p = (int)(p + (r * p));
            // Increase counter by 1
            counter++;

            // Create if statement for when population equals zero
            if (p <= 0) {
                populationZero = true;
                // Print out statement saying population is zero
                System.out.printf("%-20s  %-20s%n", counter, 0);
                // Print out statement saying population is extinct
                System.out.print("\nThe population has gone extinct");
            }
        }
    }
}