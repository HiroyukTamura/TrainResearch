// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbp extends adj<zzbp>
{
    private static volatile zzbp[] zzlx;
    public String name;
    private zzbr zzly;
    public zzbl zzlz;
    
    public zzbp() {
        this.name = "";
        this.zzly = null;
        this.zzlz = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbp[] zzt() {
        Label_0027: {
            if (zzbp.zzlx != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbp.zzlx == null) {
                    zzbp.zzlx = new zzbp[0];
                }
                return zzbp.zzlx;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbp)) {
                return false;
            }
            final zzbp zzbp = (zzbp)o;
            if (this.name == null) {
                if (zzbp.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(zzbp.name)) {
                return false;
            }
            if (this.zzly == null) {
                if (zzbp.zzly != null) {
                    return false;
                }
            }
            else if (!this.zzly.equals(zzbp.zzly)) {
                return false;
            }
            if (this.zzlz == null) {
                if (zzbp.zzlz != null) {
                    return false;
                }
            }
            else if (!this.zzlz.equals(zzbp.zzlz)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbp.zzcso);
            }
            if (zzbp.zzcso != null && !zzbp.zzcso.isEmpty()) {
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
        if (this.name == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.name.hashCode();
        }
        int hashCode3;
        if (this.zzly == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzly.hashCode();
        }
        int hashCode4;
        if (this.zzlz == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzlz.hashCode();
        }
        int hashCode5 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode5 = n;
            }
            else {
                hashCode5 = this.zzcso.hashCode();
            }
        }
        return (hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31 + hashCode5;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.name != null && !this.name.equals("")) {
            adh.zzl(1, this.name);
        }
        if (this.zzly != null) {
            adh.zza(2, this.zzly);
        }
        if (this.zzlz != null) {
            adh.zza(3, this.zzlz);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.name != null) {
            zzn = n;
            if (!this.name.equals("")) {
                zzn = n + adh.zzm(1, this.name);
            }
        }
        int n2 = zzn;
        if (this.zzly != null) {
            n2 = zzn + adh.zzb(2, this.zzly);
        }
        int n3 = n2;
        if (this.zzlz != null) {
            n3 = n2 + adh.zzb(3, this.zzlz);
        }
        return n3;
    }
}
