// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

public final class ProductParsedResult extends ParsedResult
{
    private final String normalizedProductID;
    private final String productID;
    
    ProductParsedResult(final String s) {
        this(s, s);
    }
    
    ProductParsedResult(final String productID, final String normalizedProductID) {
        super(ParsedResultType.PRODUCT);
        this.productID = productID;
        this.normalizedProductID = normalizedProductID;
    }
    
    @Override
    public String getDisplayResult() {
        return this.productID;
    }
    
    public String getNormalizedProductID() {
        return this.normalizedProductID;
    }
    
    public String getProductID() {
        return this.productID;
    }
}
