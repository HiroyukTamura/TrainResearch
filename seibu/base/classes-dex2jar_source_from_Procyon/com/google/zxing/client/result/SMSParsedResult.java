// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class SMSParsedResult extends ParsedResult
{
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;
    
    public SMSParsedResult(final String s, final String s2, final String subject, final String body) {
        super(ParsedResultType.SMS);
        this.numbers = new String[] { s };
        this.vias = new String[] { s2 };
        this.subject = subject;
        this.body = body;
    }
    
    public SMSParsedResult(final String[] numbers, final String[] vias, final String subject, final String body) {
        super(ParsedResultType.SMS);
        this.numbers = numbers;
        this.vias = vias;
        this.subject = subject;
        this.body = body;
    }
    
    public String getBody() {
        return this.body;
    }
    
    @Override
    public String getDisplayResult() {
        final StringBuilder sb = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb);
        ParsedResult.maybeAppend(this.subject, sb);
        ParsedResult.maybeAppend(this.body, sb);
        return sb.toString();
    }
    
    public String[] getNumbers() {
        return this.numbers;
    }
    
    public String getSMSURI() {
        final StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        int n = 1;
        for (int i = 0; i < this.numbers.length; ++i) {
            if (n != 0) {
                n = 0;
            }
            else {
                sb.append(',');
            }
            sb.append(this.numbers[i]);
            if (this.vias != null && this.vias[i] != null) {
                sb.append(";via=");
                sb.append(this.vias[i]);
            }
        }
        boolean b;
        if (this.body != null) {
            b = true;
        }
        else {
            b = false;
        }
        boolean b2;
        if (this.subject != null) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        if (b || b2) {
            sb.append('?');
            if (b) {
                sb.append("body=");
                sb.append(this.body);
            }
            if (b2) {
                if (b) {
                    sb.append('&');
                }
                sb.append("subject=");
                sb.append(this.subject);
            }
        }
        return sb.toString();
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public String[] getVias() {
        return this.vias;
    }
}
