// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import me.yokeyword.fragmentation.helper.ExceptionHandler;

public class Fragmentation
{
    public static final int BUBBLE = 2;
    static volatile Fragmentation INSTANCE;
    public static final int NONE = 0;
    public static final int SHAKE = 1;
    private boolean debug;
    private ExceptionHandler handler;
    private int mode;
    
    Fragmentation(final FragmentationBuilder fragmentationBuilder) {
        this.mode = 0;
        this.debug = fragmentationBuilder.debug;
        if (this.debug) {
            this.mode = fragmentationBuilder.mode;
        }
        this.handler = fragmentationBuilder.handler;
    }
    
    public static FragmentationBuilder builder() {
        return new FragmentationBuilder();
    }
    
    static Fragmentation getDefault() {
        Label_0035: {
            if (Fragmentation.INSTANCE != null) {
                break Label_0035;
            }
            synchronized (Fragmentation.class) {
                if (Fragmentation.INSTANCE == null) {
                    Fragmentation.INSTANCE = new Fragmentation(new FragmentationBuilder());
                }
                return Fragmentation.INSTANCE;
            }
        }
    }
    
    public ExceptionHandler getHandler() {
        return this.handler;
    }
    
    public int getMode() {
        return this.mode;
    }
    
    public boolean isDebug() {
        return this.debug;
    }
    
    public void setDebug(final boolean debug) {
        this.debug = debug;
    }
    
    public void setHandler(final ExceptionHandler handler) {
        this.handler = handler;
    }
    
    public void setMode(final int mode) {
        this.mode = mode;
    }
    
    public static class FragmentationBuilder
    {
        private boolean debug;
        private ExceptionHandler handler;
        private int mode;
        
        public FragmentationBuilder debug(final boolean debug) {
            this.debug = debug;
            return this;
        }
        
        public FragmentationBuilder handleException(final ExceptionHandler handler) {
            this.handler = handler;
            return this;
        }
        
        public Fragmentation install() {
            synchronized (Fragmentation.class) {
                if (Fragmentation.INSTANCE != null) {
                    throw new RuntimeException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
                }
            }
            Fragmentation.INSTANCE = new Fragmentation(this);
            // monitorexit(Fragmentation.class)
            return Fragmentation.INSTANCE;
        }
        
        public FragmentationBuilder stackViewMode(final int mode) {
            this.mode = mode;
            return this;
        }
    }
}
