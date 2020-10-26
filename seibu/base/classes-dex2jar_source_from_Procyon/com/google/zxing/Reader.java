// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

import java.util.Map;

public interface Reader
{
    Result decode(final BinaryBitmap p0) throws NotFoundException, ChecksumException, FormatException;
    
    Result decode(final BinaryBitmap p0, final Map<DecodeHintType, ?> p1) throws NotFoundException, ChecksumException, FormatException;
    
    void reset();
}
