// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import java.io.Serializable;

public class PointCheckerDescription implements Serializable
{
    private String hours;
    private String imageUrl;
    private String message;
    private String place;
    private String wayToGo;
    
    public String getHours() {
        return this.hours;
    }
    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public String getWayToGo() {
        return this.wayToGo;
    }
    
    public void setHours(final String hours) {
        this.hours = hours;
    }
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setPlace(final String place) {
        this.place = place;
    }
    
    public void setWayToGo(final String wayToGo) {
        this.wayToGo = wayToGo;
    }
}
