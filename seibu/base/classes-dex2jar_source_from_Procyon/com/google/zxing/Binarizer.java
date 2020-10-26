// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

public abstract class Binarizer
{
    private final LuminanceSource source;
    
    protected Binarizer(final LuminanceSource source) {
        this.source = source;
    }
    
    public abstract Binarizer createBinarizer(final LuminanceSource p0);
    
    public abstract BitMatrix getBlackMatrix() throws NotFoundException;
    
    public abstract BitArray getBlackRow(final int p0, final BitArray p1) throws NotFoundException;
    
    public final int getHeight() {
        return this.source.getHeight();
    }
    
    public final LuminanceSource getLuminanceSource() {
        return this.source;
    }
    
    public final int getWidth() {
        return this.source.getWidth();
    }
}
