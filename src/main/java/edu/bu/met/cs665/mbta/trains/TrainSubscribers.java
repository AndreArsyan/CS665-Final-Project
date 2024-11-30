package edu.bu.met.cs665.mbta.trains;

import edu.bu.met.cs665.utils.SubscriberBase;
import edu.bu.met.cs665.mbta.notifications.Notification;
import edu.bu.met.cs665.mbta.notifications.NotificationManager;
import edu.bu.met.cs665.mbta.stations.Station;

public class TrainSubscribers implements SubscriberBase {

    Integer distanceToNotify;
    Station station;
    NotificationManager notification;
    String subscriberName;

    public TrainSubscribers(String subscriberName, Integer distanceToNotify, Station station,
            NotificationManager notification) {
        this.subscriberName = subscriberName;
        this.distanceToNotify = distanceToNotify;
        this.station = station;
        this.notification = notification;
    }

    @Override
    public void execute(Object obj) {
        if (obj instanceof Train) {
            Train train = (Train) obj;
            if (train.getDistanceToNextStation().equals(distanceToNotify)
                    && train.getNextStation().getStationName().equals(station.getStationName())) {
                this.notification.sendMessage("Hi " + this.subscriberName + ", " + train.getName() + " will arrive at "
                        + station.getStationName() + " in " + distanceToNotify + " seconds.");
            }
        }
    }

}
