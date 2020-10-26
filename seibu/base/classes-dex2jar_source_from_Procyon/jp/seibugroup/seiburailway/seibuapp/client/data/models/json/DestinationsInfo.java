// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.util.List;
import java.io.Serializable;

public class DestinationsInfo implements Serializable
{
    private List<Destination> destination;
    private int offset;
    private int total;
    
    public List<Destination> getDestination() {
        return this.destination;
    }
    
    public int getOffset() {
        return this.offset;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setDestination(final List<Destination> destination) {
        this.destination = destination;
    }
    
    public void setOffset(final int offset) {
        this.offset = offset;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
}
