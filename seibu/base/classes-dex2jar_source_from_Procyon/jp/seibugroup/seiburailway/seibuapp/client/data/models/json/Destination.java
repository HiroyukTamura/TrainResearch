// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class Destination implements Serializable
{
    private String directionName;
    private String displayTime;
    private String estimatedTime;
    private boolean isAvailable;
    private boolean isDelay;
    private String lineId;
    private String lineName;
    private String scheduledTime;
    private String stationId;
    private String stationName;
    private String stopKbn;
    private String transitKbn;
    
    public String getDirectionName() {
        return this.directionName;
    }
    
    public String getDisplayTime() {
        return this.displayTime;
    }
    
    public String getEstimatedTime() {
        return this.estimatedTime;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getScheduledTime() {
        return this.scheduledTime;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public String getStopKbn() {
        return this.stopKbn;
    }
    
    public String getTransitKbn() {
        return this.transitKbn;
    }
    
    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    public boolean isDelay() {
        return this.isDelay;
    }
    
    public void setAvailable(final boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public void setDelay(final boolean isDelay) {
        this.isDelay = isDelay;
    }
    
    public void setDirectionName(final String directionName) {
        this.directionName = directionName;
    }
    
    public void setDisplayTime(final String displayTime) {
        this.displayTime = displayTime;
    }
    
    public void setEstimatedTime(final String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setScheduledTime(final String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setStopKbn(final String stopKbn) {
        this.stopKbn = stopKbn;
    }
    
    public void setTransitKbn(final String transitKbn) {
        this.transitKbn = transitKbn;
    }
}
