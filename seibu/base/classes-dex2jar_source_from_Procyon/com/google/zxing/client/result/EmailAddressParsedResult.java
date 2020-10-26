// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class EmailAddressParsedResult extends ParsedResult
{
    private final String[] bccs;
    private final String body;
    private final String[] ccs;
    private final String subject;
    private final String[] tos;
    
    EmailAddressParsedResult(final String s) {
        this(new String[] { s }, null, null, null, null);
    }
    
    EmailAddressParsedResult(final String[] tos, final String[] ccs, final String[] bccs, final String subject, final String body) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.tos = tos;
        this.ccs = ccs;
        this.bccs = bccs;
        this.subject = subject;
        this.body = body;
    }
    
    public String[] getBCCs() {
        return this.bccs;
    }
    
    public String getBody() {
        return this.body;
    }
    
    public String[] getCCs() {
        return this.ccs;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(30);
        ParsedResult.maybeAppend(this.tos, sb);
        ParsedResult.maybeAppend(this.ccs, sb);
        ParsedResult.maybeAppend(this.bccs, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }
    
    @Deprecated
    public String getEmailAddress() {
        if (this.tos == null || this.tos.length == 0) {
            return null;
        }
        return this.tos[0];
    }
    
    @Deprecated
    public String getMailtoURI() {
        return "mailto:";
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public String[] getTos() {
        return this.tos;
    }
}
