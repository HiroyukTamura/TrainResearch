// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjo extends adj<zzcjo>
{
    private static volatile zzcjo[] zzbuR;
    public zzcjr zzbuS;
    public zzcjp zzbuT;
    public Boolean zzbuU;
    public String zzbuV;
    
    public zzcjo() {
        this.zzbuS = null;
        this.zzbuT = null;
        this.zzbuU = null;
        this.zzbuV = null;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjo[] zzzw() {
        Label_0027: {
            if (zzcjo.zzbuR != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjo.zzbuR == null) {
                    zzcjo.zzbuR = new zzcjo[0];
                }
                return zzcjo.zzbuR;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjo)) {
                return false;
            }
            final zzcjo zzcjo = (zzcjo)o;
            if (this.zzbuS == null) {
                if (zzcjo.zzbuS != null) {
                    return false;
                }
            }
            else if (!this.zzbuS.equals(zzcjo.zzbuS)) {
                return false;
            }
            if (this.zzbuT == null) {
                if (zzcjo.zzbuT != null) {
                    return false;
                }
            }
            else if (!this.zzbuT.equals(zzcjo.zzbuT)) {
                return false;
            }
            if (this.zzbuU == null) {
                if (zzcjo.zzbuU != null) {
                    return false;
                }
            }
            else if (!this.zzbuU.equals(zzcjo.zzbuU)) {
                return false;
            }
            if (this.zzbuV == null) {
                if (zzcjo.zzbuV != null) {
                    return false;
                }
            }
            else if (!this.zzbuV.equals(zzcjo.zzbuV)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjo.zzcso);
            }
            if (zzcjo.zzcso != null && !zzcjo.zzcso.isEmpty()) {
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
        if (this.zzbuS == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.zzbuS.hashCode();
        }
        int hashCode3;
        if (this.zzbuT == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.zzbuT.hashCode();
        }
        int hashCode4;
        if (this.zzbuU == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.zzbuU.hashCode();
        }
        int hashCode5;
        if (this.zzbuV == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzbuV.hashCode();
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
        if (this.zzbuS != null) {
            adh.zza(1, this.zzbuS);
        }
        if (this.zzbuT != null) {
            adh.zza(2, this.zzbuT);
        }
        if (this.zzbuU != null) {
            adh.zzk(3, this.zzbuU);
        }
        if (this.zzbuV != null) {
            adh.zzl(4, this.zzbuV);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.zzbuS != null) {
            zzn = n + adh.zzb(1, this.zzbuS);
        }
        int n2 = zzn;
        if (this.zzbuT != null) {
            n2 = zzn + adh.zzb(2, this.zzbuT);
        }
        int n3 = n2;
        if (this.zzbuU != null) {
            this.zzbuU;
            n3 = n2 + (adh.zzct(3) + 1);
        }
        int n4 = n3;
        if (this.zzbuV != null) {
            n4 = n3 + adh.zzm(4, this.zzbuV);
        }
        return n4;
    }
}
