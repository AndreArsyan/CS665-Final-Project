/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: Station.java
 * Description: This class is responsible for the methods and attributes of a Station.
 */

package edu.bu.met.cs665.mbta.stations;

/**
 * This is the Station class.
 * This class is responsible for representing a Station.
 */
public class Station {

    private String stationName;
    private Integer nextStationDistance = 0;

    /**
     * Create a Station object using first and last name and birthday.
     *
     * @param stationName name of the station as string
     */
    public Station(String stationName, Integer nextStationDistance) {
        this.stationName = stationName;
        this.nextStationDistance = nextStationDistance;
    }

    /*
     * Getter method for station name.
     */
    public String getStationName() {
        return stationName;
    }

    /*
     * Getter method for next station distance.
     */
    public Integer getNextStationDistance() {
        return nextStationDistance;
    }
}
