// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.util.DateUtils;

public class TimeTableInfo
{
    private TimeTableDate date;
    private DirectionInfo direction;
    private String gameTypeName;
    private LineInfo line;
    private StationInfo station;
    private String weekPattern;
    private String weekPatternCode;
    
    public TimeTableDate getDate() {
        return this.date;
    }
    
    public DirectionInfo getDirection() {
        return this.direction;
    }
    
    public String getGameTypeName() {
        return this.gameTypeName;
    }
    
    public LineInfo getLine() {
        return this.line;
    }
    
    public StationInfo getStation() {
        return this.station;
    }
    
    public String getWeekPattern() {
        return this.weekPattern;
    }
    
    public String getWeekPatternCode() {
        return this.weekPatternCode;
    }
    
    public void setDate(final TimeTableDate date) {
        this.date = date;
    }
    
    public void setDirection(final DirectionInfo direction) {
        this.direction = direction;
    }
    
    public void setGameTypeName(final String gameTypeName) {
        this.gameTypeName = gameTypeName;
    }
    
    public void setLine(final LineInfo line) {
        this.line = line;
    }
    
    public void setStation(final StationInfo station) {
        this.station = station;
    }
    
    public void setWeekPattern(final String weekPattern) {
        this.weekPattern = weekPattern;
    }
    
    public void setWeekPatternCode(final String weekPatternCode) {
        this.weekPatternCode = weekPatternCode;
    }
    
    public class DirectionInfo
    {
        private String code;
        private String directionName;
        
        public String getCode() {
            return this.code;
        }
        
        public String getDirectionName() {
            return this.directionName;
        }
        
        public void setCode(final String code) {
            this.code = code;
        }
        
        public void setDirectionName(final String directionName) {
            this.directionName = directionName;
        }
    }
    
    public class LineInfo
    {
        private String lineId;
        private String lineName;
        
        public String getLineId() {
            return this.lineId;
        }
        
        public String getLineName() {
            return this.lineName;
        }
        
        public void setLineId(final String lineId) {
            this.lineId = lineId;
        }
        
        public void setLineName(final String lineName) {
            this.lineName = lineName;
        }
    }
    
    public class StationInfo
    {
        private String stationId;
        private String stationName;
        
        public String getStationId() {
            return this.stationId;
        }
        
        public String getStationName() {
            return this.stationName;
        }
        
        public void setStationId(final String stationId) {
            this.stationId = stationId;
        }
        
        public void setStationName(final String stationName) {
            this.stationName = stationName;
        }
    }
    
    public class TimeTableDate
    {
        private String day;
        private String month;
        private String year;
        
        public String getFormatString() {
            return DateUtils.getDateYYYYMMDD(this.year + "/" + this.month + "/" + this.day);
        }
        
        public String toString(final Context context) {
            return String.format(context.getString(2131231111), this.year, this.month, this.day);
        }
    }
}
