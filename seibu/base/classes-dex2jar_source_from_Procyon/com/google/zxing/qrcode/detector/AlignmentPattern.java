// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class AlignmentPattern extends ResultPoint
{
    private final float estimatedModuleSize;
    
    AlignmentPattern(final float n, final float n2, final float estimatedModuleSize) {
        super(n, n2);
        this.estimatedModuleSize = estimatedModuleSize;
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
    
    AlignmentPattern combineEstimate(final float n, final float n2, final float n3) {
        return new AlignmentPattern((this.getX() + n2) / 2.0f, (this.getY() + n) / 2.0f, (this.estimatedModuleSize + n3) / 2.0f);
    }
}
