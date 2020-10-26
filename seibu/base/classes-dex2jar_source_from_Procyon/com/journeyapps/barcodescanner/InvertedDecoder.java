// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.Binarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;

public class InvertedDecoder extends Decoder
{
    public InvertedDecoder(final Reader reader) {
        super(reader);
    }
    
    @Override
    protected BinaryBitmap toBitmap(final LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
    }
}
