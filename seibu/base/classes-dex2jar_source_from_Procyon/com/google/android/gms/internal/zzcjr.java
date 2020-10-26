// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjr extends adj<zzcjr>
{
    public Integer zzbve;
    public String zzbvf;
    public Boolean zzbvg;
    public String[] zzbvh;
    
    public zzcjr() {
        this.zzbve = null;
        this.zzbvf = null;
        this.zzbvg = null;
        this.zzbvh = ads.EMPTY_STRING_ARRAY;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjr)) {
                return false;
            }
            final zzcjr zzcjr = (zzcjr)o;
            if (this.zzbve == null) {
                if (zzcjr.zzbve != null) {
                    return false;
                }
            }
            else if (!this.zzbve.equals(zzcjr.zzbve)) {
                return false;
            }
            if (this.zzbvf == null) {
                if (zzcjr.zzbvf != null) {
                    return false;
                }
            }
            else if (!this.zzbvf.equals(zzcjr.zzbvf)) {
                return false;
            }
            if (this.zzbvg == null) {
                if (zzcjr.zzbvg != null) {
                    return false;
                }
            }
            else if (!this.zzbvg.equals(zzcjr.zzbvg)) {
                return false;
            }
            if (!adn.equals(this.zzbvh, zzcjr.zzbvh)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjr.zzcso);
            }
            if (zzcjr.zzcso != null && !zzcjr.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        int intValue;
        if (this.zzbve == null) {
            intValue = 0;
        }
        else {
            intValue = this.zzbve;
        }
        int hashCode2;
        if (this.zzbvf == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbvf.hashCode();
        }
        int hashCode3;
        if (this.zzbvg == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbvg.hashCode();
        }
        final int hashCode4 = adn.hashCode(this.zzbvh);
        int hashCode5 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode5 = n;
            }
            else {
                hashCode5 = this.zzcso.hashCode();
            }
        }
        return ((hashCode3 + (hashCode2 + (intValue + (hashCode + 527) * 31) * 31) * 31) * 31 + hashCode4) * 31 + hashCode5;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbve != null) {
            adh.zzr(1, this.zzbve);
        }
        if (this.zzbvf != null) {
            adh.zzl(2, this.zzbvf);
        }
        if (this.zzbvg != null) {
            adh.zzk(3, this.zzbvg);
        }
        if (this.zzbvh != null && this.zzbvh.length > 0) {
            for (int i = 0; i < this.zzbvh.length; ++i) {
                final String s = this.zzbvh[i];
                if (s != null) {
                    adh.zzl(4, s);
                }
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        int zzn;
        final int n2 = zzn = super.zzn();
        if (this.zzbve != null) {
            zzn = n2 + adh.zzs(1, this.zzbve);
        }
        int n3 = zzn;
        if (this.zzbvf != null) {
            n3 = zzn + adh.zzm(2, this.zzbvf);
        }
        int n4 = n3;
        if (this.zzbvg != null) {
            this.zzbvg;
            n4 = n3 + (adh.zzct(3) + 1);
        }
        int n5 = n4;
        if (this.zzbvh != null) {
            n5 = n4;
            if (this.zzbvh.length > 0) {
                int n6 = 0;
                int n7 = 0;
                int n8;
                int n9;
                for (int i = n; i < this.zzbvh.length; ++i, n6 = n8, n7 = n9) {
                    final String s = this.zzbvh[i];
                    n8 = n6;
                    n9 = n7;
                    if (s != null) {
                        n9 = n7 + 1;
                        n8 = n6 + adh.zzhQ(s);
                    }
                }
                n5 = n4 + n6 + n7 * 1;
            }
        }
        return n5;
    }
}
