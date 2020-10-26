// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;
import java.io.Serializable;

public class RunStatusHistoryWrapper implements Serializable
{
    private List<RunStatusHistoryData> lineStatus;
    private int offset;
    private int total;
    
    public List<RunStatusHistoryData> getLineStatus() {
        return this.lineStatus;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setLineStatus(final List<RunStatusHistoryData> lineStatus) {
        this.lineStatus = lineStatus;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
