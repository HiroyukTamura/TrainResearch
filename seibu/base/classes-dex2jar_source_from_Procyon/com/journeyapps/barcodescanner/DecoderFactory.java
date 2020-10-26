// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.DecodeHintType;
import java.util.Map;

public interface DecoderFactory
{
    Decoder createDecoder(final Map<DecodeHintType, ?> p0);
}
