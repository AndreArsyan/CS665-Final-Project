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

    /**
     * Create a Station object using first and last name and birthday.
     *
     * @param stationName name of the station as string
     */
    public Station(String stationName) {
        this.stationName = stationName;
    }

    /*
     * Getter method for station name.
     */
    public String getStationName() {
        return stationName;
    }

}
