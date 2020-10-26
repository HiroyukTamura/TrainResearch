// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class ISBNParsedResult extends ParsedResult
{
    private final String isbn;
    
    ISBNParsedResult(final String isbn) {
        super(ParsedResultType.ISBN);
        this.isbn = isbn;
    }
    
    @Override
    public String getDisplayResult() {
        return this.isbn;
    }
    
    public String getISBN() {
        return this.isbn;
    }
}
