// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class CheckInInfo implements Serializable
{
    private String carNo;
    private String getOffStation;
    private String getOnStation;
    private String lineId;
    private CheckInOptions options;
    private String trainNo;
    
    public CheckInInfo() {
    }
    
    public CheckInInfo(final String lineId, final String trainNo, final String getOnStation, final String getOffStation, final String carNo, final CheckInOptions options) {
        this.lineId = lineId;
        this.trainNo = trainNo;
        this.getOnStation = getOnStation;
        this.getOffStation = getOffStation;
        this.carNo = carNo;
        this.options = options;
    }
    
    public String getCarNo() {
        return this.carNo;
    }
    
    public String getGetOffStation() {
        return this.getOffStation;
    }
    
    public String getGetOnStation() {
        return this.getOnStation;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public CheckInOptions getOptions() {
        return this.options;
    }
    
    public String getTrainNo() {
        return this.trainNo;
    }
    
    public void setCarNo(final String carNo) {
        this.carNo = carNo;
    }
    
    public void setGetOffStation(final String getOffStation) {
        this.getOffStation = getOffStation;
    }
    
    public void setGetOnStation(final String getOnStation) {
        this.getOnStation = getOnStation;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setOptions(final CheckInOptions options) {
        this.options = options;
    }
    
    public void setTrainNo(final String trainNo) {
        this.trainNo = trainNo;
    }
}
