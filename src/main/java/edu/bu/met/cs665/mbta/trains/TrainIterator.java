package edu.bu.met.cs665.mbta.trains;

import edu.bu.met.cs665.utils.Iterator;

public class TrainIterator implements Iterator {
    Train train;

    public TrainIterator(Train train) {
        this.train = train;
    }

    @Override
    public boolean hasNext() {
        if (train.getPreviousStation() == train.getStations().getLast()) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        train.moveForward();
        return null;
    }

}
