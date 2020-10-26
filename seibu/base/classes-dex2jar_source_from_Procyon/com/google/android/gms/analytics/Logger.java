// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

@Deprecated
public interface Logger
{
    @Deprecated
    void error(final Exception p0);
    
    @Deprecated
    void error(final String p0);
    
    @Deprecated
    int getLogLevel();
    
    @Deprecated
    void info(final String p0);
    
    @Deprecated
    void setLogLevel(final int p0);
    
    @Deprecated
    void verbose(final String p0);
    
    @Deprecated
    void warn(final String p0);
    
    @Deprecated
    public static class LogLevel
    {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;
    }
}
