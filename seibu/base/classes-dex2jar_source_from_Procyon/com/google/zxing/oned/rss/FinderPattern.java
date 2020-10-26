// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern
{
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;
    
    public FinderPattern(final int value, final int[] startEnd, final int n, final int n2, final int n3) {
        this.value = value;
        this.startEnd = startEnd;
        this.resultPoints = new ResultPoint[] { new ResultPoint((float)n, (float)n3), new ResultPoint((float)n2, (float)n3) };
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof FinderPattern && this.value == ((FinderPattern)o).value;
    }
    
    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }
    
    public int[] getStartEnd() {
        return this.startEnd;
    }
    
    public int getValue() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
}
