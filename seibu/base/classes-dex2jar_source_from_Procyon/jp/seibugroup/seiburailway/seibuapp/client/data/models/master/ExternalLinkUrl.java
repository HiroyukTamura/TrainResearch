// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.google.gson.annotations.SerializedName;

public class ExternalLinkUrl
{
    @SerializedName("externalLinkName")
    private String linkName;
    @SerializedName("externalLinkNo")
    private String linkNo;
    private String url;
    
    public ExternalLinkUrl() {
    }
    
    public ExternalLinkUrl(final String linkNo, final String linkName, final String url) {
        this.linkNo = linkNo;
        this.linkName = linkName;
        this.url = url;
    }
    
    public String getLinkName() {
        return this.linkName;
    }
    
    public String getLinkNo() {
        return this.linkNo;
    }
    
    public String getUrl() {
        return this.url;
    }
    
    public void setLinkName(final String linkName) {
        this.linkName = linkName;
    }
    
    public void setLinkNo(final String linkNo) {
        this.linkNo = linkNo;
    }
    
    public void setUrl(final String url) {
        this.url = url;
    }
}
