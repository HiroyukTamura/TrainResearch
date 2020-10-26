// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

public class ArrivalDepartureTime
{
    private TimeData time;
    private String type;
    
    public TimeData getTime() {
        return this.time;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setTime(final TimeData time) {
        this.time = time;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public class TimeData
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
