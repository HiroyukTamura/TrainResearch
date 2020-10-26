// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import java.io.Serializable;

public class TrainDetail implements Serializable
{
    private String addFareType;
    private String carIconUrl;
    private String carType;
    private Integer delay;
    private String departureTime;
    private String destination;
    private String destinationRomaji;
    private String direction;
    private String endStationId;
    private boolean isLastTrain;
    private boolean isStarting;
    private String pass;
    private String platform;
    private Integer sequenceNo;
    private String status;
    private String trainNo;
    private String trainType;
    
    public String getAddFareType() {
        return this.addFareType;
    }
    
    public String getCarIconUrl() {
        return this.carIconUrl;
    }
    
    public String getCarType() {
        return this.carType;
    }
    
    public Integer getDelay() {
        if (this.delay == null) {
            this.delay = 0;
        }
        return this.delay;
    }
    
    public String getDepartureTime() {
        return this.departureTime;
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public String getDestinationRomaji() {
        return this.destinationRomaji;
    }
    
    public String getDirection() {
        return this.direction;
    }
    
    public String getEndStationId() {
        return this.endStationId;
    }
    
    public String getPass() {
        return this.pass;
    }
    
    public String getPlatform() {
        return this.platform;
    }
    
    public Integer getSequenceNo() {
        return this.sequenceNo;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getTrainNo() {
        return this.trainNo;
    }
    
    public BaseConfig.TrainType getTrainType() {
        return BaseConfig.TrainType.get(this.trainType);
    }
    
    public boolean isLastTrain() {
        return this.isLastTrain;
    }
    
    public boolean isStarting() {
        return this.isStarting;
    }
    
    public void setAddFareType(final String addFareType) {
        this.addFareType = addFareType;
    }
    
    public void setCarIconUrl(final String carIconUrl) {
        this.carIconUrl = carIconUrl;
    }
    
    public void setCarType(final String carType) {
        this.carType = carType;
    }
    
    public void setDelay(final Integer delay) {
        this.delay = delay;
    }
    
    public void setDepartureTime(final String departureTime) {
        this.departureTime = departureTime;
    }
    
    public void setDestination(final String destination) {
        this.destination = destination;
    }
    
    public void setDestinationRomaji(final String destinationRomaji) {
        this.destinationRomaji = destinationRomaji;
    }
    
    public void setDirection(final String direction) {
        this.direction = direction;
    }
    
    public void setEndStationId(final String endStationId) {
        this.endStationId = endStationId;
    }
    
    public void setLastTrain(final boolean isLastTrain) {
        this.isLastTrain = isLastTrain;
    }
    
    public void setPass(final String pass) {
        this.pass = pass;
    }
    
    public void setPlatform(final String platform) {
        this.platform = platform;
    }
    
    public void setSequenceNo(final Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
    
    public void setStarting(final boolean isStarting) {
        this.isStarting = isStarting;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setTrainNo(final String trainNo) {
        this.trainNo = trainNo;
    }
    
    public void setTrainType(final String trainType) {
        this.trainType = trainType;
    }
}
