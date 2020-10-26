// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.encoder;

public final class Dimensions
{
    private final int maxCols;
    private final int maxRows;
    private final int minCols;
    private final int minRows;
    
    public Dimensions(final int minCols, final int maxCols, final int minRows, final int maxRows) {
        this.minCols = minCols;
        this.maxCols = maxCols;
        this.minRows = minRows;
        this.maxRows = maxRows;
    }
    
    public int getMaxCols() {
        return this.maxCols;
    }
    
    public int getMaxRows() {
        return this.maxRows;
    }
    
    public int getMinCols() {
        return this.minCols;
    }
    
    public int getMinRows() {
        return this.minRows;
    }
}
