/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: Main.java
 * Description: This class is responsible for the application entry point.
 */

package edu.bu.met.cs665;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.notifications.TrainSubscribers;
import edu.bu.met.cs665.mbta.stations.StationConstants;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.mbta.trains.ExpressTrain;
import edu.bu.met.cs665.mbta.trains.TrainIterator;
import edu.bu.met.cs665.mbta.trains.RegularTrain;
import edu.bu.met.cs665.utils.SubscriberBase;

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

    System.out.println("Registering Subscribers...");
    ArrayList<SubscriberBase> trainSubscribers = new ArrayList<SubscriberBase>();
    trainSubscribers.add(new TrainSubscribers(2, stationManager.getStation(StationConstants.WASHINGTON_STREET)));

    System.out.println("Creating Trains...");
    RegularTrain regularTrain = new RegularTrain("Regular Train #1", trainSubscribers);
    ExpressTrain expressTrain = new ExpressTrain("Express Train #1", trainSubscribers);

    System.out.println("Creating Train Iterator...");
    TrainIterator expressTrainIterator = new TrainIterator(expressTrain);
    TrainIterator regularTrainIterator = new TrainIterator(regularTrain);

    System.out.println("Starting the trains...");
    int seconds = 0;
    Boolean RegularTrainIsMoving = true;
    Boolean ExpressTrainIsMoving = true;
    while (RegularTrainIsMoving || ExpressTrainIsMoving) {
      try {
        System.out.println("======");
        Thread.sleep(1000); // Pause for 1 second
        seconds++;
        System.out.println("Distance passed: " + seconds);

        // Move the Express Trains
        if (expressTrainIterator.hasNext()) {
          expressTrainIterator.next();
        } else {
          // Meaning the train is at the last station
          ExpressTrainIsMoving = false;
        }

        // Move the Regular Trains
        // Give the Express Train a head start 1 second to simulate train not crashing.
        if (seconds > 1) {
          if (regularTrainIterator.hasNext()) {
            regularTrainIterator.next();
          } else {
            // Meaning the train is at the last station
            RegularTrainIsMoving = false;
          }
        }

      } catch (InterruptedException e) {
        break;
      }
    }
    System.out.println("All trains have arrived");
  }
}
