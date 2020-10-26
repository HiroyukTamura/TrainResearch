// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.view;

public class AppPotGetUserParam
{
    private String appId;
    private String appKey;
    private String appVersion;
    
    public AppPotGetUserParam(final String appId, final String appVersion, final String appKey) {
        this.appId = appId;
        this.appVersion = appVersion;
        this.appKey = appKey;
    }
    
    public String getAppId() {
        return this.appId;
    }
    
    public String getAppKey() {
        return this.appKey;
    }
    
    public String getAppVersion() {
        return this.appVersion;
    }
    
    public void setAppId(final String appId) {
        this.appId = appId;
    }
    
    public void setAppKey(final String appKey) {
        this.appKey = appKey;
    }
    
    public void setAppVersion(final String appVersion) {
        this.appVersion = appVersion;
    }
}
