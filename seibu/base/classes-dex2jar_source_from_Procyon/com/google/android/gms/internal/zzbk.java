// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbk extends adj<zzbk>
{
    private static volatile zzbk[] zzkE;
    public String key;
    public long zzkF;
    public long zzkG;
    public boolean zzkH;
    public long zzkI;
    
    public zzbk() {
        this.key = "";
        this.zzkF = 0L;
        this.zzkG = 2147483647L;
        this.zzkH = false;
        this.zzkI = 0L;
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzbk[] zzq() {
        Label_0027: {
            if (zzbk.zzkE != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzbk.zzkE == null) {
                    zzbk.zzkE = new zzbk[0];
                }
                return zzbk.zzkE;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbk)) {
                return false;
            }
            final zzbk zzbk = (zzbk)o;
            if (this.key == null) {
                if (zzbk.key != null) {
                    return false;
                }
            }
            else if (!this.key.equals(zzbk.key)) {
                return false;
            }
            if (this.zzkF != zzbk.zzkF) {
                return false;
            }
            if (this.zzkG != zzbk.zzkG) {
                return false;
            }
            if (this.zzkH != zzbk.zzkH) {
                return false;
            }
            if (this.zzkI != zzbk.zzkI) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbk.zzcso);
            }
            if (zzbk.zzcso != null && !zzbk.zzcso.isEmpty()) {
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
        if (this.key == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.key.hashCode();
        }
        final int n2 = (int)(this.zzkF ^ this.zzkF >>> 32);
        final int n3 = (int)(this.zzkG ^ this.zzkG >>> 32);
        int n4;
        if (this.zzkH) {
            n4 = 1231;
        }
        else {
            n4 = 1237;
        }
        final int n5 = (int)(this.zzkI ^ this.zzkI >>> 32);
        int hashCode3 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode3 = n;
            }
            else {
                hashCode3 = this.zzcso.hashCode();
            }
        }
        return ((n4 + (((hashCode2 + (hashCode + 527) * 31) * 31 + n2) * 31 + n3) * 31) * 31 + n5) * 31 + hashCode3;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        if (this.key != null && !this.key.equals("")) {
            adh.zzl(1, this.key);
        }
        if (this.zzkF != 0L) {
            adh.zzb(2, this.zzkF);
        }
        if (this.zzkG != 2147483647L) {
            adh.zzb(3, this.zzkG);
        }
        if (this.zzkH) {
            adh.zzk(4, this.zzkH);
        }
        if (this.zzkI != 0L) {
            adh.zzb(5, this.zzkI);
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        int zzn;
        final int n = zzn = super.zzn();
        if (this.key != null) {
            zzn = n;
            if (!this.key.equals("")) {
                zzn = n + adh.zzm(1, this.key);
            }
        }
        int n2 = zzn;
        if (this.zzkF != 0L) {
            n2 = zzn + adh.zze(2, this.zzkF);
        }
        int n3 = n2;
        if (this.zzkG != 2147483647L) {
            n3 = n2 + adh.zze(3, this.zzkG);
        }
        int n4 = n3;
        if (this.zzkH) {
            n4 = n3 + (adh.zzct(4) + 1);
        }
        int n5 = n4;
        if (this.zzkI != 0L) {
            n5 = n4 + adh.zze(5, this.zzkI);
        }
        return n5;
    }
}
