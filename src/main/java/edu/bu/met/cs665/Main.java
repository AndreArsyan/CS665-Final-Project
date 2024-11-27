/**
 * DO TDD!!!!!!!!!!!
 * Name: FIRST_NAME LAST_NAME
 * Course: CS-665 Software Designs & Patterns
 * Date: MM/DD/YYYY
 * File Name: Main.java
 * Description: Write a description for this class
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.mbta.trains.ExpressTrain;
import edu.bu.met.cs665.mbta.trains.RegularTrain;

/**
 * This is the Main class.
 */
public class Main {

  /**
   * Main entry point.
   */
  public static void main(String[] args) {
    System.out.println("---------------------------------------------");
    System.out.println("MBTA Nofication System Started");
    System.out.println("---------------------------------------------");

    System.out.println("Creating Stations and Station Manager...");
    StationManager stationManager = new StationManager();

    System.out.println("Creating Trains...");
    RegularTrain regularTrain = new RegularTrain();
    ExpressTrain expressTrain = new ExpressTrain();

  }

}
