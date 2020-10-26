// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzi implements zze
{
    private static zzi zzaJI;
    
    static {
        zzi.zzaJI = new zzi();
    }
    
    private zzi() {
    }
    
    public static zze zzrY() {
        return zzi.zzaJI;
    }
    
    @Override
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    @Override
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
    
    @Override
    public final long nanoTime() {
        return System.nanoTime();
    }
}
