// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.IOException;
import java.util.logging.Level;
import java.io.Flushable;
import java.util.logging.Logger;
import com.google.common.annotations.Beta;

@Beta
public final class Flushables
{
    private static final Logger logger;
    
    static {
        logger = Logger.getLogger(Flushables.class.getName());
    }
    
    private Flushables() {
    }
    
    public static void flush(final Flushable flushable, final boolean b) throws IOException {
        try {
            flushable.flush();
        }
        catch (IOException thrown) {
            if (b) {
                Flushables.logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", thrown);
                return;
            }
            throw thrown;
        }
    }
    
    public static void flushQuietly(final Flushable flushable) {
        try {
            flush(flushable, true);
        }
        catch (IOException thrown) {
            Flushables.logger.log(Level.SEVERE, "IOException should not have been thrown.", thrown);
        }
    }
}
