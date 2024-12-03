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
import edu.bu.met.cs665.utils.PublisherBase;
import edu.bu.met.cs665.utils.SubscriberBase;

/**
 * This is the Train class.
 * This class is responsible for representing a Train.
 */
public abstract class Train implements PublisherBase, TrainState {
    protected ArrayList<Station> stations;
    private String name;
    private Station previousStation;
    private ArrayList<SubscriberBase> subscribers = new ArrayList<SubscriberBase>();
    protected Integer distanceToNextStation = 0;

    /**
     * Create a Train object using Train name and list of subscribers.
     *
     * @param name        name of the station as string
     * @param subscribers list of train subscribers as ArrayList
     */
    public Train(String name, ArrayList<SubscriberBase> subscribers) {
        this.name = name;
        setupStations();
        setupSubscribers(subscribers);
    }

    /**
     * Get the name of the Train.
     *
     * @return name of the Train as string
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setup the stations passed by the Train.
     */
    public void setupStations() {
    }

    /**
     * Set the list of subscribers for the Train.
     *
     * @param subscribers list of this train subscribers as ArrayList
     */
    public void setupSubscribers(ArrayList<SubscriberBase> subscribers) {
        for (SubscriberBase subscriber : subscribers) {
            this.subscribe(subscriber);
        }
    }

    /**
     * Set the last stations passed by the Train.
     *
     * @param station last station as Station
     */
    public void setPreviousStation(Station station) {
        this.previousStation = station;
    }

    /**
     * Get the last stations passed by the Train.
     *
     * @return last station as Station
     */
    public Station getPreviousStation() {
        return this.previousStation;
    }

    /**
     * Get the distance to the next station.
     *
     * @return distance to the next station as integer
     */
    public Integer getDistanceToNextStation() {
        return this.distanceToNextStation;
    }

    /**
     * Get the next station.
     *
     * @return Station object
     */
    public Station getNextStation() {
        for (Station station : this.stations) {
            // If this is last station, return the last station
            if (this.previousStation == this.stations.getLast()) {
                return this.previousStation;
            }
            // If there is a match, return the next station
            if (this.previousStation.getStationName() == station.getStationName()) {
                return this.stations.get(this.stations.indexOf(station) + 1);
            }
        }
        return null;
    }

    /**
     * Move the train forward 1 distance.
     */
    public void moveForward() {
        this.distanceToNextStation -= 1;
        if (this.distanceToNextStation == 0) { // If the train has arrived at the next station
            this.previousStation = this.getNextStation();
            this.distanceToNextStation = this.previousStation.getNextStationDistance();
            System.out
                    .print(this.getName() + " Train has arrived at " + this.previousStation.getStationName() + ". ");
        }
        notifySubscribers();
    }

    /**
     * Add a subscriber to the list of subscribers.
     *
     * @param o subscriber as SubscriberBase
     */
    @Override
    public void subscribe(SubscriberBase o) {
        this.subscribers.add(o);
    }

    /**
     * Remove a subscriber from the list of subscribers.
     *
     * @param o subscriber as SubscriberBase
     */
    @Override
    public void unsubscribe(SubscriberBase o) {
        this.subscribers.remove(o);
    }

    /**
     * Notify all subscribers.
     */
    @Override
    public void notifySubscribers() {
        for (SubscriberBase o : subscribers) {
            o.notify(this);
        }
    }

}
