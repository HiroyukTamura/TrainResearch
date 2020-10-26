// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DepartureWrapper
{
    @SerializedName("departure")
    private List<Departure> departures;
    private int offset;
    private int total;
    
    public List<Departure> getDepartures() {
        return this.departures;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setDepartures(final List<Departure> departures) {
        this.departures = departures;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
