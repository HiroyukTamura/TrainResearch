// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.zza;

public abstract class DowngradeableSafeParcel extends zza implements ReflectedParcelable
{
    private static final Object zzaHq;
    private static ClassLoader zzaHr;
    private static Integer zzaHs;
    private boolean zzaHt;
    
    static {
        zzaHq = new Object();
        DowngradeableSafeParcel.zzaHr = null;
        DowngradeableSafeParcel.zzaHs = null;
    }
    
    public DowngradeableSafeParcel() {
        this.zzaHt = false;
    }
    
    protected static boolean zzcA(final String s) {
        zzrw();
        return true;
    }
    
    private static ClassLoader zzrw() {
        synchronized (DowngradeableSafeParcel.zzaHq) {
            // monitorexit(DowngradeableSafeParcel.zzaHq)
            return null;
        }
    }
    
    protected static Integer zzrx() {
        synchronized (DowngradeableSafeParcel.zzaHq) {
            // monitorexit(DowngradeableSafeParcel.zzaHq)
            return null;
        }
    }
}
