// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class TelParsedResult extends ParsedResult
{
    private final String number;
    private final String telURI;
    private final String title;
    
    public TelParsedResult(final String number, final String telURI, final String title) {
        super(ParsedResultType.TEL);
        this.number = number;
        this.telURI = telURI;
        this.title = title;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(20);
        ParsedResult.maybeAppend(this.number, sb);
        ParsedResult.maybeAppend(this.title, sb);
        return sb.toString();
    }
    
    public String getNumber() {
        return this.number;
    }
    
    public String getTelURI() {
        return this.telURI;
    }
    
    public String getTitle() {
        return this.title;
    }
}
