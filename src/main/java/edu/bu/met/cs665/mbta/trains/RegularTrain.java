package edu.bu.met.cs665.mbta.trains;

import java.util.ArrayList;

import edu.bu.met.cs665.mbta.stations.Station;
import edu.bu.met.cs665.mbta.stations.StationManager;

public class RegularTrain extends Train implements TrainState {
    public RegularTrain() {
        setStations();
    }

    @Override
    public void setStations() {
        StationManager stationManager = StationManager.getInstance();
        this.stations = stationManager.getExpressStations();
    }

    @Override
    public ArrayList<Station> getStations() {
        return this.stations;
    }

    @Override
    public Station getLastStation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastStation'");
    }

}
