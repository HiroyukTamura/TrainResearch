// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import java.util.Map;
import com.google.zxing.common.BitMatrix;

public interface Writer
{
    BitMatrix encode(final String p0, final BarcodeFormat p1, final int p2, final int p3) throws WriterException;
    
    BitMatrix encode(final String p0, final BarcodeFormat p1, final int p2, final int p3, final Map<EncodeHintType, ?> p4) throws WriterException;
}
