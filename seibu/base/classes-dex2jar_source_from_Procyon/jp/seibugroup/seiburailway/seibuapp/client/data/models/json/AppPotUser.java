// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import com.google.gson.annotations.SerializedName;

public class AppPotUser
{
    @SerializedName("appPotPassword")
    private String mApppotPassword;
    @SerializedName("appPotUserId")
    private String mApppotUserId;
    
    public AppPotUser(final String mApppotUserId, final String mApppotPassword) {
        this.mApppotUserId = mApppotUserId;
        this.mApppotPassword = mApppotPassword;
    }
    
    public String getApppotPassword() {
        return this.mApppotPassword;
    }
    
    public String getApppotUserId() {
        return this.mApppotUserId;
    }
}
