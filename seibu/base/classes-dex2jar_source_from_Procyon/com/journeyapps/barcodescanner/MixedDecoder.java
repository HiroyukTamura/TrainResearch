// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.Binarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;

public class MixedDecoder extends Decoder
{
    private boolean isInverted;
    
    public MixedDecoder(final Reader reader) {
        super(reader);
        this.isInverted = true;
    }
    
    @Override
    protected BinaryBitmap toBitmap(final LuminanceSource luminanceSource) {
        if (this.isInverted) {
            this.isInverted = false;
            return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
        }
        this.isInverted = true;
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}
