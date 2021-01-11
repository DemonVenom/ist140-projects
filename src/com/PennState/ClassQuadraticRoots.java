package com.PennState;

import java.util.Scanner;

/**
 *  Program which asks the user for the three coefficients of a
 *  quadratic equation and produces the real-number roots (if any).
 *
 *  @author Henry Hoffman
 *  @version 09/02/2020
 */

public class ClassQuadraticRoots
{
    /**
     * Entry point for the class (program).
     *
     * @param args The command-line arguments.
     */

    public static void main(String [] args) {
        // Declare a Scanner object...
        Scanner scnr = new Scanner(System.in);
        // Declare variables to store the inputs...
        int a = 0, b = 0, c = 0;

        // Prompt the user...
        System.out.print("Please enter the coefficients,"
                + "separated by spaces: ");
        // Input the "a" coefficient...
        a = scnr.nextInt();
        // Input the "b" coefficient...
        b = scnr.nextInt();
        // Input the "c" coefficient...
        c = scnr.nextInt();

        // Echo-print...
        System.out.println("You entered a = " + a + ", b = "
                + b + ", c = " + c);

        // Check to see if a is 0...
        if (a == 0) {
            // Yes, so it is not quadratic...
            System.out.println("The equation is not quadratic.");
        }
        else {
            // No, so check the discriminant "d"...
            double d = Math.pow(b, 2) - (4 * a * c);

            if (d < 0) {
                // Yes, the roots are complex...
                System.out.println("The roots are complex.");
            } else {
                // Compute the real-number roots...
                // Declare the first root...

                double root1 = (-b + Math.sqrt(d)) / (2 * a);
                // Declare the second root ...
                double root2 = (-b - Math.sqrt(d)) / (2 * a);

                // Output the roots...
                System.out.printf("Roots: %.2f %.2f\n", root1, root2);
            }
        }
    }
}