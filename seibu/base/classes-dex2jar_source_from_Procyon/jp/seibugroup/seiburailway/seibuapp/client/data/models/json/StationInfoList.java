// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;

public class StationInfoList
{
    private int offset;
    private List<StationInfo> station;
    private int total;
    
    public int getOffset() {
        return this.offset;
    }
    
    public List<StationInfo> getStation() {
        return this.station;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setStation(final List<StationInfo> station) {
        this.station = station;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
