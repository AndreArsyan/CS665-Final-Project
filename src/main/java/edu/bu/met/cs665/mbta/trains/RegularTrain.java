package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;
import edu.bu.met.cs665.utils.SubscriberBase;

public class RegularTrain extends Train {
    public RegularTrain(String name, ArrayList<SubscriberBase> subscribers) {
        super(name, subscribers);
    }

    @Override
    public void setupStations() {
        StationManager stationManager = StationManager.getInstance();
        this.stations = stationManager.getAllStations();
        this.setPreviousStation(this.stations.get(0));
        this.distanceToNextStation = this.stations.get(0).getNextStationDistance();
    }

    @Override
    public ArrayList<Station> getStations() {
        return this.stations;
    }

}
