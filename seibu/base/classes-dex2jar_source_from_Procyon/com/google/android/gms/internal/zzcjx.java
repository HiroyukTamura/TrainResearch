// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjx extends adj<zzcjx>
{
    private static volatile zzcjx[] zzbvz;
    public String name;
    public String zzaIF;
    private Float zzbuA;
    public Double zzbuB;
    public Long zzbvA;
    
    public zzcjx() {
        this.name = null;
        this.zzaIF = null;
        this.zzbvA = null;
        this.zzbuA = null;
        this.zzbuB = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjx[] zzzC() {
        Label_0027: {
            if (zzcjx.zzbvz != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjx.zzbvz == null) {
                    zzcjx.zzbvz = new zzcjx[0];
                }
                return zzcjx.zzbvz;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjx)) {
                return false;
            }
            final zzcjx zzcjx = (zzcjx)o;
            if (this.name == null) {
                if (zzcjx.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(zzcjx.name)) {
                return false;
            }
            if (this.zzaIF == null) {
                if (zzcjx.zzaIF != null) {
                    return false;
                }
            }
            else if (!this.zzaIF.equals(zzcjx.zzaIF)) {
                return false;
            }
            if (this.zzbvA == null) {
                if (zzcjx.zzbvA != null) {
                    return false;
                }
            }
            else if (!this.zzbvA.equals(zzcjx.zzbvA)) {
                return false;
            }
            if (this.zzbuA == null) {
                if (zzcjx.zzbuA != null) {
                    return false;
                }
            }
            else if (!this.zzbuA.equals(zzcjx.zzbuA)) {
                return false;
            }
            if (this.zzbuB == null) {
                if (zzcjx.zzbuB != null) {
                    return false;
                }
            }
            else if (!this.zzbuB.equals(zzcjx.zzbuB)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjx.zzcso);
            }
            if (zzcjx.zzcso != null && !zzcjx.zzcso.isEmpty()) {
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
        if (this.zzaIF == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzaIF.hashCode();
        }
        int hashCode4;
        if (this.zzbvA == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvA.hashCode();
        }
        int hashCode5;
        if (this.zzbuA == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbuA.hashCode();
        }
        int hashCode6;
        if (this.zzbuB == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = this.zzbuB.hashCode();
        }
        int hashCode7 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode7 = n;
            }
            else {
                hashCode7 = this.zzcso.hashCode();
            }
        }
        return (hashCode6 + (hashCode5 + (hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31) * 31) * 31 + hashCode7;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.name != null) {
            adh.zzl(1, this.name);
        }
        if (this.zzaIF != null) {
            adh.zzl(2, this.zzaIF);
        }
        if (this.zzbvA != null) {
            adh.zzb(3, this.zzbvA);
        }
        if (this.zzbuA != null) {
            adh.zzc(4, this.zzbuA);
        }
        if (this.zzbuB != null) {
            adh.zza(5, this.zzbuB);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.name != null) {
            zzn = n + adh.zzm(1, this.name);
        }
        int n2 = zzn;
        if (this.zzaIF != null) {
            n2 = zzn + adh.zzm(2, this.zzaIF);
        }
        int n3 = n2;
        if (this.zzbvA != null) {
            n3 = n2 + adh.zze(3, this.zzbvA);
        }
        int n4 = n3;
        if (this.zzbuA != null) {
            this.zzbuA;
            n4 = n3 + (adh.zzct(4) + 4);
        }
        int n5 = n4;
        if (this.zzbuB != null) {
            this.zzbuB;
            n5 = n4 + (adh.zzct(5) + 8);
        }
        return n5;
    }
}
