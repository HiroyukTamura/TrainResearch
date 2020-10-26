// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing;

public abstract class ReaderException extends Exception
{
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;
    
    static {
        isStackTrace = (System.getProperty("surefire.test.class.path") != null);
        NO_TRACE = new StackTraceElement[0];
    }
    
    ReaderException() {
    }
    
    ReaderException(final Throwable cause) {
        super(cause);
    }
    
    @Override
    public final Throwable fillInStackTrace() {
        // monitorenter(this)
        // monitorexit(this)
        return null;
    }
}
