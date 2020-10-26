// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class WifiParsedResult extends ParsedResult
{
    private final String anonymousIdentity;
    private final String eapMethod;
    private final boolean hidden;
    private final String identity;
    private final String networkEncryption;
    private final String password;
    private final String phase2Method;
    private final String ssid;
    
    public WifiParsedResult(final String s, final String s2, final String s3) {
        this(s, s2, s3, false);
    }
    
    public WifiParsedResult(final String s, final String s2, final String s3, final boolean b) {
        this(s, s2, s3, b, null, null, null, null);
    }
    
    public WifiParsedResult(final String networkEncryption, final String ssid, final String password, final boolean hidden, final String identity, final String anonymousIdentity, final String eapMethod, final String phase2Method) {
        super(ParsedResultType.WIFI);
        this.ssid = ssid;
        this.networkEncryption = networkEncryption;
        this.password = password;
        this.hidden = hidden;
        this.identity = identity;
        this.anonymousIdentity = anonymousIdentity;
        this.eapMethod = eapMethod;
        this.phase2Method = phase2Method;
    }
    
    public String getAnonymousIdentity() {
        return this.anonymousIdentity;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(80);
        ParsedResult.maybeAppend(this.ssid, sb);
        ParsedResult.maybeAppend(this.networkEncryption, sb);
        ParsedResult.maybeAppend(this.password, sb);
        ParsedResult.maybeAppend(Boolean.toString(this.hidden), sb);
        return sb.toString();
    }
    
    public String getEapMethod() {
        return this.eapMethod;
    }
    
    public String getIdentity() {
        return this.identity;
    }
    
    public String getNetworkEncryption() {
        return this.networkEncryption;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPhase2Method() {
        return this.phase2Method;
    }
    
    public String getSsid() {
        return this.ssid;
    }
    
    public boolean isHidden() {
        return this.hidden;
    }
}
