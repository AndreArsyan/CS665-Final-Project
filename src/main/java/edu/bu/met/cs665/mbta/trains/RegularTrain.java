/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: RegularTrain.java
 * Description: This class is responsible for the Regular Train.
 */
package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.utils.SubscriberBase;

/**
 * This is the RegularTrain class.
 * This class is responsible for representing a Regular Train.
 */
public class RegularTrain extends Train {

    /**
     * Create a Regular Train object using Train name and list of subscribers.
     *
     * @param name        name of the station as string
     * @param subscribers list of train subscribers as ArrayList
     */
    public RegularTrain(String name, ArrayList<SubscriberBase> subscribers) {
        super(name, subscribers);
    }

    /**
     * Setup the stations passed by the Regular Train.
     */
    @Override
    public void setupStations() {
        StationManager stationManager = StationManager.getInstance();
        this.stations = stationManager.getAllStations();
        this.setPreviousStation(this.stations.get(0));
        this.distanceToNextStation = this.stations.get(0).getNextStationDistance();
    }

    /**
     * Get the stations passed by the Regular Train.
     *
     * @return list of stations as ArrayList
     */
    @Override
    public ArrayList<Station> getStations() {
        return this.stations;
    }

}
