// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.log;

public enum LogLevel
{
    debug(1), 
    error(4), 
    info(2), 
    verbose(0), 
    warn(3);
    
    private final int levelNo;
    
    private LogLevel(final int levelNo) {
        this.levelNo = levelNo;
    }
    
    public static LogLevel level(final int n) {
        final LogLevel debug = LogLevel.debug;
        switch (n) {
            default: {
                return LogLevel.debug;
            }
            case 0: {
                return LogLevel.verbose;
            }
            case 2: {
                return LogLevel.info;
            }
            case 3: {
                return LogLevel.warn;
            }
            case 4: {
                return LogLevel.error;
            }
        }
    }
    
    public int level() {
        return this.levelNo;
    }
}
