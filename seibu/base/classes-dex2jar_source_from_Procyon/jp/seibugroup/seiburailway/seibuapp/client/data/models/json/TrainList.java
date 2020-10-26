// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;

public class TrainList
{
    private List<TrainWrappingData> car;
    private int offset;
    private int total;
    
    public List<TrainWrappingData> getCar() {
        return this.car;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setCar(final List<TrainWrappingData> car) {
        this.car = car;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
