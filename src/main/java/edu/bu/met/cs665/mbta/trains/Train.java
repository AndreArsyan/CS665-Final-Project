/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: Train.java
 * Description: This class is responsible for the methods and attributes of a Train.
 */
package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;

/**
 * This is the Train class.
 * This class is responsible for representing a Train.
 */
abstract class Train {
    ArrayList<Station> stations;
    Station lastStation;
}
