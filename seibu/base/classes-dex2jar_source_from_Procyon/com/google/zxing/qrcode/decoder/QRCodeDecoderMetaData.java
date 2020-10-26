// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

public final class QRCodeDecoderMetaData
{
    private final boolean mirrored;
    
    QRCodeDecoderMetaData(final boolean mirrored) {
        this.mirrored = mirrored;
    }
    
    public void applyMirroredCorrection(final ResultPoint[] array) {
        if (!this.mirrored || array == null || array.length < 3) {
            return;
        }
        final ResultPoint resultPoint = array[0];
        array[0] = array[2];
        array[2] = resultPoint;
    }
    
    public boolean isMirrored() {
        return this.mirrored;
    }
}
