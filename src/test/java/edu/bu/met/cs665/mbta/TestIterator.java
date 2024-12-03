package edu.bu.met.cs665.mbta;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.bu.met.cs665.mbta.trains.RegularTrain;
import edu.bu.met.cs665.mbta.trains.TrainIterator;
import edu.bu.met.cs665.utils.SubscriberBase;

public class TestIterator {

    public TestIterator() {
    }

    @Test
    public void hasNext() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        TrainIterator trainIterator = new TrainIterator(regularTrain);
        assertTrue(trainIterator.hasNext());
    }

    @Test
    public void next() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        TrainIterator trainIterator = new TrainIterator(regularTrain);
        assertTrue(trainIterator.next() == null);
    }
}
