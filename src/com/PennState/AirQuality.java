package com.PennState;

import java.util.Scanner;

/**
 * A program that will ASDLFALGHLGALGSJL
 *
 *
 *
 * @author Henry Hoffman
 * @version 09/15/2020
 */

public class AirQuality
{

    /**
     * Entry point for the program
     *
     * @param args The command-line arguments for the program.
     */
    public static void main(String [] args) {

        // Create new scanner object
        Scanner scan = new Scanner(System.in);
        // Declare string for locality name and rating (rating will change)
        String local, rating;

        // Declare integer for the observed 8-hour mean level of ozone
        int mean = 0;

        // Prompt the user to input the locality name
        System.out.print("Enter the Locality Name: ");
        // Input the value
        local = scan.next();

        // Prompt the user to input the observed 8-hour mean level of ozone
        System.out.print("Enter the 8-hour mean level of ozone "
                            + "in micrograms/cubic meter: ");
        // Input the value
        mean = scan.nextInt();

        // Echo print results
        System.out.println("\nYou entered " + local + " and an 8-hour mean "
                            + "level of " + mean + " micrograms/cubic meter.");

        // Create branching if statement for mean level above 100
        if (mean > 100) {
            System.out.println(local + " exceeds the 8-hour mean of 100 "
                                + "micrograms/cubic meter.");
        }
        // Create branching if statement to determine rating of mean
        if (mean < 51) {
            rating = "GOOD";
        }
        else if (mean < 101) {
            rating = "MODERATE";
        }
        else if (mean < 151) {
            rating = "UNHEALTHY (for sensitive groups)";
        }
        else if (mean < 201) {
            rating = "UNHEALTHY";
        }
        else if (mean < 301) {
            rating = "VERY UNHEALTHY";
        }
        else {
            rating = "HAZARDOUS";
        }
        // Print out results
        System.out.println(local + " has a rating of " + rating);
    }
}