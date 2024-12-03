/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: ExpressTrain.java
 * Description: This class is responsible for the Express Train.
 */
package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.utils.SubscriberBase;

/**
 * This is the ExpressTrain class.
 * This class is responsible for representing an Express Train.
 */
public class ExpressTrain extends Train {

    /**
     * Create an Express Train object using Train name and list of subscribers.
     *
     * @param name        name of the station as string
     * @param subscribers list of train subscribers as ArrayList
     */
    public ExpressTrain(String name, ArrayList<SubscriberBase> subscribers) {
        super(name, subscribers);
    }

    /**
     * Setup the stations passed by the Express Train.
     */
    @Override
    public void setupStations() {
        StationManager stationManager = StationManager.getInstance();
        this.stations = stationManager.getExpressStations();
        this.setPreviousStation(this.stations.get(0));
        this.distanceToNextStation = this.stations.get(0).getNextStationDistance();
    }

    /**
     * Get the stations passed by the Express Train.
     *
     * @return list of stations as ArrayList
     */
    @Override
    public ArrayList<Station> getStations() {
        return this.stations;
    }
}
