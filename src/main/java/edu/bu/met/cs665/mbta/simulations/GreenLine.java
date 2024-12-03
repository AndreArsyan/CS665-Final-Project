/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: GreenLine.java
 * Description: This class is responsible for the Simulation of the Green Line.
 */
package edu.bu.met.cs665.mbta.simulations;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.notifications.AppNotification;
import edu.bu.met.cs665.mbta.notifications.EmailNotification;
import edu.bu.met.cs665.mbta.notifications.TextNotification;
import edu.bu.met.cs665.mbta.stations.StationConstants;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.mbta.trains.ExpressTrain;
import edu.bu.met.cs665.mbta.trains.RegularTrain;
import edu.bu.met.cs665.mbta.trains.TrainIterator;
import edu.bu.met.cs665.mbta.trains.TrainSubscribers;
import edu.bu.met.cs665.utils.SubscriberBase;
import edu.bu.met.cs665.utils.ThreadManager;

/**
 * This is the GreenLine class.
 * This class is responsible for representing a GreenLine simulation.
 */
public class GreenLine {
    StationManager stationManager;
    AppNotification appNotification;
    EmailNotification emailNotification;
    TextNotification textNotification;
    ArrayList<SubscriberBase> trainSubscribers;
    RegularTrain regularTrain;
    ExpressTrain expressTrain;
    TrainIterator expressTrainIterator;
    TrainIterator regularTrainIterator;
    ThreadManager threadManager;

    /**
     * Create an GreenLine object.
     *
     * @param threadManager Thread manager object to enable sending notifications
     *                      using Threads.
     */
    public GreenLine(ThreadManager threadManager) {
        System.out.println("---------------------------------------------");
        System.out.println("MBTA Simulation System Started");
        System.out.println("[Green Line - B Branch]");
        System.out.println("---------------------------------------------");

        System.out.println("Creating Stations and Station Manager...");
        stationManager = new StationManager();

        System.out.println("Creating Notification System...");
        this.threadManager = threadManager;
        appNotification = new AppNotification(this.threadManager);
        emailNotification = new EmailNotification(this.threadManager);
        textNotification = new TextNotification(this.threadManager);

        System.out.println("Registering Subscribers...");
        trainSubscribers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            trainSubscribers
                    .add(new TrainSubscribers("Rider " + i, 2,
                            stationManager.getStation(StationConstants.WASHINGTON_STREET),
                            appNotification));
        }

        for (int i = 1; i <= 10; i++) {
            trainSubscribers
                    .add(new TrainSubscribers("Student " + i, 2,
                            stationManager.getStation(StationConstants.BOSTON_UNIVERSITY_CENTRAL),
                            textNotification));
        }

        for (int i = 1; i <= 10; i++) {
            trainSubscribers
                    .add(new TrainSubscribers("Worker " + i, 2,
                            stationManager.getStation(StationConstants.COPLEY),
                            textNotification));
        }

        System.out.println("Creating Trains...");
        regularTrain = new RegularTrain("Regular Train #1", trainSubscribers);
        expressTrain = new ExpressTrain("Express Train #1", trainSubscribers);

        System.out.println("Creating Train Iterator...");
        expressTrainIterator = new TrainIterator(expressTrain);
        regularTrainIterator = new TrainIterator(regularTrain);

    }

    /*
     * Method to start the simulation.
     */
    public void start() {
        System.out.println("Starting the trains...");
        int seconds = 0;
        Boolean regularTrainIsMoving = true;
        Boolean expressTrainIsMoving = true;
        while (regularTrainIsMoving || expressTrainIsMoving) {
            try {
                Thread.sleep(1000); // Train is moving per second.
                seconds++;
                System.out.print("\n Distance passed: " + seconds + " | Notification sent: "
                        + threadManager.getCompletedTaskCount().get("completed") + "/"
                        + threadManager.getCompletedTaskCount().get("total") + " ");

                // Move the Express Trains
                if (expressTrainIterator.hasNext()) {
                    expressTrainIterator.next();
                } else {
                    // Meaning the train is at the last station
                    expressTrainIsMoving = false;
                }

                // Move the Regular Trains after giving the Express Train a 1 second head start.
                if (seconds > 1) {
                    if (regularTrainIterator.hasNext()) {
                        regularTrainIterator.next();
                    } else {
                        // Meaning the train is at the last station
                        regularTrainIsMoving = false;
                    }
                }

                // Check if all trains have arrived
                if (!regularTrainIsMoving && !expressTrainIsMoving) {
                    System.out.println("All trains have arrived");
                    break;
                }

            } catch (InterruptedException e) {
                // Clean up thread for the 1s delay
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
