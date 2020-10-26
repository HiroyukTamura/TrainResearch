// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;

public final class zzaoa
{
    private final String zzaeX;
    private final long zzaih;
    private final int zzaii;
    private double zzaij;
    private long zzaik;
    private final Object zzail;
    private final zze zzvw;
    
    private zzaoa(final int n, final long n2, final String zzaeX, final zze zzvw) {
        this.zzail = new Object();
        this.zzaii = 60;
        this.zzaij = this.zzaii;
        this.zzaih = 2000L;
        this.zzaeX = zzaeX;
        this.zzvw = zzvw;
    }
    
    public zzaoa(final String s, final zze zze) {
        this(60, 2000L, s, zze);
    }
    
    public final boolean zzlL() {
        synchronized (this.zzail) {
            final long currentTimeMillis = this.zzvw.currentTimeMillis();
            if (this.zzaij < this.zzaii) {
                final double n = (currentTimeMillis - this.zzaik) / (double)this.zzaih;
                if (n > 0.0) {
                    this.zzaij = Math.min(this.zzaii, n + this.zzaij);
                }
            }
            this.zzaik = currentTimeMillis;
            if (this.zzaij >= 1.0) {
                --this.zzaij;
                return true;
            }
            final String zzaeX = this.zzaeX;
            zzaob.zzaT(new StringBuilder(String.valueOf(zzaeX).length() + 34).append("Excessive ").append(zzaeX).append(" detected; call ignored.").toString());
            return false;
        }
    }
}
