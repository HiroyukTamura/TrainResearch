// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import android.content.Context;

public class ResultTimeTableTrainCondition
{
    private DateInfo date;
    private StationFrom stationFrom;
    private StationTo stationTo;
    
    public DateInfo getDate() {
        return this.date;
    }
    
    public StationFrom getStationFrom() {
        return this.stationFrom;
    }
    
    public StationTo getStationTo() {
        return this.stationTo;
    }
    
    public void setDate(final DateInfo date) {
        this.date = date;
    }
    
    public void setStationFrom(final StationFrom stationFrom) {
        this.stationFrom = stationFrom;
    }
    
    public void setStationTo(final StationTo stationTo) {
        this.stationTo = stationTo;
    }
    
    public class DateInfo
    {
        private String day;
        private String gameTypeName;
        private String month;
        private String weekPattern;
        private String year;
        
        public String getFormatDate(final Context context) {
            return String.format(context.getString(2131231111), this.year, this.month, this.day) + "/" + this.weekPattern;
        }
        
        public String getWeekPattern() {
            return this.weekPattern;
        }
    }
    
    public class StationFrom
    {
        private String stationName;
        
        public String getStationName() {
            return this.stationName;
        }
        
        public void setStationName(final String stationName) {
            this.stationName = stationName;
        }
    }
    
    public class StationTo
    {
        private String stationName;
        
        public String getStationName() {
            return this.stationName;
        }
        
        public void setStationName(final String stationName) {
            this.stationName = stationName;
        }
    }
}
