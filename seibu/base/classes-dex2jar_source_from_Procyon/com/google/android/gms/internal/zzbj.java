// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbj extends adj<zzbj>
{
    private static volatile zzbj[] zzkz;
    private int name;
    public int[] zzkA;
    private int zzkB;
    private boolean zzkC;
    private boolean zzkD;
    
    public zzbj() {
        this.zzkA = ads.zzcsC;
        this.zzkB = 0;
        this.name = 0;
        this.zzkC = false;
        this.zzkD = false;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbj[] zzp() {
        Label_0027: {
            if (zzbj.zzkz != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbj.zzkz == null) {
                    zzbj.zzkz = new zzbj[0];
                }
                return zzbj.zzkz;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbj)) {
                return false;
            }
            final zzbj zzbj = (zzbj)o;
            if (!adn.equals(this.zzkA, zzbj.zzkA)) {
                return false;
            }
            if (this.zzkB != zzbj.zzkB) {
                return false;
            }
            if (this.name != zzbj.name) {
                return false;
            }
            if (this.zzkC != zzbj.zzkC) {
                return false;
            }
            if (this.zzkD != zzbj.zzkD) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbj.zzcso);
            }
            if (zzbj.zzcso != null && !zzbj.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int n = 1231;
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzkA);
        final int zzkB = this.zzkB;
        final int name = this.name;
        int n2;
        if (this.zzkC) {
            n2 = 1231;
        }
        else {
            n2 = 1237;
        }
        if (!this.zzkD) {
            n = 1237;
        }
        int hashCode3;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzcso.hashCode();
        }
        return hashCode3 + ((n2 + ((((hashCode + 527) * 31 + hashCode2) * 31 + zzkB) * 31 + name) * 31) * 31 + n) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzkD) {
            adh.zzk(1, this.zzkD);
        }
        adh.zzr(2, this.zzkB);
        if (this.zzkA != null && this.zzkA.length > 0) {
            for (int i = 0; i < this.zzkA.length; ++i) {
                adh.zzr(3, this.zzkA[i]);
            }
        }
        if (this.name != 0) {
            adh.zzr(4, this.name);
        }
        if (this.zzkC) {
            adh.zzk(6, this.zzkC);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int n = 0;
        int zzn = super.zzn();
        if (this.zzkD) {
            zzn += adh.zzct(1) + 1;
        }
        final int n2 = adh.zzs(2, this.zzkB) + zzn;
        int n3;
        if (this.zzkA != null && this.zzkA.length > 0) {
            for (int i = 0; i < this.zzkA.length; ++i) {
                n += adh.zzcr(this.zzkA[i]);
            }
            n3 = n2 + n + this.zzkA.length * 1;
        }
        else {
            n3 = n2;
        }
        int n4 = n3;
        if (this.name != 0) {
            n4 = n3 + adh.zzs(4, this.name);
        }
        int n5 = n4;
        if (this.zzkC) {
            n5 = n4 + (adh.zzct(6) + 1);
        }
        return n5;
    }
}
