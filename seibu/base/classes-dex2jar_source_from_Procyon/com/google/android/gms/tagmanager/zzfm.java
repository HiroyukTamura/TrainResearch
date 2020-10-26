// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zze;

final class zzfm implements zzek
{
    private final long zzaih;
    private final int zzaii;
    private double zzaij;
    private final Object zzail;
    private long zzbGB;
    private final zze zzvw;
    
    public zzfm() {
        this(60, 2000L);
    }
    
    private zzfm(final int n, final long n2) {
        this.zzail = new Object();
        this.zzaii = 60;
        this.zzaij = this.zzaii;
        this.zzaih = 2000L;
        this.zzvw = zzi.zzrY();
    }
    
    @Override
    public final boolean zzlL() {
        synchronized (this.zzail) {
            final long currentTimeMillis = this.zzvw.currentTimeMillis();
            if (this.zzaij < this.zzaii) {
                final double n = (currentTimeMillis - this.zzbGB) / (double)this.zzaih;
                if (n > 0.0) {
                    this.zzaij = Math.min(this.zzaii, n + this.zzaij);
                }
            }
            this.zzbGB = currentTimeMillis;
            if (this.zzaij >= 1.0) {
                --this.zzaij;
                return true;
            }
            zzdj.zzaT("No more tokens available.");
            return false;
        }
    }
}
