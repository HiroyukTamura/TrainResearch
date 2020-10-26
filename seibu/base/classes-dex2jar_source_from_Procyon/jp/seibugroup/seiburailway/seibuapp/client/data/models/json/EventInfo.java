// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

public class EventInfo
{
    private String imageUrl;
    private String title;
    private String toUrl;
    private boolean viaBrowser;
    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getToUrl() {
        return this.toUrl;
    }
    
    public boolean isViaBrowser() {
        return this.viaBrowser;
    }
    
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public void setToUrl(final String toUrl) {
        this.toUrl = toUrl;
    }
    
    public void setViaBrowser(final boolean viaBrowser) {
        this.viaBrowser = viaBrowser;
    }
}
