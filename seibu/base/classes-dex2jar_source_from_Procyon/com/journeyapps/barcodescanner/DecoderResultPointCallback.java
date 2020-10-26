// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

public class DecoderResultPointCallback implements ResultPointCallback
{
    private Decoder decoder;
    
    public DecoderResultPointCallback() {
    }
    
    public DecoderResultPointCallback(final Decoder decoder) {
        this.decoder = decoder;
    }
    
    @Override
    public void foundPossibleResultPoint(final ResultPoint resultPoint) {
        if (this.decoder != null) {
            this.decoder.foundPossibleResultPoint(resultPoint);
        }
    }
    
    public Decoder getDecoder() {
        return this.decoder;
    }
    
    public void setDecoder(final Decoder decoder) {
        this.decoder = decoder;
    }
}
