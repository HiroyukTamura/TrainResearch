// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import java.util.List;
import com.google.zxing.common.BitMatrix;

public final class PDF417DetectorResult
{
    private final BitMatrix bits;
    private final List<ResultPoint[]> points;
    
    public PDF417DetectorResult(final BitMatrix bits, final List<ResultPoint[]> points) {
        this.bits = bits;
        this.points = points;
    }
    
    public BitMatrix getBits() {
        return this.bits;
    }
    
    public List<ResultPoint[]> getPoints() {
        return this.points;
    }
}
