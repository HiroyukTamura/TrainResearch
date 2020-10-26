// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.xml;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResultStationLine
{
    @SerializedName("lineStationInfoList")
    private List<LineStationInfoWrapper> lines;
    private int offset;
    private int total;
    
    public List<LineStationInfoWrapper> getLines() {
        return this.lines;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setLines(final List<LineStationInfoWrapper> lines) {
        this.lines = lines;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
