// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import java.util.Locale;

public class StationToInfo
{
    private String kind;
    private String stationName;
    private TimeInfo time;
    private String trainTimetableKey;
    private String trainType;
    
    public String getKind() {
        return this.kind;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public String getTime() {
        return String.format(Locale.getDefault(), "%d:%02d", Integer.valueOf(this.time.getHour()), Integer.valueOf(this.time.getMin()));
    }
    
    public String getTrainTimetableKey() {
        return this.trainTimetableKey;
    }
    
    public String getTrainType() {
        return this.trainType;
    }
    
    public void setKind(final String kind) {
        this.kind = kind;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setTime(final TimeInfo time) {
        this.time = time;
    }
    
    public void setTrainTimetableKey(final String trainTimetableKey) {
        this.trainTimetableKey = trainTimetableKey;
    }
    
    public void setTrainType(final String trainType) {
        this.trainType = trainType;
    }
    
    public class TimeInfo
    {
        private String hour;
        private String min;
        
        public String getHour() {
            return this.hour;
        }
        
        public String getMin() {
            return this.min;
        }
        
        public void setHour(final String hour) {
            this.hour = hour;
        }
        
        public void setMin(final String min) {
            this.min = min;
        }
    }
}
