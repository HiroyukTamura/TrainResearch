// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjt extends adj<zzcjt>
{
    public String zzboQ;
    public Long zzbvl;
    private Integer zzbvm;
    public zzcju[] zzbvn;
    public zzcjs[] zzbvo;
    public zzcjm[] zzbvp;
    
    public zzcjt() {
        this.zzbvl = null;
        this.zzboQ = null;
        this.zzbvm = null;
        this.zzbvn = zzcju.zzzz();
        this.zzbvo = zzcjs.zzzy();
        this.zzbvp = zzcjm.zzzu();
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjt)) {
                return false;
            }
            final zzcjt zzcjt = (zzcjt)o;
            if (this.zzbvl == null) {
                if (zzcjt.zzbvl != null) {
                    return false;
                }
            }
            else if (!this.zzbvl.equals(zzcjt.zzbvl)) {
                return false;
            }
            if (this.zzboQ == null) {
                if (zzcjt.zzboQ != null) {
                    return false;
                }
            }
            else if (!this.zzboQ.equals(zzcjt.zzboQ)) {
                return false;
            }
            if (this.zzbvm == null) {
                if (zzcjt.zzbvm != null) {
                    return false;
                }
            }
            else if (!this.zzbvm.equals(zzcjt.zzbvm)) {
                return false;
            }
            if (!adn.equals(this.zzbvn, zzcjt.zzbvn)) {
                return false;
            }
            if (!adn.equals(this.zzbvo, zzcjt.zzbvo)) {
                return false;
            }
            if (!adn.equals(this.zzbvp, zzcjt.zzbvp)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjt.zzcso);
            }
            if (zzcjt.zzcso != null && !zzcjt.zzcso.isEmpty()) {
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
        if (this.zzbvl == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbvl.hashCode();
        }
        int hashCode3;
        if (this.zzboQ == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzboQ.hashCode();
        }
        int hashCode4;
        if (this.zzbvm == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbvm.hashCode();
        }
        final int hashCode5 = adn.hashCode(this.zzbvn);
        final int hashCode6 = adn.hashCode(this.zzbvo);
        final int hashCode7 = adn.hashCode(this.zzbvp);
        int hashCode8 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode8 = n;
            }
            else {
                hashCode8 = this.zzcso.hashCode();
            }
        }
        return ((((hashCode4 + (hashCode3 + (hashCode2 + (hashCode + 527) * 31) * 31) * 31) * 31 + hashCode5) * 31 + hashCode6) * 31 + hashCode7) * 31 + hashCode8;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzbvl != null) {
            adh.zzb(1, this.zzbvl);
        }
        if (this.zzboQ != null) {
            adh.zzl(2, this.zzboQ);
        }
        if (this.zzbvm != null) {
            adh.zzr(3, this.zzbvm);
        }
        if (this.zzbvn != null && this.zzbvn.length > 0) {
            for (int i = 0; i < this.zzbvn.length; ++i) {
                final zzcju zzcju = this.zzbvn[i];
                if (zzcju != null) {
                    adh.zza(4, zzcju);
                }
            }
        }
        if (this.zzbvo != null && this.zzbvo.length > 0) {
            for (int j = 0; j < this.zzbvo.length; ++j) {
                final zzcjs zzcjs = this.zzbvo[j];
                if (zzcjs != null) {
                    adh.zza(5, zzcjs);
                }
            }
        }
        if (this.zzbvp != null && this.zzbvp.length > 0) {
            for (int k = n; k < this.zzbvp.length; ++k) {
                final zzcjm zzcjm = this.zzbvp[k];
                if (zzcjm != null) {
                    adh.zza(6, zzcjm);
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
        if (this.zzbvl != null) {
            zzn = n2 + adh.zze(1, this.zzbvl);
        }
        int n3 = zzn;
        if (this.zzboQ != null) {
            n3 = zzn + adh.zzm(2, this.zzboQ);
        }
        int n4 = n3;
        if (this.zzbvm != null) {
            n4 = n3 + adh.zzs(3, this.zzbvm);
        }
        int n5 = n4;
        if (this.zzbvn != null) {
            n5 = n4;
            if (this.zzbvn.length > 0) {
                int n6;
                for (int i = 0; i < this.zzbvn.length; ++i, n4 = n6) {
                    final zzcju zzcju = this.zzbvn[i];
                    n6 = n4;
                    if (zzcju != null) {
                        n6 = n4 + adh.zzb(4, zzcju);
                    }
                }
                n5 = n4;
            }
        }
        int n7 = n5;
        if (this.zzbvo != null) {
            n7 = n5;
            if (this.zzbvo.length > 0) {
                n7 = n5;
                int n8;
                for (int j = 0; j < this.zzbvo.length; ++j, n7 = n8) {
                    final zzcjs zzcjs = this.zzbvo[j];
                    n8 = n7;
                    if (zzcjs != null) {
                        n8 = n7 + adh.zzb(5, zzcjs);
                    }
                }
            }
        }
        int n9 = n7;
        if (this.zzbvp != null) {
            n9 = n7;
            if (this.zzbvp.length > 0) {
                int n10 = n;
                while (true) {
                    n9 = n7;
                    if (n10 >= this.zzbvp.length) {
                        break;
                    }
                    final zzcjm zzcjm = this.zzbvp[n10];
                    int n11 = n7;
                    if (zzcjm != null) {
                        n11 = n7 + adh.zzb(6, zzcjm);
                    }
                    ++n10;
                    n7 = n11;
                }
            }
        }
        return n9;
    }
}
