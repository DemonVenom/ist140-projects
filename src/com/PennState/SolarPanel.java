package com.PennState;

import java.util.Scanner;

/**
 *  Program that calculates how much energy can be harnessed from the sun
 *  from a solar panel in Allentown, PA. The program adjusts calculations
 *  and corrects to the panel’s horizontal solar radiation, tilt, and
 *  day of the year
 *  The user inputs these variables and outputs energy harnessed
 *  on a specific day
 *
 *  @author Henry Hoffman
 *  @version 10/01/2020
 */

public class SolarPanel {
    /**
     * The entry point for the program.
     *
     *  @param args The command-line arguments.
     */

    public static void main(String [] args) {

        // Create a new Scanner object
        Scanner scnr = new Scanner(System.in);

        // Create double variables for...
        // sh , the amount of solar radiation measured horizontally, in kWh/m2
        // beta (β), the angle at which the solar panel is tilted, in degrees
        // sp, solar radiation received on the solar panel over a period
        // theta (θ), the elevation angle θ (in degrees)
        // latitude, the latitude of Allentown, PA
        double sh = 0.0, beta = 0.0, sp = 0.0, theta = 0.0, latitude = 40.6084;
        // Create integer variable for...
        // day, the day of the year (1-365)
        int day = 0;

        // Prompt the user to input solar radiation
        System.out.print("Please enter the amount of horizontal"
                            + " solar radiation (kWh/m^2): ");
        // Put user input into variable
        sh = scnr.nextDouble();
        // Echo print the user input
        System.out.printf("You entered %.3f kWh/m^2.\n", sh);

        // Prompt the user to input angle at which solar panel is tilted
        System.out.print("\nPlease enter the angle of tilt, in degrees: ");
        // Put user input into variable
        beta = scnr.nextDouble();
        // Echo print the user input
        System.out.printf("You entered %.3f degrees.\n", beta);

        // Prompt the user to input the day of the year
        System.out.print("\nPlease enter the day (1-365): ");
        // Put user input into variable
        day = scnr.nextInt();
        // Echo print the user input
        System.out.print("You entered day " + day + ".\n");

        // Calculate the elevation angle, call method
        theta = computeElevationAngle(latitude, day);
        // Calculate the solar radiation, call method
        sp = computeSp(sh, theta, beta);

        // Print out sp
        System.out.printf("\nSp: %.3f kWh/m^2.", sp);
    }

    /**
     * Computes the elevation angle for a PV solar panel, given the
     * latitude (<code>latitude</code>) and the day of the year
     * (<code>day</code>).
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param latitude  The latitude of the PV solar panel.
     * @param day The day of the year (1-365).
     * @return The elevation angle for the PV solar panel.
     *
     */

    public static double computeElevationAngle(double latitude, double day) {
        // Declare storage for the return value...
        double theta = 0.0;

        // compute the declination...
        theta = 23.45 * Math.sin(Math.toRadians((360.0/365.0) * (284 + day)));

        // Compute the elevation angle theta....
        theta = (90 - latitude) + theta;

        // Return the angle...
        return theta;
    }

    /**
     * Computes the radiation received by a PV solar panel, given the
     * horizontal radiation (<code>sh</code>), the elevation angle
     * (<code>theta</code>), and the tilt angle (<code>beta</code>).
     *
     * It is assumed that all parameters have previously been assigned
     * relevant values prior to calling the method.
     *
     * @param sh  The horizontal radiation value.
     * @param theta The angle of elevation, in degrees.
     * @param beta The angle of tilt, in degrees.
     * @return The radiation received by a PV solar panel.
     *
     */

    public static double computeSp(double sh, double theta, double beta) {
        // Declare storage for the return value...
        double sp = 0.0;

        // Compute the radiation incident....
        sp = (sh * Math.sin( Math.toRadians(theta + beta)))
                / Math.sin(Math.toRadians(theta));

        // Return the amount...
        return sp;
    }
}