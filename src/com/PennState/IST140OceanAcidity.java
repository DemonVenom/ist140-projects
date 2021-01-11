package com.PennState;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *   Prints out data table for ocean acidity level over time based on
 *   user-inputted data file, calculating the pH level differences
 *   as well as the dissolved CO2 levels
 *
 *   @author Henry Hoffman
 *   @version 11/16/2020
 */

public class IST140OceanAcidity {

    /**
     * Entry point for the class (program).
     *
     * @param args The command-line arguments.
     */

    public static void main(String[] args) {

        // Create new scanner object
        Scanner scnr = new Scanner(System.in);
        // Create string variable for...
        // userFile, the file used to output data table
        String userFile = null;
        // Create double array for...
        // yearTime, the year and time of the reading -- maxed at 512 elements
        double[] yearTime = new double[512];
        // acidLevel, pH level for the reading -- maxed at 512 elements
        double[] acidLevel = new double[512];
        // carbonDioxide, the amount of dissolved CO2 -- maxed at 512 elements
        double[] carbonDioxide = new double[512];

        // Prompt the user to input a file name
        System.out.print("Please enter the name of a file: ");

        // Scan the user input file
        userFile = scnr.nextLine();

        // Echo print the file name
        System.out.println("You entered the filename '" + userFile + "'.");

        try {
            // Create counter variable
            int counter = 0;

            // Open the file stream...
            FileInputStream fis = new FileInputStream(userFile);

            // Inform the user that the userFile is open
            System.out.println("\nFile '" + userFile + "' is now open.");

            // Build the Scanner
            Scanner fscan = new Scanner(fis);

            // Call readFile method
            readFile(yearTime, acidLevel, carbonDioxide, fscan);

            // Find the total amount of elements in the parallel arrays
            // When the element at 'counter' index =/= equal 0...
            while (yearTime[counter] != 0.0) {
                // ...add +1 to counter
                counter++;
            }
            // Create the PrintWriter object...
            PrintWriter writer = new PrintWriter("hoffman.txt");

            // Call createTable method
            createTable(yearTime, acidLevel, carbonDioxide, counter, writer);

            // Call calculateAverages method
            calculateAverages(acidLevel, carbonDioxide, counter, writer);

            // Close the file (output)...
            writer.close();
            // Close the file...
            fscan.close();
            // Inform the user that userFile is closed
            System.out.print("\nFile '" + userFile + "' is now closed.");
        }
        // When the user-inputted file cannot be found...
        catch (FileNotFoundException fnf_except) {
            // ...report to the user the error
            System.out.print("\nERROR: File '" + userFile + "' is NOT open.");
        }
    }

    /**
     * Reads the user-inputted file and places data into parallel arrays
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param yearTime      The year and time of the reading
     * @param acidLevel     pH level for the reading
     * @param carbonDioxide The amount of dissolved CO2
     * @param fscan         The scanner for the user-inputted file
     */

    public static void readFile(double[] yearTime,
                                double[] acidLevel,
                                double[] carbonDioxide,
                                Scanner fscan) {

        // Create integer variable for...
        // counter, the amount record(s) that have been read from the file
        int counter = 0;

        // When is still data in the file to be scanned...
        while (fscan.hasNext()) {

            // Assign (1st) number to yearTime array at index 'counter'
            yearTime[counter] = fscan.nextDouble();
            // Assign (2nd) number to acidLevel array at index 'counter'
            acidLevel[counter] = fscan.nextDouble();
            // Assign (3rd) number to carbonDioxide array at index 'counter'
            carbonDioxide[counter] = fscan.nextDouble();
            // Add +1 to counter variable
            counter++;

        }
        System.out.println(counter
                + " record(s) have been read from the file.");
    }

    /**
     * Separates year and the timestamp by the decimal point. Also
     * creates table of user-inputted data file with labels and rounded.
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     * Outputs onto a separate document
     *
     * @param yearTime      The year and time of the reading
     * @param acidLevel     pH level for the reading
     * @param carbonDioxide The amount of dissolved CO2
     * @param writer        The writer object that outputs data onto document
     */

