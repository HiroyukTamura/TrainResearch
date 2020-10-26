// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class CheckInData implements Serializable
{
    private String carNo;
    private String checkinId;
    private String getOffStation;
    private String getOnStation;
    private String lineId;
    private CheckInOptions options;
    private String shareUserId;
    private String status;
    private String trainNo;
    
    public CheckInData(final String shareUserId, final String checkinId, final String lineId, final String trainNo, final String carNo) {
        this.shareUserId = shareUserId;
        this.checkinId = checkinId;
        this.lineId = lineId;
        this.trainNo = trainNo;
        this.carNo = carNo;
    }
    
    public void clear() {
        this.shareUserId = "";
        this.checkinId = "";
        this.status = "";
        this.lineId = "";
        this.trainNo = "";
        this.getOnStation = "";
        this.getOffStation = "";
        this.carNo = "";
        this.options = null;
    }
    
    public String getCarNo() {
        return this.carNo;
    }
    
    public String getCheckinId() {
        return this.checkinId;
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
    
    public String getShareUserId() {
        return this.shareUserId;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getTrainNo() {
        return this.trainNo;
    }
    
    public void setCarNo(final String carNo) {
        this.carNo = carNo;
    }
    
    public void setCheckinId(final String checkinId) {
        this.checkinId = checkinId;
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
    
    public void setShareUserId(final String shareUserId) {
        this.shareUserId = shareUserId;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setTrainNo(final String trainNo) {
        this.trainNo = trainNo;
    }
}
