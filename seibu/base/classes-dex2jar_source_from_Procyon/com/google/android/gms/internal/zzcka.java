// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcka extends adj<zzcka>
{
    public long[] zzbwe;
    public long[] zzbwf;
    
    public zzcka() {
        this.zzbwe = ads.zzcsD;
        this.zzbwf = ads.zzcsD;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcka)) {
                return false;
            }
            final zzcka zzcka = (zzcka)o;
            if (!adn.equals(this.zzbwe, zzcka.zzbwe)) {
                return false;
            }
            if (!adn.equals(this.zzbwf, zzcka.zzbwf)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcka.zzcso);
            }
            if (zzcka.zzcso != null && !zzcka.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzbwe);
        final int hashCode3 = adn.hashCode(this.zzbwf);
        int hashCode4;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzcso.hashCode();
        }
        return hashCode4 + (((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzbwe != null && this.zzbwe.length > 0) {
            for (int i = 0; i < this.zzbwe.length; ++i) {
                adh.zza(1, this.zzbwe[i]);
            }
        }
        if (this.zzbwf != null && this.zzbwf.length > 0) {
            for (int j = n; j < this.zzbwf.length; ++j) {
                adh.zza(2, this.zzbwf[j]);
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        final int zzn = super.zzn();
        int n3;
        if (this.zzbwe != null && this.zzbwe.length > 0) {
            int i = 0;
            int n2 = 0;
            while (i < this.zzbwe.length) {
                n2 += adh.zzaP(this.zzbwe[i]);
                ++i;
            }
            n3 = zzn + n2 + this.zzbwe.length * 1;
        }
        else {
            n3 = zzn;
        }
        int n4 = n3;
        if (this.zzbwf != null) {
            n4 = n3;
            if (this.zzbwf.length > 0) {
                int n5 = 0;
                for (int j = n; j < this.zzbwf.length; ++j) {
                    n5 += adh.zzaP(this.zzbwf[j]);
                }
                n4 = n3 + n5 + this.zzbwf.length * 1;
            }
        }
        return n4;
    }
}
