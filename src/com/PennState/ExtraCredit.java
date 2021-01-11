package com.PennState;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *   Prints out the gross pay, net pay, total gross pay, and total gross pay
 *   of employees in a company based on hours and pay rate. Receives data from
 *   user-inputted data file. Also outputs employees amount/names that work
 *   overtime.
 *
 *   @author Henry Hoffman
 *   @version 11/18/2020
 */

public class ExtraCredit {

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
        // Create string array for...
        // userName, user-inputted name of employee -- maxed at 32 elements
        String[] userName = new String[32];
        // userPay, user-inputted hourly pay rate -- maxed at 32 elements
        double[] userPay = new double[32];
        // userHours, user-inputted hours per person -- maxed at 32 elements
        int[] userHours = new int[32];

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
            readFile(userName, userPay, userHours, fscan);

            // Find the total amount of elements in the parallel arrays
            // When the element at 'counter' index =/= equal 0...
            while (userName[counter] != null) {
                // ...add +1 to counter
                counter++;
            }

            // Call createTable method
            createTable(userName, userPay, userHours, counter);

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
     * @param userName  Names of all employees
     * @param userPay   Hourly pay rates of all employees
     * @param userHours Hours worked of all employees
     * @param fscan     The scanner for the user-inputted file
     */

    public static void readFile(String[] userName,
                                double[] userPay,
                                int[] userHours,
                                Scanner fscan) {

        // Create integer variable for...
        // counter, the amount record(s) that have been read from the file
        int counter = 0;

        // When is still data in the file to be scanned...
        while (fscan.hasNext()) {

            // Assign (1st) number to yearTime array at index 'counter'
            userName[counter] = fscan.next();
            // Assign (2nd) number to acidLevel array at index 'counter'
            userPay[counter] = fscan.nextDouble();
            // Assign (3rd) number to carbonDioxide array at index 'counter'
            userHours[counter] = fscan.nextInt();
            // Add +1 to counter variable
            counter++;

        }
        System.out.println(counter
                + " record(s) have been read from the file.");
    }

    /**
     * Creates a table that outputs the user-inputted names, the gross pay
     * and the net pay associated with that person.
     * Also outputs the total gross pay and total net pay for all workers
     * as well as number/name of workers that have worked overtime (>40 hours)
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param userName  Names of all employees
     * @param userPay   Hourly pay rates of all employees
     * @param userHours Hours worked of all employees
     * @param counter   The total amount of workers
     */

    public static void createTable(String[] userName,
                                   double[] userPay,
                                   int[] userHours,
                                   int counter) {

        // Create double variables for...
        // grossPay, the total amount of money employees receive before taxes
        // netPay, the total amount of money an employee takes after deductions
        // totalGross, the total amount of gross pay for all workers
        // totalNet, the total amount of net pay for all workers
        double grossPay = 0, netPay = 0, totalGross = 0, totalNet = 0;
        // Create integer variables for...
        // overtimeCounter, counters the total amount of overtime workers
        int overtimeCounter = 0;
        // Create string variables for...
        // overtimeNames, the names of each overtime worker
        String overtimeNames = "";

        // Create data table labels
        System.out.printf("\n%-10s %-10s %-10s",
                "NAME", "GROSS PAY", "NET PAY");
        // Print out data table lines
        System.out.printf("\n%-10s %-10s %-10s",
                "--------", "---------", "----------");

        // Create for statement to iterate up to the last element in arrays
        for (int i = 0; i < counter; i++) {

            // Create if statement, when employees work more than 4o hours...
            if (userHours[i] > 40) {
                // ... calculate gross pay using formula, assign to grossPay
                grossPay = 1.5 * userPay[i] * (userHours[i] - 40)
                            + 40 * userPay[i];
                // Add +1 to overtime counter
                overtimeCounter++;
                // Add employee name to overtime names list
                overtimeNames = overtimeNames + " " + userName[i];
            // When employees work less than or equal to 40 hours...
            } else {
                // Assign grossPay to (hours * hourly pay)
                grossPay = userHours[i] * userPay[i];
            }

            // Create if statement, when employees gross pay is more than 65...
            if (grossPay > 65) {
                // Calculate net pay using formula, assign to netPay variable
                netPay = grossPay - (15.00 + (0.45 * (grossPay)));
            // When employees' gross pay is less than or equal to 65...
            } else {
                // netPay and gross pay is the same, assign netPay to value
                netPay = grossPay;
            }

            // Add gross pay of current employee to the total gross pay
            totalGross = totalGross + grossPay;
            // Add net pay of current employees to the total net pay
            totalNet = totalNet + netPay;

            // Print out employee name, gross pay, and net pay
            System.out.printf("\n%-10s $%-10.2f $%-10.2f",
                    userName[i], grossPay, netPay);
        }
        // Print two extra new lines
        System.out.print("\n\n");
        // Print out the total gross pay with label
        System.out.printf("The total amount of the gross pay: $%.2f\n",
                            totalGross);
        // Print out the total net pay with label
        System.out.printf("The total amount of the net pay: $%.2f\n",
                            totalNet);
        // Print out the amount of employees that worked overtime with names
        System.out.println("A total of " + overtimeCounter
                + " employees worked overtime:" + overtimeNames);
    }

}
