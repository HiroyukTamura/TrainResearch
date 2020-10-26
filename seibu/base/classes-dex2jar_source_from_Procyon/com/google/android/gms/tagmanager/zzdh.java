// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

final class zzdh implements zzek
{
    private final String zzaeX;
    private final long zzaih;
    private final int zzaii;
    private double zzaij;
    private long zzaik;
    private final Object zzail;
    private final long zzbFo;
    private final zze zzvw;
    
    public zzdh(final int n, final int n2, final long n3, final long n4, final String zzaeX, final zze zzvw) {
        this.zzail = new Object();
        this.zzaii = 5;
        this.zzaij = Math.min(1, 5);
        this.zzaih = 900000L;
        this.zzbFo = 5000L;
        this.zzaeX = zzaeX;
        this.zzvw = zzvw;
    }
    
    @Override
    public final boolean zzlL() {
        synchronized (this.zzail) {
            final long currentTimeMillis = this.zzvw.currentTimeMillis();
            if (currentTimeMillis - this.zzaik < this.zzbFo) {
                final String zzaeX = this.zzaeX;
                zzdj.zzaT(new StringBuilder(String.valueOf(zzaeX).length() + 34).append("Excessive ").append(zzaeX).append(" detected; call ignored.").toString());
                return false;
            }
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
        }
        final String zzaeX2 = this.zzaeX;
        zzdj.zzaT(new StringBuilder(String.valueOf(zzaeX2).length() + 34).append("Excessive ").append(zzaeX2).append(" detected; call ignored.").toString());
        // monitorexit(o)
        return false;
    }
}
