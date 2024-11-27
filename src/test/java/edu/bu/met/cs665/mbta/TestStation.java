package edu.bu.met.cs665.mbta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.bu.met.cs665.mbta.stations.Station;

public class TestStation {

    public TestStation() {
    }

    @Test
    public void testGetStationName() {
        Station station = new Station("South Station");
        assertEquals("South Station", station.getStationName());
    }

}
