// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class RunStatusHistoryData implements Serializable
{
    private String createdTime;
    private String delayCertificateUrl;
    private String lineId;
    private String lineMapUrl;
    private String lineName;
    private String operation;
    private String operationDetail;
    private String status;
    private String transferMapUrl;
    
    public String getCreatedTime() {
        return this.createdTime;
    }
    
    public String getDelayCertificateUrl() {
        return this.delayCertificateUrl;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineMapUrl() {
        return this.lineMapUrl;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getOperation() {
        return this.operation;
    }
    
    public String getOperationDetail() {
        return this.operationDetail;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getTransferMapUrl() {
        return this.transferMapUrl;
    }
    
    public void setCreatedTime(final String createdTime) {
        this.createdTime = createdTime;
    }
    
    public void setDelayCertificateUrl(final String delayCertificateUrl) {
        this.delayCertificateUrl = delayCertificateUrl;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineMapUrl(final String lineMapUrl) {
        this.lineMapUrl = lineMapUrl;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setOperation(final String operation) {
        this.operation = operation;
    }
    
    public void setOperationDetail(final String operationDetail) {
        this.operationDetail = operationDetail;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setTransferMapUrl(final String transferMapUrl) {
        this.transferMapUrl = transferMapUrl;
    }
}
