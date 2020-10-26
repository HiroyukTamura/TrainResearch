// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import java.io.Serializable;

public class BaseStationLine implements Serializable
{
    static final long serialVersionUID = 234135753480L;
    private String lineId;
    private String stationId;
    private String stationNumber;
    
    public BaseStationLine() {
    }
    
    public BaseStationLine(final String lineId, final String stationId, final String stationNumber) {
        this.lineId = lineId;
        this.stationId = stationId;
        this.stationNumber = stationNumber;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    public String getStationNumber() {
        return this.stationNumber;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    public void setStationNumber(final String stationNumber) {
        this.stationNumber = stationNumber;
    }
}
