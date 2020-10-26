// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OnlineTrains
{
    private int offset;
    private int total;
    @SerializedName("train")
    private List<TrainInfo> trains;
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public List<TrainInfo> getTrains() {
        return this.trains;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public void setTrains(final List<TrainInfo> trains) {
        this.trains = trains;
    }
}
