package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.SubscriberBase;
import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.trains.Train;

public class TrainSubscribers implements SubscriberBase {

    Integer distanceToNotify;
    Station station;

    public TrainSubscribers(Integer distanceToNotify, Station station) {
        this.distanceToNotify = distanceToNotify;
        this.station = station;
    }

    @Override
    public void execute(Object obj) {
        if (obj instanceof Train) {
            Train train = (Train) obj;
            if (train.getDistanceToNextStation() == distanceToNotify
                    && train.getNextStation().getStationName() == station.getStationName()) {
                System.out.println(train.getName() + " is approaching to " + station.getStationName());
            }
        }
    }

}
