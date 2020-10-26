// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzbl extends adj<zzbl>
{
    public zzbr[] zzkJ;
    public zzbr[] zzkK;
    public zzbk[] zzkL;
    
    public zzbl() {
        this.zzkJ = zzbr.zzu();
        this.zzkK = zzbr.zzu();
        this.zzkL = zzbk.zzq();
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzbl)) {
                return false;
            }
            final zzbl zzbl = (zzbl)o;
            if (!adn.equals(this.zzkJ, zzbl.zzkJ)) {
                return false;
            }
            if (!adn.equals(this.zzkK, zzbl.zzkK)) {
                return false;
            }
            if (!adn.equals(this.zzkL, zzbl.zzkL)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzbl.zzcso);
            }
            if (zzbl.zzcso != null && !zzbl.zzcso.isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.getClass().getName().hashCode();
        final int hashCode2 = adn.hashCode(this.zzkJ);
        final int hashCode3 = adn.hashCode(this.zzkK);
        final int hashCode4 = adn.hashCode(this.zzkL);
        int hashCode5;
        if (this.zzcso == null || this.zzcso.isEmpty()) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.zzcso.hashCode();
        }
        return hashCode5 + ((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzkJ != null && this.zzkJ.length > 0) {
            for (int i = 0; i < this.zzkJ.length; ++i) {
                final zzbr zzbr = this.zzkJ[i];
                if (zzbr != null) {
                    adh.zza(1, zzbr);
                }
            }
        }
        if (this.zzkK != null && this.zzkK.length > 0) {
            for (int j = 0; j < this.zzkK.length; ++j) {
                final zzbr zzbr2 = this.zzkK[j];
                if (zzbr2 != null) {
                    adh.zza(2, zzbr2);
                }
            }
        }
        if (this.zzkL != null && this.zzkL.length > 0) {
            for (int k = n; k < this.zzkL.length; ++k) {
                final zzbk zzbk = this.zzkL[k];
                if (zzbk != null) {
                    adh.zza(3, zzbk);
                }
            }
        }
        super.zza(adh);
    }
    
    @Override
    protected final int zzn() {
        final int n = 0;
        int zzn;
        int n2 = zzn = super.zzn();
        if (this.zzkJ != null) {
            zzn = n2;
            if (this.zzkJ.length > 0) {
                int n3;
                for (int i = 0; i < this.zzkJ.length; ++i, n2 = n3) {
                    final zzbr zzbr = this.zzkJ[i];
                    n3 = n2;
                    if (zzbr != null) {
                        n3 = n2 + adh.zzb(1, zzbr);
                    }
                }
                zzn = n2;
            }
        }
        int n4 = zzn;
        if (this.zzkK != null) {
            n4 = zzn;
            if (this.zzkK.length > 0) {
                n4 = zzn;
                int n5;
                for (int j = 0; j < this.zzkK.length; ++j, n4 = n5) {
                    final zzbr zzbr2 = this.zzkK[j];
                    n5 = n4;
                    if (zzbr2 != null) {
                        n5 = n4 + adh.zzb(2, zzbr2);
                    }
                }
            }
        }
        int n6 = n4;
        if (this.zzkL != null) {
            n6 = n4;
            if (this.zzkL.length > 0) {
                int n7 = n;
                while (true) {
                    n6 = n4;
                    if (n7 >= this.zzkL.length) {
                        break;
                    }
                    final zzbk zzbk = this.zzkL[n7];
                    int n8 = n4;
                    if (zzbk != null) {
                        n8 = n4 + adh.zzb(3, zzbk);
                    }
                    ++n7;
                    n4 = n8;
                }
            }
        }
        return n6;
    }
}
