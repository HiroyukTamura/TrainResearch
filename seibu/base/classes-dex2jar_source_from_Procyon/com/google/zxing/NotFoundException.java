// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class NotFoundException extends ReaderException
{
    private static final NotFoundException INSTANCE;
    
    static {
        (INSTANCE = new NotFoundException()).setStackTrace(NotFoundException.NO_TRACE);
    }
    
    private NotFoundException() {
    }
    
    public static NotFoundException getNotFoundInstance() {
        return NotFoundException.INSTANCE;
    }
}
