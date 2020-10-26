// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.List;

public class TimeTableLineInfoDetail
{
    private String lineName;
    private List<TimeTableStationInfoWrapper> timeTableStationInfoList;
    
    public String getLineName() {
        return this.lineName;
    }
    
    public List<TimeTableStationInfoWrapper> getTimeTableStationInfoList() {
        return this.timeTableStationInfoList;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setTimeTableStationInfoList(final List<TimeTableStationInfoWrapper> timeTableStationInfoList) {
        this.timeTableStationInfoList = timeTableStationInfoList;
    }
}
