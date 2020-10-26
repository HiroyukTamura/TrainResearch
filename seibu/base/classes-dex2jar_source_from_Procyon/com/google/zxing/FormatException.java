// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class FormatException extends ReaderException
{
    private static final FormatException INSTANCE;
    
    static {
        (INSTANCE = new FormatException()).setStackTrace(FormatException.NO_TRACE);
    }
    
    private FormatException() {
    }
    
    private FormatException(final Throwable t) {
        super(t);
    }
    
    public static FormatException getFormatInstance() {
        if (FormatException.isStackTrace) {
            return new FormatException();
        }
        return FormatException.INSTANCE;
    }
    
    public static FormatException getFormatInstance(final Throwable t) {
        if (FormatException.isStackTrace) {
            return new FormatException(t);
        }
        return FormatException.INSTANCE;
    }
}
