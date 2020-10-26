// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.io.Serializable;

public class Departure implements Serializable
{
    @SerializedName("detailPay")
    private List<TrainDetail> detailAddFare;
    @SerializedName("detailNoPay")
    private List<TrainDetail> detailBasic;
    @SerializedName("detail")
    private List<TrainDetail> detailList;
    private String direction;
    private String directionName;
    private String lineId;
    private int sectionNo;
    private int sequenceNo;
    private String stationId;
    @Expose
    private String stationName;
    @Expose
    private String stationNameRoma;
    private String status;
    
    public List<TrainDetail> getDetailAddFare() {
        return this.detailAddFare;
    }
    
    public List<TrainDetail> getDetailBasic() {
        return this.detailBasic;
    }
    
    public List<TrainDetail> getDetailList() {
        return this.detailList;
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public String getDirectionName() {
        return this.directionName;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public int getSectionNo() {
        return this.sectionNo;
    }
    
    public int getSequenceNo() {
        return this.sequenceNo;
    }
    
    public String getStationId() {
        return this.stationId;
    }
    
    public String getStationName() {
        return this.stationName;
    }
    
    public String getStationNameRoma() {
        return this.stationNameRoma;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setDetailAddFare(final List<TrainDetail> detailAddFare) {
        this.detailAddFare = detailAddFare;
    }
    
    public void setDetailBasic(final List<TrainDetail> detailBasic) {
        this.detailBasic = detailBasic;
    }
    
    public void setDetailList(final List<TrainDetail> detailList) {
        this.detailList = detailList;
    }
    
    public void setDirection(final String direction) {
        this.direction = direction;
    }
    
    public void setDirectionName(final String directionName) {
        this.directionName = directionName;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setSectionNo(final int sectionNo) {
        this.sectionNo = sectionNo;
    }
    
    public void setSequenceNo(final int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
    
    public void setStationId(final String stationId) {
        this.stationId = stationId;
    }
    
    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }
    
    public void setStationNameRoma(final String stationNameRoma) {
        this.stationNameRoma = stationNameRoma;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
}
