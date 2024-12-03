/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: TrainSubscribers.java
 * Description: This class is responsible for the Train Subscribers.
 */
package edu.bu.met.cs665.mbta.trains;

import edu.bu.met.cs665.mbta.notifications.NotificationManager;
import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.utils.SubscriberBase;

public class TrainSubscribers implements SubscriberBase {

    Integer distanceToNotify;
    Station station;
    NotificationManager notification;
    String subscriberName;
    boolean isNotified = false;

    public TrainSubscribers(String subscriberName, Integer distanceToNotify, Station station,
            NotificationManager notification) {
        this.subscriberName = subscriberName;
        this.distanceToNotify = distanceToNotify;
        this.station = station;
        this.notification = notification;
    }

    @Override
    public void notify(Object obj) {
        if (obj instanceof Train) {
            Train train = (Train) obj;
            // Decide if the subscribers should be notified, by the distance to the subscribed station.
            if (train.getDistanceToNextStation().equals(distanceToNotify)
                    && train.getNextStation().getStationName().equals(station.getStationName())) {
                // Check if the subscriber already notified.
                if (!isNotified) {
                    this.notification
                            .sendMessage("Hi " + this.subscriberName + ", " + train.getName() + " will arrive at "
                                    + station.getStationName() + " in " + distanceToNotify + " seconds.");
                    isNotified = true;
                }
            }
        }
    }

}
