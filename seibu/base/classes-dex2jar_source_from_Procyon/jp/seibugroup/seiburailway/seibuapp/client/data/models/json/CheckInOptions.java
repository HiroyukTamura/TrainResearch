// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class CheckInOptions implements Serializable
{
    private String assistance;
    private String notice;
    private String share;
    
    public CheckInOptions() {
        this.notice = "1";
        this.share = "0";
        this.assistance = "0";
    }
    
    public String getAssistance() {
        return this.assistance;
    }
    
    public String getNotice() {
        return this.notice;
    }
    
    public String getShare() {
        return this.share;
    }
    
    public void setAssistance(final String assistance) {
        this.assistance = assistance;
    }
    
    public void setNotice(final String notice) {
        this.notice = notice;
    }
    
    public void setShare(final String share) {
        this.share = share;
    }
}
