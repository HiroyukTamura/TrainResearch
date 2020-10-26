// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.dto;

public class APApp
{
    private String appId;
    private String appVersion;
    
    public APApp() {
    }
    
    public APApp(final String appId, final String appVersion) {
        this.appId = appId;
        this.appVersion = appVersion;
    }
    
    public String getAppId() {
        return this.appId;
    }
    
    public String getAppVersion() {
        return this.appVersion;
    }
    
    public void setAppId(final String appId) {
        this.appId = appId;
    }
    
    public void setAppVersion(final String appVersion) {
        this.appVersion = appVersion;
    }
}
