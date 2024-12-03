/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: StationManager.java
 * Description: This class is responsible for the Station Manager.
 */
package edu.bu.met.cs665.mbta.stations;

import java.util.ArrayList;

import static edu.bu.met.cs665.mbta.stations.StationConstants.*;

/**
 * This is the StationManager class.
 * This class is responsible for representing a Station Manager.
 */
public class StationManager {
    private static StationManager instance;
    private ArrayList<Station> stations;
    private ArrayList<Station> expressStations;

    /**
     * Create a StationManager object.
     */
    public StationManager() {
        setStations();
    }

    /**
     * Create Stations object.
     * This method is responsible for creating all the stations.
     */
    private void setStations() {
        this.stations = new ArrayList<>();
        this.expressStations = new ArrayList<>();

        Station bostonCollege = new Station(BOSTON_COLLEGE, 4);
        stations.add(bostonCollege);
        expressStations.add(bostonCollege);

        stations.add(new Station(SOUTH_STREET, 4));
        stations.add(new Station(CHESTNUT_HILL_AVENUE, 3));
        stations.add(new Station(CHISWICK_ROAD, 5));
        stations.add(new Station(SUTHERLAND_ROAD, 3));

        Station washingtonStreet = new Station(WASHINGTON_STREET, 5);
        stations.add(washingtonStreet);
        expressStations.add(washingtonStreet);

        stations.add(new Station(WARREN_STREET, 4));
        stations.add(new Station(ALLSTON_STREET, 5));
        stations.add(new Station(GRIGGS_STREET, 3));

        Station harvardAvenue = new Station(HARVARD_AVENUE, 3);
        stations.add(harvardAvenue);
        expressStations.add(harvardAvenue);

        stations.add(new Station(PACKARDS_CORNER, 4));
        stations.add(new Station(BABCOCK_STREET, 3));
        stations.add(new Station(AMORY_STREET, 3));
        stations.add(new Station(PLEASANT_STREET, 3));
        stations.add(new Station(SAINT_PAUL_STREET, 4));

        Station buCentral = new Station(BOSTON_UNIVERSITY_CENTRAL, 5);
        stations.add(buCentral);
        expressStations.add(buCentral);

        stations.add(new Station(BOSTON_UNIVERSITY_EAST, 3));
        stations.add(new Station(BLANDFORD_STREET, 5));

        Station kenmore = new Station(KENMORE, 4);
        stations.add(kenmore);
        expressStations.add(kenmore);

        stations.add(new Station(HYNES_CONVENTION_CENTER, 4));
        stations.add(new Station(COPLEY, 3));
        stations.add(new Station(ARLINGTON, 5));
        stations.add(new Station(BOYLSTON, 5));
        stations.add(new Station(PARK_STREET, 4));

        Station governmentCenter = new Station(GOVERNMENT_CENTER, 0);
        stations.add(governmentCenter);
        expressStations.add(governmentCenter);
    }

    /**
     * Method to get the instance of the StationManager.
     * 
     * @return instance of the StationManager
     */
    public static StationManager getInstance() {
        if (instance == null) {
            instance = new StationManager();
        }
        return instance;
    }

    /**
     * Method to get all stations.
     * 
     * @return list of all stations
     */
    public ArrayList<Station> getAllStations() {
        return stations;
    }

    /**
     * Method to get all stations for the express train.
     * 
     * @return list of all express stations
     */
    public ArrayList<Station> getExpressStations() {
        return expressStations;
    }

    /**
     * Method to get a station by name.
     * 
     * @param stationName name of the station
     * @return station object
     */
    public Station getStation(String stationName) {
        for (Station station : stations) {
            if (station.getStationName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}