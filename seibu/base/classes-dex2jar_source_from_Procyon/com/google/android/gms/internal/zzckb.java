// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzckb extends adj<zzckb>
{
    private static volatile zzckb[] zzbwg;
    public String name;
    public String zzaIF;
    private Float zzbuA;
    public Double zzbuB;
    public Long zzbvA;
    public Long zzbwh;
    
    public zzckb() {
        this.zzbwh = null;
        this.name = null;
        this.zzaIF = null;
        this.zzbvA = null;
        this.zzbuA = null;
        this.zzbuB = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzckb[] zzzE() {
        Label_0027: {
            if (zzckb.zzbwg != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzckb.zzbwg == null) {
                    zzckb.zzbwg = new zzckb[0];
                }
                return zzckb.zzbwg;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzckb)) {
                return false;
            }
            final zzckb zzckb = (zzckb)o;
            if (this.zzbwh == null) {
                if (zzckb.zzbwh != null) {
                    return false;
                }
            }
            else if (!this.zzbwh.equals(zzckb.zzbwh)) {
                return false;
            }
            if (this.name == null) {
                if (zzckb.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(zzckb.name)) {
                return false;
            }
            if (this.zzaIF == null) {
                if (zzckb.zzaIF != null) {
                    return false;
                }
            }
            else if (!this.zzaIF.equals(zzckb.zzaIF)) {
                return false;
            }
            if (this.zzbvA == null) {
                if (zzckb.zzbvA != null) {
                    return false;
                }
            }
            else if (!this.zzbvA.equals(zzckb.zzbvA)) {
                return false;
            }
            if (this.zzbuA == null) {
                if (zzckb.zzbuA != null) {
                    return false;
                }
            }
            else if (!this.zzbuA.equals(zzckb.zzbuA)) {
                return false;
            }
            if (this.zzbuB == null) {
                if (zzckb.zzbuB != null) {
                    return false;
                }
            }
            else if (!this.zzbuB.equals(zzckb.zzbuB)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzckb.zzcso);
            }
            if (zzckb.zzcso != null && !zzckb.zzcso.isEmpty()) {
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
        if (this.zzbwh == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbwh.hashCode();
        }
        int hashCode3;
        if (this.name == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.name.hashCode();
        }
        int hashCode4;
        if (this.zzaIF == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzaIF.hashCode();
        }
        int hashCode5;
        if (this.zzbvA == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbvA.hashCode();
        }
        int hashCode6;
        if (this.zzbuA == null) {
            hashCode6 = 0;
        }
        else {
            hashCode6 = this.zzbuA.hashCode();
        }
        int hashCode7;
        if (this.zzbuB == null) {
            hashCode7 = 0;
        }
        else {
            hashCode7 = this.zzbuB.hashCode();
        }
        int hashCode8 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode8 = n;
            }
            else {
                hashCode8 = this.zzcso.hashCode();
            }
        }
        return (hashCode7 + (hashCode6 + (hashCode5 + (hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + hashCode8;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.zzbwh != null) {
            adh.zzb(1, this.zzbwh);
        }
        if (this.name != null) {
            adh.zzl(2, this.name);
        }
        if (this.zzaIF != null) {
            adh.zzl(3, this.zzaIF);
        }
        if (this.zzbvA != null) {
            adh.zzb(4, this.zzbvA);
        }
        if (this.zzbuA != null) {
            adh.zzc(5, this.zzbuA);
        }
        if (this.zzbuB != null) {
            adh.zza(6, this.zzbuB);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbwh != null) {
            zzn = n + adh.zze(1, this.zzbwh);
        }
        int n2 = zzn;
        if (this.name != null) {
            n2 = zzn + adh.zzm(2, this.name);
        }
        int n3 = n2;
        if (this.zzaIF != null) {
            n3 = n2 + adh.zzm(3, this.zzaIF);
        }
        int n4 = n3;
        if (this.zzbvA != null) {
            n4 = n3 + adh.zze(4, this.zzbvA);
        }
        int n5 = n4;
        if (this.zzbuA != null) {
            this.zzbuA;
            n5 = n4 + (adh.zzct(5) + 4);
        }
        int n6 = n5;
        if (this.zzbuB != null) {
            this.zzbuB;
            n6 = n5 + (adh.zzct(6) + 8);
        }
        return n6;
    }
}
