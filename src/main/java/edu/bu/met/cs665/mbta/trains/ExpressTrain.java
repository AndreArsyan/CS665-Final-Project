package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.utils.SubscriberBase;

public class ExpressTrain extends Train {
    public ExpressTrain(String name, ArrayList<SubscriberBase> expressSubscribers) {
        super(name, expressSubscribers);
    }

    @Override
    public void setupStations() {
        StationManager stationManager = StationManager.getInstance();
        this.stations = stationManager.getExpressStations();
        this.setPreviousStation(this.stations.get(0));
        this.distanceToNextStation = this.stations.get(0).getNextStationDistance();
    }

    @Override
    public ArrayList<Station> getStations() {
        return this.stations;
    }
}
