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
