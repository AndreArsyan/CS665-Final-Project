/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: TrainState.java
 * Description: This class is responsible for the interface of a Train State.
 */
package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;

/**
 * This is the TrainState interface.
 * This class is responsible for representing an interface Train State.
 */
public interface TrainState {
    void setupStations();

    ArrayList<Station> getStations();
}
