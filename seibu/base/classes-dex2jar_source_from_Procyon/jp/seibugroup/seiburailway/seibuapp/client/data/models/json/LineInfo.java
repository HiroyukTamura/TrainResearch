// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LineInfo implements Serializable
{
    @SerializedName("lineId")
    private String lineId;
    @SerializedName("lineName")
    private String lineName;
    @SerializedName("nextStationL")
    private String nextStationL;
    @SerializedName("nextStationLName")
    private String nextStationLName;
    @SerializedName("nextStationLNo")
    private String nextStationLNo;
    private String nextStationLRomaji;
    @SerializedName("nextStationR")
    private String nextStationR;
    @SerializedName("nextStationRName")
    private String nextStationRName;
    @SerializedName("nextStationRNo")
    private String nextStationRNo;
    private String nextStationRRomaji;
    @SerializedName("stationNo")
    private String stationNo;
    
    public LineInfo(final String lineId, final String lineName) {
        this.lineId = lineId;
        this.lineName = lineName;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getNextStationL() {
        return this.nextStationL;
    }
    
    public String getNextStationLName() {
        return this.nextStationLName;
    }
    
    public String getNextStationLNo() {
        return this.nextStationLNo;
    }
    
    public String getNextStationLRomaji() {
        return this.nextStationLRomaji;
    }
    
    public String getNextStationR() {
        return this.nextStationR;
    }
    
    public String getNextStationRName() {
        return this.nextStationRName;
    }
    
    public String getNextStationRNo() {
        return this.nextStationRNo;
    }
    
    public String getNextStationRRomaji() {
        return this.nextStationRRomaji;
    }
    
    public String getStationNo() {
        return this.stationNo;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setNextStationL(final String nextStationL) {
        this.nextStationL = nextStationL;
    }
    
    public void setNextStationLName(final String nextStationLName) {
        this.nextStationLName = nextStationLName;
    }
    
    public void setNextStationLNo(final String nextStationLNo) {
        this.nextStationLNo = nextStationLNo;
    }
    
    public void setNextStationLRomaji(final String nextStationLRomaji) {
        this.nextStationLRomaji = nextStationLRomaji;
    }
    
    public void setNextStationR(final String nextStationR) {
        this.nextStationR = nextStationR;
    }
    
    public void setNextStationRName(final String nextStationRName) {
        this.nextStationRName = nextStationRName;
    }
    
    public void setNextStationRNo(final String nextStationRNo) {
        this.nextStationRNo = nextStationRNo;
    }
    
    public void setNextStationRRomaji(final String nextStationRRomaji) {
        this.nextStationRRomaji = nextStationRRomaji;
    }
    
    public void setStationNo(final String stationNo) {
        this.stationNo = stationNo;
    }
}
