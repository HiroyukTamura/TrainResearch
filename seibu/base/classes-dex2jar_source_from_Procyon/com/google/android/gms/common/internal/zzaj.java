// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzaj
{
    private static int zzaHZ;
    private static final String zzaIa;
    private final String zzaIb;
    private final String zzaIc;
    
    static {
        zzaj.zzaHZ = 15;
        zzaIa = null;
    }
    
    public zzaj(final String s) {
        this(s, null);
    }
    
    private zzaj(final String zzaIb, final String s) {
        zzbo.zzb(zzaIb, "log tag cannot be null");
        zzbo.zzb(zzaIb.length() <= 23, "tag \"%s\" is longer than the %d character maximum", zzaIb, 23);
        this.zzaIb = zzaIb;
        this.zzaIc = null;
    }
    
    private final boolean zzaB(final int n) {
        return Log.isLoggable(this.zzaIb, n);
    }
    
    private final String zzcE(final String str) {
        if (this.zzaIc == null) {
            return str;
        }
        return this.zzaIc.concat(str);
    }
    
    public final void zzb(final String s, final String s2, final Throwable t) {
        if (this.zzaB(4)) {
            Log.i(s, this.zzcE(s2), t);
        }
    }
    
    public final void zzc(final String s, final String s2, final Throwable t) {
        if (this.zzaB(5)) {
            Log.w(s, this.zzcE(s2), t);
        }
    }
    
    public final void zzd(final String s, final String s2, final Throwable t) {
        if (this.zzaB(6)) {
            Log.e(s, this.zzcE(s2), t);
        }
    }
    
    public final void zze(final String s, final String s2, final Throwable t) {
        if (this.zzaB(7)) {
            Log.e(s, this.zzcE(s2), t);
            Log.wtf(s, this.zzcE(s2), t);
        }
    }
    
    public final void zzx(final String s, final String s2) {
        if (this.zzaB(3)) {
            Log.d(s, this.zzcE(s2));
        }
    }
    
    public final void zzy(final String s, final String s2) {
        if (this.zzaB(5)) {
            Log.w(s, this.zzcE(s2));
        }
    }
    
    public final void zzz(final String s, final String s2) {
        if (this.zzaB(6)) {
            Log.e(s, this.zzcE(s2));
        }
    }
}
