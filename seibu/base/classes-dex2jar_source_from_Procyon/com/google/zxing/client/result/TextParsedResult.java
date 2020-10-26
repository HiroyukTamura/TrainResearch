// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class TextParsedResult extends ParsedResult
{
    private final String language;
    private final String text;
    
    public TextParsedResult(final String text, final String language) {
        super(ParsedResultType.TEXT);
        this.text = text;
        this.language = language;
    }
    
    @Override
    public String getDisplayResult() {
        return this.text;
    }
    
    public String getLanguage() {
        return this.language;
    }
    
    public String getText() {
        return this.text;
    }
}
