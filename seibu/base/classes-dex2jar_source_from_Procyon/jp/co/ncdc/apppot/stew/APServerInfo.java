// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

class APServerInfo
{
    public String appId;
    public String appKey;
    public String appVersion;
    public String checkCharacter;
    public int companyId;
    public String contextPath;
    public String deviceUDID;
    public String hostName;
    public boolean isUseSSL;
    public int portNumber;
    public String scheme;
    
    APServerInfo(final int companyId, String s, final String appKey, final String appVersion, final String hostName, final int portNumber, final String contextPath, final boolean isUseSSL, final String deviceUDID, final String checkCharacter) {
        this.portNumber = 80;
        this.isUseSSL = false;
        this.companyId = companyId;
        this.appId = s;
        this.deviceUDID = deviceUDID;
        this.appVersion = appVersion;
        this.hostName = hostName;
        this.contextPath = contextPath;
        this.portNumber = portNumber;
        this.isUseSSL = isUseSSL;
        if (isUseSSL) {
            s = "https://";
        }
        else {
            s = "http://";
        }
        this.scheme = s;
        this.appKey = appKey;
        this.checkCharacter = checkCharacter;
    }
    
    APHttpClient getHttpClient() {
        return APHttpClient.getInstance();
    }
    
    String getUrl(final String str) {
        final StringBuilder sb = new StringBuilder(this.scheme);
        sb.append(this.hostName);
        if (this.portNumber != 80 && this.portNumber != 0) {
            sb.append(":");
            sb.append(this.portNumber);
        }
        if (!this.contextPath.startsWith("/")) {
            sb.append("/");
        }
        sb.append(this.contextPath);
        sb.append("/api");
        sb.append("/").append(this.companyId);
        sb.append("/").append(this.appId);
        sb.append("/").append(this.appVersion);
        sb.append(str);
        return sb.toString();
    }
}
