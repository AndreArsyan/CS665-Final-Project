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

    public Train(String name, ArrayList<SubscriberBase> expressSubscribers) {
        this.name = name;
        setupStations();
        setupSubscribers(expressSubscribers);
    }

    public String getName() {
        return this.name;
    }

    public void setupStations() {
    }

    public void setupSubscribers(ArrayList<SubscriberBase> subscribers) {
        for (SubscriberBase subscriber : subscribers) {
            this.subscribe(subscriber);
        }
    }

    public void setPreviousStation(Station station) {
        this.previousStation = station;
    }

    public Station getPreviousStation() {
        return this.previousStation;
    }

    public Integer getDistanceToNextStation() {
        return this.distanceToNextStation;
    }

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

    @Override
    public void subscribe(SubscriberBase o) {
        this.subscribers.add(o);
    }

    @Override
    public void unsubscribe(SubscriberBase o) {
        this.subscribers.remove(o);
    }

    @Override
    public void notifySubscribers() {
        for (SubscriberBase o : subscribers) {
            o.notify(this);
        }
    }

}
