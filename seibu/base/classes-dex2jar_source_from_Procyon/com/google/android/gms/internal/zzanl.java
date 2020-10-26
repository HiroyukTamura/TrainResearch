// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

final class zzanl implements Logger
{
    private boolean zzadH;
    private int zzagX;
    
    zzanl() {
        this.zzagX = 2;
    }
    
    @Override
    public final void error(final Exception ex) {
    }
    
    @Override
    public final void error(final String s) {
    }
    
    @Override
    public final int getLogLevel() {
        return this.zzagX;
    }
    
    @Override
    public final void info(final String s) {
    }
    
    @Override
    public final void setLogLevel(final int zzagX) {
        this.zzagX = zzagX;
        if (!this.zzadH) {
            final String s = zzans.zzahg.get();
            final String s2 = zzans.zzahg.get();
            Log.i(s, new StringBuilder(String.valueOf(s2).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(s2).append(" DEBUG").toString());
            this.zzadH = true;
        }
    }
    
    @Override
    public final void verbose(final String s) {
    }
    
    @Override
    public final void warn(final String s) {
    }
}
