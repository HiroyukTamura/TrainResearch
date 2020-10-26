// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.view;

import com.google.gson.annotations.SerializedName;

public class BeaconInfo
{
    @SerializedName("dateTime")
    private String mDateTime;
    @SerializedName("major")
    private String mMajor;
    @SerializedName("minor")
    private String mMinor;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("uuid")
    private String mUuid;
    
    public String getDateTime() {
        return this.mDateTime;
    }
    
    public String getMajor() {
        return this.mMajor;
    }
    
    public String getMinor() {
        return this.mMinor;
    }
    
    public String getUserId() {
        return this.mUserId;
    }
    
    public String getUuid() {
        return this.mUuid;
    }
    
    public void setDateTime(final String mDateTime) {
        this.mDateTime = mDateTime;
    }
    
    public void setMajor(final String mMajor) {
        this.mMajor = mMajor;
    }
    
    public void setMinor(final String mMinor) {
        this.mMinor = mMinor;
    }
    
    public void setUserId(final String mUserId) {
        this.mUserId = mUserId;
    }
    
    public void setUuid(final String mUuid) {
        this.mUuid = mUuid;
    }
}
