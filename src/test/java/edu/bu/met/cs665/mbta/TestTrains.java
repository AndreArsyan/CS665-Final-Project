package edu.bu.met.cs665.mbta;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import edu.bu.met.cs665.mbta.stations.Station;
import static edu.bu.met.cs665.mbta.stations.StationConstants.BOSTON_COLLEGE;
import static edu.bu.met.cs665.mbta.stations.StationConstants.SOUTH_STREET;
import static edu.bu.met.cs665.mbta.stations.StationConstants.WASHINGTON_STREET;
import edu.bu.met.cs665.mbta.trains.ExpressTrain;
import edu.bu.met.cs665.mbta.trains.RegularTrain;
import edu.bu.met.cs665.utils.SubscriberBase;

public class TestTrains {

    public TestTrains() {
    }

    @Test
    public void getStationsRegularTrain() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        assertEquals(25, regularTrain.getStations().size());
    }

    @Test
    public void getStationsExpressTrain() {
        ExpressTrain expressTrain = new ExpressTrain("Train 1", new ArrayList<SubscriberBase>());
        expressTrain.setupStations();
        assertEquals(6, expressTrain.getStations().size());
    }

    @Test
    public void getNameRegularTrain() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        assertEquals("Regular Train 1", regularTrain.getName());
    }

    @Test
    public void getNameExpressTrain() {
        ExpressTrain expressTrain = new ExpressTrain("Express Train 1", new ArrayList<SubscriberBase>());
        assertEquals("Express Train 1", expressTrain.getName());
    }

    @Test
    public void getPreviousStationRegularTrain() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        assertEquals(new Station(BOSTON_COLLEGE, 4).getStationName(),
                regularTrain.getPreviousStation().getStationName());
    }

    @Test
    public void getPreviousStationExpressTrain() {
        ExpressTrain expressTrain = new ExpressTrain("Express Train 1", new ArrayList<SubscriberBase>());
        expressTrain.setupStations();
        assertEquals(new Station(BOSTON_COLLEGE, 4).getStationName(),
                expressTrain.getPreviousStation().getStationName());
    }

    @Test
    public void getDistanceToNextStationRegularTrain() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        assertEquals(4, regularTrain.getDistanceToNextStation().intValue());
    }

    @Test
    public void getDistanceToNextStationExpressTrain() {
        ExpressTrain expressTrain = new ExpressTrain("Express Train 1", new ArrayList<SubscriberBase>());
        expressTrain.setupStations();
        assertEquals(4, expressTrain.getDistanceToNextStation().intValue());
    }

    @Test
    public void getNextStationRegularTrain() {
        RegularTrain regularTrain = new RegularTrain("Regular Train 1", new ArrayList<SubscriberBase>());
        regularTrain.setupStations();
        assertEquals(SOUTH_STREET, regularTrain.getNextStation().getStationName());
    }

    @Test
    public void getNextStationExpressTrain() {
        ExpressTrain expressTrain = new ExpressTrain("Express Train 1", new ArrayList<SubscriberBase>());
        expressTrain.setupStations();
        assertEquals(WASHINGTON_STREET, expressTrain.getNextStation().getStationName());
    }
}
