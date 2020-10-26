// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint
{
    private final int count;
    private final float estimatedModuleSize;
    
    FinderPattern(final float n, final float n2, final float n3) {
        this(n, n2, n3, 1);
    }
    
    private FinderPattern(final float n, final float n2, final float estimatedModuleSize, final int count) {
        super(n, n2);
        this.estimatedModuleSize = estimatedModuleSize;
        this.count = count;
    }
    
    boolean aboutEquals(float abs, final float n, final float n2) {
        boolean b2;
        final boolean b = b2 = false;
        if (Math.abs(n - this.getY()) <= abs) {
            b2 = b;
            if (Math.abs(n2 - this.getX()) <= abs) {
                abs = Math.abs(abs - this.estimatedModuleSize);
                if (abs > 1.0f) {
                    b2 = b;
                    if (abs > this.estimatedModuleSize) {
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    FinderPattern combineEstimate(final float n, final float n2, final float n3) {
        final int n4 = this.count + 1;
        return new FinderPattern((this.count * this.getX() + n2) / n4, (this.count * this.getY() + n) / n4, (this.count * this.estimatedModuleSize + n3) / n4, n4);
    }
    
    int getCount() {
        return this.count;
    }
    
    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }
}
