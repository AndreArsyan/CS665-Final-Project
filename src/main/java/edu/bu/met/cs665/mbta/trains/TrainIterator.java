/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: TrainIterator.java
 * Description: This class is responsible for the Train Iterator.
 */
package edu.bu.met.cs665.mbta.trains;

import edu.bu.met.cs665.utils.Iterator;

/**
 * This is the Train Iterator class.
 * This class is responsible for representing a Train Iterator.
 */
public class TrainIterator implements Iterator {
    Train train;

    /**
     * Create a Train Iterator object of the Train object.
     *
     * @param train train object to be iterated
     */
    public TrainIterator(Train train) {
        this.train = train;
    }

    /**
     * Check if the train has next station.
     *
     * @return boolean value
     */
    @Override
    public boolean hasNext() {
        // Check if the train is at the last station
        return !train.getPreviousStation().equals(train.getStations().getLast());
    }

    /**
     * Move the train to the next distance.
     *
     * nullify the return value.
     */
    @Override
    public Object next() {
        train.moveForward();
        return null;
    }

}
