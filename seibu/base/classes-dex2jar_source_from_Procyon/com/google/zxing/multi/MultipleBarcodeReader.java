// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.multi;

import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;

public interface MultipleBarcodeReader
{
    Result[] decodeMultiple(final BinaryBitmap p0) throws NotFoundException;
    
    Result[] decodeMultiple(final BinaryBitmap p0, final Map<DecodeHintType, ?> p1) throws NotFoundException;
}
