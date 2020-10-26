// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class TrainWrappingData implements Serializable
{
    private String adTrains;
    private String carNo;
    private String description;
    private String headCarNo;
    private String iconImageUrl;
    private String imageUrl;
    private String imgComment;
    private boolean isRunning;
    private String lineId;
    private String name;
    private String trainNo;
    
    public String getAdTrains() {
        return this.adTrains;
    }
    
    public String getCarNo() {
        return this.carNo;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getHeadCarNo() {
        return this.headCarNo;
    }
    
    public String getIconImageUrl() {
        return this.iconImageUrl;
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public String getImgComment() {
        return this.imgComment;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getTrainNo() {
        return this.trainNo;
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
    
    public void setAdTrains(final String adTrains) {
        this.adTrains = adTrains;
    }
    
    public void setCarNo(final String carNo) {
        this.carNo = carNo;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public void setHeadCarNo(final String headCarNo) {
        this.headCarNo = headCarNo;
    }
    
    public void setIconImageUrl(final String iconImageUrl) {
        this.iconImageUrl = iconImageUrl;
    }
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setImgComment(final String imgComment) {
        this.imgComment = imgComment;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setRunning(final boolean isRunning) {
        this.isRunning = isRunning;
    }
    
    public void setTrainNo(final String trainNo) {
        this.trainNo = trainNo;
    }
}
