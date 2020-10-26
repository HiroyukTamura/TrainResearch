// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

public interface BaseContract
{
    public interface Presenter
    {
        void start();
        
        void stop();
    }
    
    public interface View
    {
        boolean isDestroyed();
    }
}
