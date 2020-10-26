// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;
import java.io.Serializable;

public class RunStatusDataWrapper implements Serializable
{
    private List<RunStatusData> lineStatus;
    private List<RunStatusSpecific> lineStatusSpecific;
    private int offset;
    private int total;
    
    public RunStatusData getLineStatus() {
        if (this.lineStatus.size() > 0) {
            return this.lineStatus.get(0);
        }
        return null;
    }
    
    public List<RunStatusSpecific> getLineStatusSpecific() {
        return this.lineStatusSpecific;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setLineStatus(final List<RunStatusData> lineStatus) {
        this.lineStatus = lineStatus;
    }
    
    public void setLineStatusSpecific(final List<RunStatusSpecific> lineStatusSpecific) {
        this.lineStatusSpecific = lineStatusSpecific;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
