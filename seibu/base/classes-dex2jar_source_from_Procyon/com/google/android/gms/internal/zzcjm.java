// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcjm extends adj<zzcjm>
{
    private static volatile zzcjm[] zzbuH;
    public Integer zzbuI;
    public zzcjq[] zzbuJ;
    public zzcjn[] zzbuK;
    
    public zzcjm() {
        this.zzbuI = null;
        this.zzbuJ = zzcjq.zzzx();
        this.zzbuK = zzcjn.zzzv();
        this.zzcso = null;
        this.zzcsx = -1;
    }
    
    public static zzcjm[] zzzu() {
        Label_0027: {
            if (zzcjm.zzbuH != null) {
                break Label_0027;
            }
            synchronized (adn.zzcsw) {
                if (zzcjm.zzbuH == null) {
                    zzcjm.zzbuH = new zzcjm[0];
                }
                return zzcjm.zzbuH;
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof zzcjm)) {
                return false;
            }
            final zzcjm zzcjm = (zzcjm)o;
            if (this.zzbuI == null) {
                if (zzcjm.zzbuI != null) {
                    return false;
                }
            }
            else if (!this.zzbuI.equals(zzcjm.zzbuI)) {
                return false;
            }
            if (!adn.equals(this.zzbuJ, zzcjm.zzbuJ)) {
                return false;
            }
            if (!adn.equals(this.zzbuK, zzcjm.zzbuK)) {
                return false;
            }
            if (this.zzcso != null && !this.zzcso.isEmpty()) {
                return this.zzcso.equals(zzcjm.zzcso);
            }
            if (zzcjm.zzcso != null && !zzcjm.zzcso.isEmpty()) {
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
        final int hashCode3 = adn.hashCode(this.zzbuJ);
        final int hashCode4 = adn.hashCode(this.zzbuK);
        int hashCode5 = n;
        if (this.zzcso != null) {
            if (this.zzcso.isEmpty()) {
                hashCode5 = n;
            }
            else {
                hashCode5 = this.zzcso.hashCode();
            }
        }
        return (((hashCode2 + (hashCode + 527) * 31) * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5;
    }
    
    @Override
    public final void zza(final adh adh) throws IOException {
        final int n = 0;
        if (this.zzbuI != null) {
            adh.zzr(1, this.zzbuI);
        }
        if (this.zzbuJ != null && this.zzbuJ.length > 0) {
            for (int i = 0; i < this.zzbuJ.length; ++i) {
                final zzcjq zzcjq = this.zzbuJ[i];
                if (zzcjq != null) {
                    adh.zza(2, zzcjq);
                }
            }
        }
        if (this.zzbuK != null && this.zzbuK.length > 0) {
            for (int j = n; j < this.zzbuK.length; ++j) {
                final zzcjn zzcjn = this.zzbuK[j];
                if (zzcjn != null) {
                    adh.zza(3, zzcjn);
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
        if (this.zzbuI != null) {
            zzn = n2 + adh.zzs(1, this.zzbuI);
        }
        int n3 = zzn;
        if (this.zzbuJ != null) {
            n3 = zzn;
            if (this.zzbuJ.length > 0) {
                n3 = zzn;
                int n4;
                for (int i = 0; i < this.zzbuJ.length; ++i, n3 = n4) {
                    final zzcjq zzcjq = this.zzbuJ[i];
                    n4 = n3;
                    if (zzcjq != null) {
                        n4 = n3 + adh.zzb(2, zzcjq);
                    }
                }
            }
        }
        int n5 = n3;
        if (this.zzbuK != null) {
            n5 = n3;
            if (this.zzbuK.length > 0) {
                int n6 = n;
                while (true) {
                    n5 = n3;
                    if (n6 >= this.zzbuK.length) {
                        break;
                    }
                    final zzcjn zzcjn = this.zzbuK[n6];
                    int n7 = n3;
                    if (zzcjn != null) {
                        n7 = n3 + adh.zzb(3, zzcjn);
                    }
                    ++n6;
                    n3 = n7;
                }
            }
        }
        return n5;
    }
}
