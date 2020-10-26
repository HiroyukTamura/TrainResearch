// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

public class DayNightTime
{
    private String dayStartTime;
    private String nightStartTime;
    
    public String getDayStartTime() {
        return this.dayStartTime;
    }
    
    public String getNightStartTime() {
        return this.nightStartTime;
    }
    
    public void setDayStartTime(final String dayStartTime) {
        this.dayStartTime = dayStartTime;
    }
    
    public void setNightStartTime(final String nightStartTime) {
        this.nightStartTime = nightStartTime;
    }
}
