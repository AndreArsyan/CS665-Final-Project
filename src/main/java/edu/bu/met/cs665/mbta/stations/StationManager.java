package edu.bu.met.cs665.mbta.stations;

import java.util.ArrayList;

public class StationManager {
    private static StationManager instance;
    private ArrayList<Station> stations;
    private ArrayList<Station> expressStations;

    // Public static constants for station names
    public static final String BOSTON_COLLEGE = "Boston College";
    public static final String SOUTH_STREET = "South Street";
    public static final String CHESTNUT_HILL_AVENUE = "Chestnut Hill Avenue";
    public static final String CHISWICK_ROAD = "Chiswick Road";
    public static final String SUTHERLAND_ROAD = "Sutherland Road";
    public static final String WASHINGTON_STREET = "Washington Street";
    public static final String WARREN_STREET = "Warren Street";
    public static final String ALLSTON_STREET = "Allston Street";
    public static final String GRIGGS_STREET = "Griggs Street";
    public static final String HARVARD_AVENUE = "Harvard Avenue";
    public static final String PACKARDS_CORNER = "Packards Corner";
    public static final String BABCOCK_STREET = "Babcock Street";
    public static final String AMORY_STREET = "Amory Street";
    public static final String PLEASANT_STREET = "Pleasant Street";
    public static final String SAINT_PAUL_STREET = "Saint Paul Street";
    public static final String BOSTON_UNIVERSITY_WEST = "Boston University West";
    public static final String BOSTON_UNIVERSITY_CENTRAL = "Boston University Central";
    public static final String BOSTON_UNIVERSITY_EAST = "Boston University East";
    public static final String BLANDFORD_STREET = "Blandford Street";
    public static final String KENMORE = "Kenmore";
    public static final String HYNES_CONVENTION_CENTER = "Hynes Convention Center";
    public static final String COPLEY = "Copley";
    public static final String ARLINGTON = "Arlington";
    public static final String BOYLSTON = "Boylston";
    public static final String PARK_STREET = "Park Street";
    public static final String GOVERNMENT_CENTER = "Government Center";

    public StationManager() {
        setStations();
    }

    private void setStations() {
        this.stations = new ArrayList<>();
        this.expressStations = new ArrayList<>();

        Station bostonCollege = new Station(BOSTON_COLLEGE);
        stations.add(bostonCollege);
        expressStations.add(bostonCollege);

        stations.add(new Station(SOUTH_STREET));
        stations.add(new Station(CHESTNUT_HILL_AVENUE));
        stations.add(new Station(CHISWICK_ROAD));
        stations.add(new Station(SUTHERLAND_ROAD));

        Station washingtonStreet = new Station(WASHINGTON_STREET);
        stations.add(washingtonStreet);
        expressStations.add(washingtonStreet);

        stations.add(new Station(WARREN_STREET));
        stations.add(new Station(ALLSTON_STREET));
        stations.add(new Station(GRIGGS_STREET));

        Station harvardAvenue = new Station(HARVARD_AVENUE);
        stations.add(harvardAvenue);
        expressStations.add(harvardAvenue);

        stations.add(new Station(PACKARDS_CORNER));
        stations.add(new Station(BABCOCK_STREET));
        stations.add(new Station(AMORY_STREET));
        stations.add(new Station(PLEASANT_STREET));
        stations.add(new Station(SAINT_PAUL_STREET));

        Station buCentral = new Station(BOSTON_UNIVERSITY_CENTRAL);
        stations.add(buCentral);
        expressStations.add(buCentral);

        stations.add(new Station(BOSTON_UNIVERSITY_EAST));
        stations.add(new Station(BLANDFORD_STREET));

        Station kenmore = new Station(KENMORE);
        stations.add(kenmore);
        expressStations.add(kenmore);

        stations.add(new Station(HYNES_CONVENTION_CENTER));
        stations.add(new Station(COPLEY));
        stations.add(new Station(ARLINGTON));
        stations.add(new Station(BOYLSTON));

        Station parkStreet = new Station(PARK_STREET);
        stations.add(parkStreet);
        expressStations.add(parkStreet);

        stations.add(new Station(GOVERNMENT_CENTER));
    }

    public static StationManager getInstance() {
        if (instance == null) {
            instance = new StationManager();
        }
        return instance;
    }

    public ArrayList<Station> getAllStations() {
        return stations;
    }

    public ArrayList<Station> getExpressStations() {
        return expressStations;
    }

    public Station getStation(String stationName) {
        for (Station station : stations) {
            if (station.getStationName().equals(stationName)) {
                return station;
            }
        }
        return null;
    }
}