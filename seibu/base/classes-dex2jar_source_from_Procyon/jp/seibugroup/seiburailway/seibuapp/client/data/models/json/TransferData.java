// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class TransferData implements Serializable
{
    private String company;
    private String companyId;
    private String lineId;
    private String lineName;
    private String packageName;
    private String storeUrlForAndroid;
    private String timeTableURL;
    private String trainPosURL;
    private String url;
    
    public TransferData() {
    }
    
    public TransferData(final String companyId, final String company) {
        this.companyId = companyId;
        this.company = company;
    }
    
    public String getCompany() {
        return this.company;
    }
    
    public String getCompanyId() {
        return this.companyId;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getPackageName() {
        return this.packageName;
    }
    
    public String getStoreUrlForAndroid() {
        return this.storeUrlForAndroid;
    }
    
    public String getTimeTableURL() {
        return this.timeTableURL;
    }
    
    public String getTrainPosURL() {
        return this.trainPosURL;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setCompany(final String company) {
        this.company = company;
    }
    
    public void setCompanyId(final String companyId) {
        this.companyId = companyId;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setPackageName(final String packageName) {
        this.packageName = packageName;
    }
    
    public void setStoreUrlForAndroid(final String storeUrlForAndroid) {
        this.storeUrlForAndroid = storeUrlForAndroid;
    }
    
    public void setTimeTableURL(final String timeTableURL) {
        this.timeTableURL = timeTableURL;
    }
    
    public void setTrainPosURL(final String trainPosURL) {
        this.trainPosURL = trainPosURL;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
}
