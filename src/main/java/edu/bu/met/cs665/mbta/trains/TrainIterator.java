/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: TrainIterator.java
 * Description: This class is responsible for the Train Iterator.
 */
package edu.bu.met.cs665.mbta.trains;

import edu.bu.met.cs665.utils.Iterator;

public class TrainIterator implements Iterator {
    Train train;

    public TrainIterator(Train train) {
        this.train = train;
    }

    @Override
    public boolean hasNext() {
        // Check if the train is at the last station
        return !train.getPreviousStation().equals(train.getStations().getLast());
    }

    @Override
    public Object next() {
        train.moveForward();
        return null;
    }

}
