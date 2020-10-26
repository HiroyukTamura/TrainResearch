// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HomeDialogOptionData implements Serializable
{
    @SerializedName("choose")
    private boolean mChoose;
    @SerializedName("routeName")
    private String mRouteName;
    
    public HomeDialogOptionData(final boolean mChoose, final String mRouteName) {
        this.mChoose = mChoose;
        this.mRouteName = mRouteName;
    }
    
    public String getRouteName() {
        return this.mRouteName;
    }
    
    public boolean isChoose() {
        return this.mChoose;
    }
    
    public void setChoose(final boolean mChoose) {
        this.mChoose = mChoose;
    }
    
    public void setRouteName(final String mRouteName) {
        this.mRouteName = mRouteName;
    }
}
