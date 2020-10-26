// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjv extends adj<zzcjv>
{
    private static volatile zzcjv[] zzbvr;
    public Integer zzbuI;
    public zzcka zzbvs;
    public zzcka zzbvt;
    public Boolean zzbvu;
    
    public zzcjv() {
        this.zzbuI = null;
        this.zzbvs = null;
        this.zzbvt = null;
        this.zzbvu = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjv[] zzzA() {
        Label_0027: {
            if (zzcjv.zzbvr != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjv.zzbvr == null) {
                    zzcjv.zzbvr = new zzcjv[0];
                }
                return zzcjv.zzbvr;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjv)) {
                return false;
            }
            final zzcjv zzcjv = (zzcjv)o;
            if (this.zzbuI == null) {
                if (zzcjv.zzbuI != null) {
                    return false;
                }
            }
            else if (!this.zzbuI.equals(zzcjv.zzbuI)) {
                return false;
            }
            if (this.zzbvs == null) {
                if (zzcjv.zzbvs != null) {
                    return false;
                }
            }
            else if (!this.zzbvs.equals(zzcjv.zzbvs)) {
                return false;
            }
            if (this.zzbvt == null) {
                if (zzcjv.zzbvt != null) {
                    return false;
                }
            }
            else if (!this.zzbvt.equals(zzcjv.zzbvt)) {
                return false;
            }
            if (this.zzbvu == null) {
                if (zzcjv.zzbvu != null) {
                    return false;
                }
            }
            else if (!this.zzbvu.equals(zzcjv.zzbvu)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjv.zzcso);
            }
            if (zzcjv.zzcso != null && !zzcjv.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int n = 0;
        final int hashCode = this.getClass().getName().hashCode();
        int hashCode2;
        if (this.zzbuI == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbuI.hashCode();
        }
        int hashCode3;
        if (this.zzbvs == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbvs.hashCode();
        }
        int hashCode4;
        if (this.zzbvt == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvt.hashCode();
        }
        int hashCode5;
        if (this.zzbvu == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbvu.hashCode();
        }
        int hashCode6 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode6 = n;
            }
            else {
                hashCode6 = this.zzcso.hashCode();
            }
        }
        return (hashCode5 + (hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31) * 31 + hashCode6;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbuI != null) {
            adh.zzr(1, this.zzbuI);
        }
        if (this.zzbvs != null) {
            adh.zza(2, this.zzbvs);
        }
        if (this.zzbvt != null) {
            adh.zza(3, this.zzbvt);
        }
        if (this.zzbvu != null) {
            adh.zzk(4, this.zzbvu);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbuI != null) {
            zzn = n + adh.zzs(1, this.zzbuI);
        }
        int n2 = zzn;
        if (this.zzbvs != null) {
            n2 = zzn + adh.zzb(2, this.zzbvs);
        }
        int n3 = n2;
        if (this.zzbvt != null) {
            n3 = n2 + adh.zzb(3, this.zzbvt);
        }
        int n4 = n3;
        if (this.zzbvu != null) {
            this.zzbvu;
            n4 = n3 + (adh.zzct(4) + 1);
        }
        return n4;
    }
}
