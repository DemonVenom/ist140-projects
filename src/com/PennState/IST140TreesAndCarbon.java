package com.PennState;

import java.util.Scanner;

/**
 *   Calculates the total amount of carbon dioxide absorbed by cluster of trees
 *   and print data onto an ordered data table that includes individual tree
 *   height, diameter, green weight (mass), amount of carbon stored by tree,
 *   and amount of CO2 stored by the tree.
 *
 *   @author Henry Hoffman
 *   @version 11/03/2020
 */

public class IST140TreesAndCarbon {

    /**
     *  Entry point for the program.
     *
     *  @param args the command line arguments
     */

    public static void main(String[] args) {

        // Create new scanner object
        Scanner scnr = new Scanner(System.in);
        // Create double array for...
        // treeHeight, the height of each tree - capped at 10 tree values
        double[] treeHeight = new double[10];
        // treeDiameter, the diameter of each tree - capped at 10 tree values
        double[] treeDiameter = new double[10];
        // mass, the mass of each tree - capped at 10 tree values
        double[] mass = new double[10];
        // carbon, the amount of carbon - capped at 10 tree values
        double[] carbon = new double[10];
        // carbon, the amount of co2 - capped at 10 tree values
        double[] co2 = new double [10];
        // totalCo2, the total amount of co2 absorbed
        double totalCo2 = 0;

        // Create for loop to iterate 10 times for 10 tree values
        for (int i = 0; i < 10; i++) {
            // Prompt user to input data for height for tree at index i
            System.out.print("Enter the height for tree " + (i + 1)
                                + ", in cm: ");
            // Assign return value of inputHeight to array value at index i
            treeHeight[i] = inputHeight(scnr);

            // Prompt the user to input data for diameter for tree at index i
            System.out.print("Enter the diameter for tree " + (i + 1)
                                + ", in cm: ");
            // Assign return value of inputDiameter to array value at index i
            treeDiameter[i] = inputDiameter(scnr);
        }
        // Call calculateMass method, input treeHeight, treeDiameter, and mass
        calculateMass(treeHeight, treeDiameter, mass);

        // Create for loop to iterate through each array indexes and assign...
        for (int i = 0; i < 10; i++) {
            // each array index using the equation carbon = 0.25 * gw
            carbon[i] = mass[i] * 0.25;
        }

        // Create for loop to iterate through each array indexes and assign...
        for (int i = 0; i < 10; i++) {
            // each array index using the equation carbon = 0.25 * gw
            co2[i] = carbon[i] * 3.67;
        }

        // Call calculateCarbon method, assign to totalCo2 variable
        totalCo2 = calculateTotalCarbon(co2);

        // Call dataTableLabel to print out data table labels
        dataTableLabel();
        // Call dataTable, input all arrays and totalCo2, print data table
        dataTable(treeHeight, treeDiameter, mass, carbon, co2, totalCo2);
    }

    /**
     * Allows user to input double value, returns error if larger than 30.48
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param scnr  The scanner object used to receive user input
     * @return      User input value larger that must be more than 30.48
     *
     */

    public static double inputHeight(Scanner scnr) {

        // Create string integer for...
        // userInput, the number that will be scanned
        double userInput = 0;

        // Assign the next double object to userInput variable
        userInput = scnr.nextDouble();

        // Create while statement, when userInput is less/equal to 30.48...
        while (userInput <= 30.48) {
            // ...print out error message
            System.out.println("*** ERROR: The height must be greater " +
                                "than 30.48 cm. Please try again.");
            // Assign the next double object replace last userInput variable
            userInput = scnr.nextDouble();
        }

        // return the user input but larger than 30.48
        return userInput;
    }

    /**
     * Allows user to input double value,
     * returns error if smaller than or equal to 2.0
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param scnr  The scanner object used to receive user input
     * @return      User input value larger that must larger than 2.0
     *
     */

