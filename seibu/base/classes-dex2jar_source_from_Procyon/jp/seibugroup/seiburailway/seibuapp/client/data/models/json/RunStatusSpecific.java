// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class RunStatusSpecific implements Serializable
{
    private String cause;
    private int delay;
    private String detail;
    private boolean isCellOpen;
    private String lineId;
    private String lineName;
    private String status;
    private String statusName;
    private String statusText;
    
    public RunStatusSpecific(final String lineId, final String lineName) {
        this.lineId = lineId;
        this.lineName = lineName;
    }
    
    public void copy(final RunStatusSpecific runStatusSpecific) {
        if (runStatusSpecific != null) {
            this.status = runStatusSpecific.getStatus();
            this.statusText = runStatusSpecific.getStatusText();
            this.statusName = runStatusSpecific.getStatusName();
            this.cause = runStatusSpecific.getCause();
            this.delay = runStatusSpecific.getDelay();
            this.detail = runStatusSpecific.getDetail();
        }
    }
    
    public String getCause() {
        return this.cause;
    }
    
    public int getDelay() {
        return this.delay;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public String getLineId() {
        return this.lineId;
    }
    
    public String getLineName() {
        return this.lineName;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String getStatusName() {
        return this.statusName;
    }
    
    public String getStatusText() {
        return this.statusText;
    }
    
    public boolean isCellOpen() {
        return this.isCellOpen;
    }
    
    public void setCause(final String cause) {
        this.cause = cause;
    }
    
    public void setCellOpen(final boolean isCellOpen) {
        this.isCellOpen = isCellOpen;
    }
    
    public void setDelay(final int delay) {
        this.delay = delay;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }
    
    public void setLineId(final String lineId) {
        this.lineId = lineId;
    }
    
    public void setLineName(final String lineName) {
        this.lineName = lineName;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public void setStatusName(final String statusName) {
        this.statusName = statusName;
    }
    
    public void setStatusText(final String statusText) {
        this.statusText = statusText;
    }
}
