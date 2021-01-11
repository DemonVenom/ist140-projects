package com.PennState;

import java.util.Scanner;

/**
 *  A program that DAFHAKJGHLGALGAKGHJAGHJGHdfafjlkkj
 *
 *
 * @author Henry Hoffman
 * @version 09/14/2020
 *
 */

public class ArterialPressure {

    /**
     * Entry point for the program.
     *
     * @param args The command-line arguments for the program.
     */
    public static void main(String[] args) {

        // Create new scanner method
        Scanner scnr = new Scanner(System.in);
        // Create new integers for systolic and diastolic pressure
        int sysPres = 0, diaPres = 0;
        // Create double for pulse pressure
        double pulsePres = 0.0, meanPres = 0.0;

        // Print statement for user to understand systolic pres input
        System.out.print("Enter your systolic pressure: ");
        // Allow user to input systolic pres and put in variable
        sysPres = scnr.nextInt();

        // Print statement for user to understand diastolic pres input
        System.out.print("Enter your diastolic pressure: ");
        // Allow user to input diastolic pres and put in variable
        diaPres = scnr.nextInt();

        // Echo print inputs
        System.out.println("\nYou entered a pressure of " + sysPres + " / " + diaPres + ".");

        // Calculate pulse pressure
        pulsePres = (double) sysPres / diaPres;
        // Print out pulse pressure
        System.out.printf("Your pulse pressure is: %.2f.", pulsePres);

        // Create if statement to show that pulse pressure is too high
        if (pulsePres > 80.0) {
            System.out.print("Your pulse pressure is high.");
        }

        // Calculate mean arterial pressure
        meanPres = diaPres + ((1.0/3.0) * pulsePres);

        // Print out mean arterial pressure
        System.out.printf("Your mean arterial pressure is: %.2f.", meanPres);

        // Create if statement to warn user if mean arterial pressure is low
        if (meanPres < 60.0) {
            System.out.print("You should seek medical assistance");
        }
        else {
            System.out.print("Your mean arterial pressure is within acceptable limits.");
        }
    }
}