    public static double inputDiameter(Scanner scnr) {

        // Create string integer for...
        // userInput, the number that will be scanned
        double userInput = 0;

        // Assign the next double object to userInput variable
        userInput = scnr.nextDouble();

        // Create while statement, when userInput is less/equal to 2.0...
        while (userInput <= 2.0) {
            // ...print out error message
            System.out.println("*** ERROR: The diameter must be greater " +
                    "than 2 cm. Please try again.");
            // Assign the next double object to userInput variable
            userInput = scnr.nextDouble();
        }

        // return the user input with no spaces, but written forwards
        return userInput;
    }

    /**
     * Uses the diameter and height to compute the green weight mass
     * (wood content + moisture) of the tree in kilograms
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param treeHeight    The height of each tree
     * @param treeDiameter  The diameter of each tree
     * @param mass          The green weight mass of each tree
     *
     */

    public static void calculateMass(double[] treeHeight,
                                     double[] treeDiameter,
                                     double[] mass) {

        // Create for loop to iterate through each array indexes
        for (int i = 0; i < 10; i++) {
            // Create if statement, when the tree diameter is less than 28...
            if (treeDiameter[i] < 28.0) {
                // ...assign mass index of i to 0.0577 x d^2 x h
                mass[i] = 0.0577 * Math.pow(treeDiameter[i],2) * treeHeight[i];
            }
            // Create if statement, when tree diameter is more than/equal 28...
            else if (treeDiameter[i] >= 28.0) {
                // ...assign mass index of i to 0.0346 x d^2 x h
                mass[i] = 0.0346 * Math.pow(treeDiameter[i],2) * treeHeight[i];
            }
        }
    }

    /**
     * Uses the diameter and height to compute the green weight mass
     * (wood content + moisture) of the tree in kilograms
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param co2   The co2 absorbed of each tree
     * @return the total co2 absorbed by all 10 trees
     *
     */

    public static double calculateTotalCarbon(double[] co2) {

        // Create double variable for...
        // total, the total amount of co2 absorbed
        double total = 0;
        // Create for loop to iterate through each array indexes and...
        for (int i = 0; i < 10; i++) {
            // add array variable at index i to total
            total = total + co2[i];
        }
        // Return the total variable
        return total;
    }

    /**
     * Displays a labels for the data table
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     */

    public static void dataTableLabel() {

        // Create data table labels
        System.out.printf("\n%15s %15s %15s %15s %15s",
                "HEIGHT", "DIAMETER", "MASS", "CARBON", "CO2");
        // Print out data table lines
        System.out.printf("\n%15s %15s %15s %15s %15s",
                "------", "--------", "----", "------", "---");

    }

    /**
     * Displays a data table of every tree height, diameter, green weight,
     * amount of carbon stored, amount of CO2 stored, and total CO2 stored by
     * all 10 trees in an organized format.
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param treeHeight    List of height of the tree, in cm
     * @param treeDiameter  List of diameter of the tree, in cm
     * @param mass          List of green weight (mass)
     * @param carbon        List of amount of carbon stored by the tree, in kg
     * @param co2           List of amount of CO2 stored by the tree, in kg
     * @param totalCo2      The total amount of total CO2 stored by all trees
     *
     */

    public static void dataTable(double[] treeHeight,
                                 double[] treeDiameter,
                                 double[] mass,
                                 double[] carbon,
                                 double[] co2,
                                 double totalCo2) {

        // Create for statement to iterate 10 times
        for (int i = 0; i < 10; i++) {
            // Print out array variable at index i, spaced by 15 chars, rounded
            System.out.printf("\n%15.2f %15.2f %15.2f %15.2f %15.2f",
                                treeHeight[i], treeDiameter[i],
                                mass[i], carbon[i], co2[i]);
        }
        // Print out total carbon dioxide label
        System.out.printf("\n\n%45s", "TOTAL CO2: ");
        // Print out total carbon dioxide rounded to 2 decimal places
        System.out.printf("%.2f", totalCo2);
    }

}
