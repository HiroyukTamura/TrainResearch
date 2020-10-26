// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UsageTrainImageData implements Serializable
{
    @SerializedName("largeImgUrl")
    private int mTrainLargeIconUrl;
    @SerializedName("smallImgUrl")
    private int mTrainSmallIconUrl;
    
    public UsageTrainImageData(final int mTrainLargeIconUrl, final int mTrainSmallIconUrl) {
        this.mTrainLargeIconUrl = mTrainLargeIconUrl;
        this.mTrainSmallIconUrl = mTrainSmallIconUrl;
    }
    
    public int getTrainLargeIconUrl() {
        return this.mTrainLargeIconUrl;
    }
    
    public int getTrainSmallIconUrl() {
        return this.mTrainSmallIconUrl;
    }
    
    public void setTrainLargeIconUrl(final int mTrainLargeIconUrl) {
        this.mTrainLargeIconUrl = mTrainLargeIconUrl;
    }
    
    public void setTrainSmallIconUrl(final int mTrainSmallIconUrl) {
        this.mTrainSmallIconUrl = mTrainSmallIconUrl;
    }
}
