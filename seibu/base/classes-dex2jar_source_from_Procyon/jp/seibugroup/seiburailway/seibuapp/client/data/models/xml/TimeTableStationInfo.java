// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

public class TimeTableStationInfo
{
    private String groupId;
    private StationCode station;
    
    public String getGroupId() {
        return this.groupId;
    }
    
    public StationCode getStation() {
        return this.station;
    }
    
    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }
    
    public void setStation(final StationCode station) {
        this.station = station;
    }
}