    public static void createTable(double[] yearTime,
                                   double[] acidLevel,
                                   double[] carbonDioxide,
                                   int counter,
                                   PrintWriter writer) {

        // Create data table labels
        writer.printf("\n%1s %15s %15s %25s",
                "YEAR", "TIMESTAMP", "PH", "DISSOLVED CO2");
        // Print out data table lines
        writer.printf("\n%1s %15s %15s %25s",
                "----", "---------", "--------", "-------------");

        // Create for statement to iterate up to the last element in arrays
        for (int i = 0; i < counter; i++) {

            // Declare an double variable to store yearTime variable at index i
            double val = yearTime[i];

            // Convert the integer to a string
            String int_string = String.valueOf(val);

            // Find the decimal point
            int pos = int_string.indexOf(".");

            // parse out the substring, ending just before the decimal point
            String year = int_string.substring(0, pos);

            // parse out the substring, beginning just past the decimal point
            String time = int_string.substring(pos + 1);

            // Print out array variables at index i
            writer.printf("\n%1s %15s %15.4f %25.4f",
                    year, time,
                    acidLevel[i], carbonDioxide[i]);
        }
        // Print two extra new lines
        writer.print("\n\n");
    }


    /**
     * Calculates and outputs average pH and CO2 levels initially
     * and at the end of the data readings with
     * percentage differences between beginning and ending.
     * Outputs onto a separate document
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param acidLevel     pH level for the reading
     * @param carbonDioxide The amount of dissolved CO2
     * @param counter       The amount elements in each parallel array
     * @param writer        The writer object that outputs data onto document
     */

    public static void calculateAverages(double[] acidLevel,
                                         double[] carbonDioxide,
                                         int counter,
                                         PrintWriter writer) {

        // Create double variable for...
        // avgAcidFirst, the average of the first 10 pH readings
        // avgAcidLast, the average of the last 10 pH readings
        double avgAcidFirst = 0, avgAcidLast = 0, perAcid = 0;
        // avgDisFirst, the average of the first 10 dissolved CO2 readings
        // avgDisLast, the average of the last 10 dissolved CO2 readings
        double avgDisFirst = 0, avgDisLast = 0, perDis = 0;

        // Create for statement to iterate through the first 10 array elements
        for (int i = 0; i < 10; i++) {
            // Increment acidLevel element at index i to avgAcidFirst
            avgAcidFirst = (avgAcidFirst + acidLevel[i]);
            // Increment carbonDioxide element at index i to avgDisFirst
            avgDisFirst = (avgDisFirst + carbonDioxide[i]);
        }
        // Divide first 10 element totals by 10 for pH level
        avgAcidFirst = (avgAcidFirst / 10);
        // Divide first 10 element totals by 10 for dissolved CO2 levels
        avgDisFirst = (avgDisFirst / 10);

        // Create for statement to iterate through the last 10 array elements
        for (int i = (counter - 10); i < counter; i++) {
            // Increment acidLevel element at index i to avgAcidLast
            avgAcidLast = (avgAcidLast + acidLevel[i]);
            // Increment carbonDioxide element at index i to avgDisLast
            avgDisLast = (avgDisLast + carbonDioxide[i]);
        }
        // Divide last 10 element totals by 10 for pH level
        avgAcidLast = (avgAcidLast / 10);
        // Divide last 10 element totals by 10 for dissolved CO2 levels
        avgDisLast = (avgDisLast / 10);

        // Calculate percent change and assign to perAcid variable for pH level
        perAcid = ((avgAcidLast - avgAcidFirst) / avgAcidFirst) * 100;
        // Calculate percent change and assign to perDis variable for CO2 level
        perDis = ((avgDisLast - avgDisFirst) / avgDisFirst) * 100;

        // Print out pH Level label
        writer.println("\n************ pH Levels ************");

        // Print out average pH level for first 10 array elements with labels
        writer.printf("Average (First 10): %.2f\n", avgAcidFirst);
        // Print out average pH level for last 10 array elements with labels
        writer.printf("Average (Last 10): %.2f\n", avgAcidLast);
        // Print out percentage differences between first and last pH levels
        writer.printf("Percent Difference: %.2f\n", perAcid);

        // Print out Dissolved CO2 Level label
        writer.println("\n************ Dissolved CO2 Levels ************");

        // Print out average CO2 level for first 10 array elements with labels
        writer.printf("Average (First 10): %.2f\n", avgDisFirst);
        // Print out average CO2 level for last 10 array elements with labels
        writer.printf("Average (Last 10): %.2f\n", avgDisLast);
        // Print out percentage differences between first and last CO2 levels
        writer.printf("Percent Difference: %.2f\n", perDis);
    }


}