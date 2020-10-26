// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;
import java.io.Serializable;

public class StationDetailInfo implements Serializable
{
    private List<Departure> departures;
    private StationInfo station;
    
    public StationDetailInfo(final StationInfo station, final List<Departure> departures) {
        this.station = station;
        this.departures = departures;
    }
    
    public List<Departure> getDepartures() {
        return this.departures;
    }
    
    public StationInfo getStation() {
        return this.station;
    }
    
    public void setDepartures(final List<Departure> departures) {
        this.departures = departures;
    }
    
    public void setStation(final StationInfo station) {
        this.station = station;
    }
}
