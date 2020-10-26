// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public final class ChecksumException extends ReaderException
{
    private static final ChecksumException INSTANCE;
    
    static {
        (INSTANCE = new ChecksumException()).setStackTrace(ChecksumException.NO_TRACE);
    }
    
    private ChecksumException() {
    }
    
    private ChecksumException(final Throwable t) {
        super(t);
    }
    
    public static ChecksumException getChecksumInstance() {
        if (ChecksumException.isStackTrace) {
            return new ChecksumException();
        }
        return ChecksumException.INSTANCE;
    }
    
    public static ChecksumException getChecksumInstance(final Throwable t) {
        if (ChecksumException.isStackTrace) {
            return new ChecksumException(t);
        }
        return ChecksumException.INSTANCE;
    }
}
